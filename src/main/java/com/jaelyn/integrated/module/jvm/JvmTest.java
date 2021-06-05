package com.jaelyn.integrated.module.jvm;

/**
 * TODO
 *
 * @author jingling.zhang@ucarinc.com
 * @date 2020-08-18 17:41
 **/
public class JvmTest {
    public static void main(String[] args) {
        //String x = "12";
        String s1 = new String("1") + new String("2");
        String s2 = s1.intern();
        System.out.println(s1 == "12");
        System.out.println(s2 == "12");
        while (true){

        }

    }
}
