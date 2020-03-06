package com.jaelyn.integrated.module.redpacket;

import java.math.BigDecimal;

/**
 * 红包用户线程
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-03-06 15:24
 **/
public class RedPacketUser implements Runnable{
    private RedPacket redPacket;

    public RedPacketUser(RedPacket redPacket) {
        this.redPacket = redPacket;
    }

    @Override
    public void run() {
        BigDecimal money = redPacket.getRandomAmount();
        if(money.compareTo(BigDecimal.ZERO) == 0) {
            System.out.println(Thread.currentThread().getName() + "不好意思，您手慢了！");
        }else {
            System.out.println(Thread.currentThread().getName() + "抢到 " + money + "元");
        }
    }
}
