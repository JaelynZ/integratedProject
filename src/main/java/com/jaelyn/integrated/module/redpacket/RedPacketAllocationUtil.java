package com.jaelyn.integrated.module.redpacket;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;

/**
 * 红包分配算法
 *
 * @author zjaelyn@gmail.com
 * @date 2020-03-06 10:13
 **/
public class RedPacketAllocationUtil {
    /**
     * 1.总金额不能超过200*100 单位是分
     * 2.每个红包都要有钱，最低不能低于1分，最大金额不能超过200*100
     */
    private static final int MIN_MONEY = 1;
    private static final int MAX_MONEY = 200 * 100;
    /**
     * 这里为了避免某一个红包占用大量资金，我们需要设定非最后一个红包的最大金额，我们把他设置为红包金额平均值的N倍；
     */
    private static final double TIMES = 2.5;

    /**
     * 拆分红包
     *
     * @param totalAmount ：红包总金额
     * @param count       ：个数
     * @return 红包集合
     */
    public static List<BigDecimal> splitRedPackets(BigDecimal totalAmount, int count) {
        if (totalAmount.compareTo(BigDecimal.ZERO) <= 0 || count == 0) {
            return Lists.newArrayList();
        }
        //int比BigDecimal计算效率高，且精度为分（小数点2位），所以先进行int转化处理
        int money = (totalAmount.multiply(new BigDecimal(100))).intValue();
        //红包 合法性校验
        if (!isRight(money, count)) {
            return Lists.newArrayList();
        }
        //红包列表
        List<BigDecimal> list = Lists.newArrayList();
        //每个红包最大的金额为平均金额的Times 倍
        int max = (int) (money * TIMES / count);
        max = max > MAX_MONEY ? MAX_MONEY : max;
        //分配红包
        for (int i = 0; i < count; i++) {
            int one = randomRedPacket(money, MIN_MONEY, max, count - i);
            BigDecimal amountValue = new BigDecimal((double) one / 100).setScale(2, RoundingMode.HALF_UP);
            list.add(amountValue);
            money -= one;
        }
        //对生成的红包集合进行乱序处理，避免人数过多导致后面出现的红包都为0.01金额
        Collections.shuffle(list);
        return list;
    }

    /**
     * 随机分配一个红包
     *
     * @param amount    金额
     * @param minAmount 最小金额
     * @param maxAmount 最大金额(每个红包的默认Times倍最大值)
     * @param count     剩余未分配个数
     * @return 红包金额
     */
    private static int randomRedPacket(int amount, int minAmount, int maxAmount, int count) {
        //若是只有一个，直接返回红包
        if (count == 1) {
            return amount;
        }
        //若是最小金额红包 == 最大金额红包， 直接返回最小金额红包
        if (minAmount == maxAmount) {
            return minAmount;
        }
        //校验 最大值 max 要是比amount 金额高的话？ 取 amount 金额
        int max = maxAmount > amount ? amount : maxAmount;
        //随机一个红包 = 随机一个数* (金额-最小)+最小
        int one = ((int) Math.rint(Math.random() * (max - minAmount) + minAmount));
        //剩下的金额
        int remainAmount = amount - one;
        //校验这种随机方案是否可行，不合法的话，就要重新分配方案
        if (isRight(remainAmount, count - 1)) {
            return one;
        } else {
            //重新分配
            double avg = remainAmount / (count - 1);
            //本次红包过大，导致下次的红包过小；如果红包过大，下次就随机一个小值到本次红包金额的一个红包
            if (avg < MIN_MONEY) {
                //递归调用，修改红包最大金额
                return randomRedPacket(amount, minAmount, one, count);
            } else if (avg > MAX_MONEY) {
                //递归调用，修改红包最小金额
                return randomRedPacket(amount, one, maxAmount, count);
            }
        }
        return one;
    }

    /**
     * 红包 合法性校验
     *
     * @param amount 金额
     * @param count  总数
     * @return
     */
    private static boolean isRight(int amount, int count) {
        double avg = amount / count;
        //小于最小金额
        if (avg < MIN_MONEY) {
            return false;
        }
        //大于最大金额
        if (avg > MAX_MONEY) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        //随机一个188.88  5个红包
        //单位是分
        BigDecimal amount = BigDecimal.valueOf(200.01);
        int count = 100;
        System.out.println("分配前--总金额=" + amount + ";总人数：" + count);
        List<BigDecimal> allocationList = splitRedPackets(amount, count);
        List<BigDecimal> amounts = Lists.newArrayList();
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (BigDecimal value : allocationList) {
            totalAmount = totalAmount.add(value);
            amounts.add(value);
        }
        System.out.println(amounts);
        System.out.println("分配后--总金额=" + totalAmount + ";总人数：" + allocationList.size());
    }
}
