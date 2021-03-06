package com.ls.demo.base.thread;

import com.ls.demo.base.util.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/21
 */
public final class ThreadUtil {

    public static final int THREAD_POOL_COUNT = 5;

    public static void shutdownAndWaitRunOver(ExecutorService executor) {
        shutdownAndWaitRunOver(executor, 10);
    }

    public static ThreadPoolExecutor create(ThreadPoolConfig config) {
        return new ThreadPoolExecutor(
                config.getCorePoolSize(),
                config.getMaximumPoolSize(),
                config.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(config.getInitialCapacity()),
                new NamedThreadFactory(config.getThreadName()));
    }

    public static ThreadPoolExecutor create(int size) {
        return new ThreadPoolExecutor(
                size,
                size,
                10,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(Integer.MAX_VALUE),
                new NamedThreadFactory("default"));
    }

    public static ScheduledThreadPoolExecutor createScheduled(ThreadPoolConfig config) {
        return new ScheduledThreadPoolExecutor(config.getCorePoolSize(),
                new NamedThreadFactory(config.getThreadName()));
    }

    /**
     * 停止线程池,并等待线程池中的任务跑完
     *
     * @param executor
     * @param time
     */
    public static void shutdownAndWaitRunOver(ExecutorService executor, long time) {
        executor.shutdown();
        while (!executor.isTerminated()) {
            sleep(time);
        }
    }

    /**
     * 停止线程池,并等待线程池中的任务跑完
     *
     * @param executor
     * @param time
     */
    public static boolean shutdownAndWaitRunOver(ExecutorService executor, long time, long timeout) {
        long startTime = System.currentTimeMillis();
        executor.shutdown();
        while (!executor.isTerminated() && startTime > System.currentTimeMillis() - timeout) {
            sleep(time);
        }
        return executor.isTerminated();
    }

    public static InterruptedException sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            return e;
        }
        return null;
    }

    public static String getTraceInfo() {
        StringBuilder builder = new StringBuilder(2048);
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            builder.append(stackTrace[i].toString()).append("\n");
        }
        return builder.toString();
    }

    public static StackTraceElement currentTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i;
        for (i = 2; i > -1 && i < stackTrace.length; i--) {
            return stackTrace[i];
        }
        return null;
    }

    public static StackTraceElement lastTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i;
        for (i = 3; i > -1 && i < stackTrace.length; i--) {
            return stackTrace[i];
        }
        return null;
    }

    public static StackTraceElement lastClassTrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 3) {
            return stackTrace[stackTrace.length - 1];
        }
        StackTraceElement lastClass = stackTrace[2];
        for (int i = 3; i < stackTrace.length; i++) {
            if (!lastClass.getClassName().equals(stackTrace[i].getClassName())) {
                return stackTrace[i];
            }
        }
        return stackTrace[0];
    }

    /**
     * 获取堆栈中clazz以上的一个
     *
     * @param stackTrace
     * @param clazz
     * @return
     */
    public static StackTraceElement getLastStackTraceElement(StackTraceElement[] stackTrace, Class clazz) {
        for (StackTraceElement element : stackTrace) {
            if (!element.getClassName().equals(clazz.getName())) {
                return element;
            }
        }
        if (stackTrace.length > 0) {
            return stackTrace[0];
        }
        return null;
    }

}
