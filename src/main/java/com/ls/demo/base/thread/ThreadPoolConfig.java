package com.ls.demo.base.thread;

/**
 * @Description
 * @Author Create by junwei.liang on 2018/8/21
 */
public class ThreadPoolConfig {
    @Verify(ge = "1")
    private int corePoolSize;
    @Verify(ge = "1")
    private int maximumPoolSize;
    private int keepAliveTime;
    @Verify(notEmpty = true)
    private String threadName;
    @Verify(ge = "1")
    private int initialCapacity;

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public int getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public int getInitialCapacity() {
        return initialCapacity;
    }

    public void setInitialCapacity(int initialCapacity) {
        this.initialCapacity = initialCapacity;
    }
}