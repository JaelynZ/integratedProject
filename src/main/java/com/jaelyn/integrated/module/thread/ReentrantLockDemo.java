package com.jaelyn.integrated.module.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author jaelynz@gamil.com
 * @date 2020-07-16 15:16
 **/
public class ReentrantLockDemo {
    private volatile static Object lock = new Object();
    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        System.out.println("准备获取lock锁");

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("获取到lock锁");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("准备再次获取lock锁");
                synchronized (lock) {
                    System.out.println("再次获取到lock锁");
                }
            }

            try {
                reentrantLock.lock();
                System.out.println("获取锁");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                reentrantLock.unlock();
                System.out.println("释放锁");
            }


        }, "线程 1").start();
    }
}
