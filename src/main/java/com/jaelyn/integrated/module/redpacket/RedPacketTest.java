package com.jaelyn.integrated.module.redpacket;

import java.math.BigDecimal;

/**
 * 抢红包测试
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-03-06 15:27
 **/
public class RedPacketTest {
    public static void main(String[] args) {
        //总金额
        BigDecimal totalAmount = new BigDecimal(String.valueOf("100"));
        //红包个数
        int count = 10;
        //抢红包人数
        int peopleNum = 500;
        RedPacket redPacket = new RedPacket(totalAmount, count);
        RedPacketUser user = new RedPacketUser(redPacket);
        for (int i = 0; i < peopleNum; i++) {
            new Thread(user).start();
        }
    }
}
