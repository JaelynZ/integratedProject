package com.jaelyn.integrated.module.thread;

/**
 * 双重校验锁实现对象单例（线程安全）
 *
 * @author jaelynz@gamil.com
 * @date 2020-07-16 14:54
 **/
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {

    }

    public synchronized static Singleton getUniqueInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
