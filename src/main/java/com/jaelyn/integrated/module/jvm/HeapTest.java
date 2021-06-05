package com.jaelyn.integrated.module.jvm;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-08-07 15:02
 **/
public class HeapTest {
    public static final String LA = "abc";
    byte[] buff = new byte[new Random().nextInt(1024 * 200)];

    public static void main(String[] args) {
        List<HeapTest> heapTestList = Lists.newArrayList();
        while (true) {
            heapTestList.add(new HeapTest());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {

            }
        }

    }
}
