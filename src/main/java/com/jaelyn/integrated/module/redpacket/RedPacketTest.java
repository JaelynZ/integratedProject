package com.jaelyn.integrated.module.redpacket;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

/**
 * 抢红包测试
 *
 * @author zjaelyn@gmail.com
 * @date 2020-03-06 15:27
 **/
public class RedPacketTest {
    public static void main(String[] args) throws Exception {
        //总金额
        BigDecimal totalAmount = new BigDecimal(String.valueOf("100"));
        //红包个数
        int count = 10;
        //抢红包人数
        int peopleNum = 100;
        CountDownLatch latch = new CountDownLatch(peopleNum);
        ConcurrentHashMap<String, RedPacketShow> userRedPacketMap = new ConcurrentHashMap<>(count);
        RedPacket redPacket = new RedPacket(totalAmount, count);
        RedPacketUser user = new RedPacketUser(redPacket, userRedPacketMap, latch);
        for (int i = 0; i < peopleNum; i++) {
            new Thread(user).start();
        }
        latch.await();
        List<RedPacketShow> shows = Lists.newArrayList();
        for (ConcurrentHashMap.Entry<String, RedPacketShow> entry : userRedPacketMap.entrySet()) {
            shows.add(entry.getValue());
        }
        //按抢红包的时间顺序进行排序,如时间相同再按名字排序
        shows = shows.stream().sorted(Comparator.comparing(RedPacketShow::getGrabTime).thenComparing(RedPacketShow::getName)).collect(Collectors.toList());
        //设置最佳
        int bestShowPosition = 0;
        for (int i = 0; i < shows.size(); i++) {
            if (shows.get(bestShowPosition).getAmount().compareTo(shows.get(i).getAmount()) < 0) {
                bestShowPosition = i;
            }
        }
        shows.get(bestShowPosition).setBestFlag(1);
        System.out.println(JSON.toJSONString(shows));
    }


}
