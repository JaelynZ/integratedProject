package com.jaelyn.integrated.module.algorithm;

/**
 * 查找算法
 *
 * @author Jaelyn
 * @date 2021/3/23 14:29
 **/
public class Search {

    //https://blog.csdn.net/qq_35398517/article/details/112209226

    /**
     * 问题：现有一个n*n的二维正整数数组nums，每行元素保证递增，每列元素保证递增，求某正整数x是否存在于该二维数组中，需要尽量优化时间和空间复杂度
     * <p>
     * 二分查找法
     *
     * @param nums 二位数组
     * @param x    查找的数字
     * @return
     */
    public static boolean searchMatrix(int[][] nums, int x) {
        if (nums == null || nums[0] == null) {
            return false;
        }
        // 从最右侧的最大值开始判断，小于直接跳行，大于，则依次递减查找
        int i = 0;
        int j = nums[0].length - 1;
        while (i < nums.length && j >= 0) {
            if (nums[i][j] == x) {
                return true;
            } else if (nums[i][j] > x) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }

    /**
     * 给定一个二叉树, 检查它是否是镜像对称的
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isTreeSymmetric(TreeNode root) {
        return isSame(root, root);
    }

    public static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        // 根节点值的比较，左节点和右节点比较，右节点和左节点比较
        return t1.val == t2.val && isSame(t1.left, t2.right) && isSame(t1.right, t2.left);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int x = 5;
        System.out.println(searchMatrix(nums, x));



    }


}
