package com.jaelyn.integrated.module.jvm;

/**
 * 栈溢出
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-08-05 10:35
 * 默认      count=11408
 * -Xss128k count=973
 **/
public class StackOverFlowTest {
    public static final String LA = "efg";
    private static int count = 0;
    private static int total = 0;


    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }

    public void test1() {
        int a = 1;
        long b = 0l;
        double c = 0.0;
    }
}
