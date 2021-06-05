package com.jaelyn.integrated.module.algorithm;

import java.util.concurrent.locks.ReentrantLock;

/**
 * MetaApp算法
 *
 * @author Jaelyn
 * @date 2021/4/8 11:20
 **/
public class MetaApp {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * 输入: [2,2,1]
     * 输出: 1
     * <p>
     * 示例2:
     * 输入: [4,1,2,1,2]
     * 输出: 4
     * <p>
     * 根据位异或的运算法则，2^2^3^1^1=0^3^0=3；
     * 异或运算：转换为二进制，两者相等为0，不等为1
     *
     * @param nums 非空整数数组
     * @return
     */
    public static int singleNumber(int[] nums) {
        //不能写伪代码，要考虑时间复杂度
        //方法一：异或运算
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        //方法二：

        return result;
    }

    /**
     * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * <p>
     * 示例 2：
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     *
     * @param prices 价格数组
     * @return
     */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的
     * <p>
     * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
     * 1
     * / \
     * 2  2
     * / \ / \
     * 3 4 4 3
     * <p>
     * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2  2
     * \  \
     * 3  3
     *
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    public static boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null || R == null || L.val != R.val) {
            return false;
        }
        return recur(L.left, R.right) && recur(L.right, R.left);
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 2, 5, 5, 1};
        int[] prices = {7, 3, 4, 6, 1};
        //System.out.println(singleNumber(nums));
        //System.out.println(maxProfit(prices));
        TreeNode root = new TreeNode(1);
        TreeNode L2 = new TreeNode(2);
        TreeNode R2 = new TreeNode(2);
        root.left = L2;
        root.right = R2;
        TreeNode LL3 = new TreeNode(3);
        TreeNode LR3 = new TreeNode(4);
        TreeNode RL3 = new TreeNode(4);
        TreeNode RR3 = new TreeNode(3);
        L2.left = LL3;
        L2.right = LR3;
        R2.left = RL3;
        R2.right = RR3;
        System.out.println(isSymmetric(root));
    }
}
