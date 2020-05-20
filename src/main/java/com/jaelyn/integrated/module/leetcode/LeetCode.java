package com.jaelyn.integrated.module.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode
 *
 * @author jaelynz@gamil.com
 * @date 2020-04-29 15:08
 **/
public class LeetCode {
    public static void main(String args[]) {
        String[] str = new String[]{"flaaaower", "flaaow", "flaight"};
        System.out.println(longestCommonPrefix(str));
    }


    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0) {
            return result;
        }
        String minStr = strs[0];
        for (int i = 0; i < minStr.length(); i++) {
            String prefixStr = minStr.substring(0, i + 1);
            int existNum = 0;
            for (String str : strs) {
                if (str.indexOf(prefixStr) == 0) {
                    existNum++;
                }
            }
            if (existNum == strs.length) {
                //说明字符串数组里面每个字符串都包含此相同前缀
                result = prefixStr;
            } else {
                break;
            }
        }

        return result;
    }
}
