package com.jaelyn.integrated.module.redpacket;

import java.math.BigDecimal;
import java.util.List;

/**
 * 红包
 *
 * @author zjaelyn@gmail.com
 * @date 2020-03-06 15:17
 **/
public class RedPacket {
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
    /**
     * 红包个数
     */
    private int count;
    /**
     * 红包分配集合
     */
    private List<BigDecimal> redPacketList;

    public RedPacket(BigDecimal totalAmount, int count) {
        this.totalAmount = totalAmount;
        this.count = count;
        this.redPacketList = RedPacketAllocationUtil.splitRedPackets(totalAmount, count);
    }

    public synchronized BigDecimal getRandomAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        if (count > 0) {
            amount = redPacketList.get(count - 1);
        }
        count--;
        return amount;
    }
}
