package com.rabbitmqc.rabbitmqc.utils;

import java.util.concurrent.*;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
public class ThreadPoolUtil {
    /**
     * 线程池
     */
//    public static ExecutorService esc= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);

    public static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
    public static ExecutorService esc = new ThreadPoolExecutor(10, 20,200L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
    /**
     * 调度线程池
     */
//    public static ScheduledExecutorService schexc=Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
    public static ThreadFactory namedThreadFactory_schexc = new ThreadFactoryBuilder().setNameFormat("schedule-thread-call-runner-%d").build();
    public static ScheduledExecutorService schexc = new ScheduledThreadPoolExecutor(10,namedThreadFactory_schexc);

    public static void main(String[] args) {
        schexc.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },1000, TimeUnit.MILLISECONDS);
    }
}
