package com.jaelyn.integrated.module.distributedid;

import com.jaelyn.integrated.common.utils.ThreadPoolUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * zk实现分布式ID生成
 *
 * @author jaelynz@gamil.com
 * @date 2020-05-20 17:23
 **/
@Component
@Slf4j
public class DistributedIdGenerateService {
    private static CuratorFramework curatorFrameworkClient;
    private static RetryPolicy retryPolicy;
    private static String ZK_CLUSTER = "127.0.0.1:2181";
    private static String ROOT = "/root";
    private static String NODE_NAME = "idgenerator";

    static {
        retryPolicy = new ExponentialBackoffRetry(1000, 3);
        curatorFrameworkClient = CuratorFrameworkFactory.builder()
                .connectString(ZK_CLUSTER)
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy).build();
        curatorFrameworkClient.start();
        try {
            //请先判断父节点/root节点是否存在
            Stat stat = curatorFrameworkClient.checkExists().forPath(ROOT);
            if (stat == null) {
                curatorFrameworkClient.create().withMode(CreateMode.PERSISTENT).forPath(ROOT, null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("DistributedIdGenerateService初始化失败,error:{}", e.getMessage());
        }
    }

    public String generateId() {
        String backPath = "";
        String fullPath = ROOT.concat("/").concat(NODE_NAME);
        String id = "";
        try {
            //关键点：创建持久顺序节点
            backPath = curatorFrameworkClient.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath(fullPath, null);
            //为防止生成的节点浪费系统资源，故生成后异步删除此节点
            String finalBackPath = backPath;
            ThreadPoolUtils.execute(() -> {
                try {
                    curatorFrameworkClient.delete().forPath(finalBackPath);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error("zk节点删除失败,error:{}", e.getMessage());
                }
            });
            id = splitId(backPath);
            log.info("zk生成的分布式id={}", id);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("zk节点生成失败,error:{}", e.getMessage());
        }
        return id;
    }

    private String splitId(String path) {
        int index = path.lastIndexOf(NODE_NAME);
        if (index >= 0) {
            index += NODE_NAME.length();
            return index <= path.length() ? path.substring(index) : "";
        }
        return path;
    }
}
