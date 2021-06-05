package com.jaelyn.integrated.module.set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 集合
 *
 * @author Jaelyn
 * @date 2021/4/5 11:35
 **/
public class Set {
    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap<>();
        HashMap map1 = new HashMap<>();
        HashSet set = new HashSet();
        //map.put(null,"123");
        //map1.put(null,"123");
        //set.add(null);
        System.out.println(set.contains(null));
    }
}
