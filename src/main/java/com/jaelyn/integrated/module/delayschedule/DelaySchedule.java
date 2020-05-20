package com.jaelyn.integrated.module.delayschedule;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-04-28 9:30
 **/
public class DelaySchedule {

    public static void main(String args[]) {
        RingQueue queue = new RingQueue(10);
        for (int i = 0; i < 95; i++) {
            queue.push(i);
        }
        System.out.println(queue);
    }
}
