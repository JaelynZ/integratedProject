package com.jaelyn.integrated.module.redpacket;

import com.jaelyn.integrated.common.utils.DateUtil;
import com.jaelyn.integrated.common.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import sun.rmi.runtime.Log;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * 红包用户线程
 *
 * @author zjaelyn@gmail.com
 * @date 2020-03-06 15:24
 **/
@Slf4j
public class RedPacketUser implements Runnable {
    private RedPacket redPacket;
    private ConcurrentHashMap<String, RedPacketShow> userRedPacketMap;
    private CountDownLatch latch;

    public RedPacketUser(RedPacket redPacket, ConcurrentHashMap<String, RedPacketShow> userRedPacketMap, CountDownLatch latch) {
        this.redPacket = redPacket;
        this.userRedPacketMap = userRedPacketMap;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            BigDecimal money = redPacket.getRandomAmount();
            if (money.compareTo(BigDecimal.ZERO) == 0) {
                System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了！");
            } else {
                System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
                long currentTime = System.currentTimeMillis();
                RedPacketShow show = RedPacketShow.builder()
                        .name(Thread.currentThread().getName())
                        .amount(money)
                        .bestFlag(0)
                        .showTime(DateUtil.timeToString(new Date(currentTime)))
                        .grabTime(currentTime)
                        .build();
                userRedPacketMap.put(Thread.currentThread().getName(), show);
            }
        } catch (Exception e) {
            log.error("{}获取红包失败：{}", Thread.currentThread().getName(), LogUtil.printStackTrace(e));
        } finally {
            latch.countDown();
        }
    }
}
