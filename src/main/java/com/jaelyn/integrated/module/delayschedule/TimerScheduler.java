package com.jaelyn.integrated.module.delayschedule;

import java.io.IOException;
import java.util.Iterator;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * 用于判断定时器是否到时、执行任务、维护定时器状态。
 * @author wensh.zhu
 * @date 2018-04-22
 */
public class TimerScheduler extends TimerTask {

    private TimerContext timerContext;

    public TimerScheduler() {}

    public TimerScheduler(TimerContext timerContext) {
        this.timerContext = timerContext;
    }

    /**
     * 定时检测，如果定时器触发时间到了就从集合中删除并执行任务，否则圈数减一。
     */
    @Override
    public void run() {
        if (timerContext == null)
            return;

        Queue<TaskHolder> tasks = timerContext.getCurrentTasks();
        synchronized (tasks) {
            Iterator<TaskHolder> itor = tasks.iterator();
            while (itor.hasNext()) {
                TaskHolder timer = itor.next();
                if (timer.isTimeOut()) {
                    itor.remove();
                    new Thread(timer.getTask()).start();
                } else {
                    timer.cutDown();
                }
            }

        }

        timerContext.tick();
    }

    public void addTask(Runnable task, int delays) {
        timerContext.addTask(task, delays);
    }

    public TimerContext getTimerContext() {
        return timerContext;
    }

    public void setTimerContext(TimerContext timerContext) {
        this.timerContext = timerContext;
    }

    public static void main(String[] args) throws IOException {
        TimerContext context = new TimerContext(60, 1);
        TimerScheduler sheduler = new TimerScheduler(context);
        sheduler.addTask(new Runnable() {
            @Override
            public void run() {
                System.out.println(DateUtils.now());
            }
        }, 60);
        System.out.println(DateUtils.now());

        /*Timer timer = new Timer();
        timer.scheduleAtFixedRate(sheduler, 0, context.getTickDuration() * 1000L);
*/
        System.in.read();
    }

}
