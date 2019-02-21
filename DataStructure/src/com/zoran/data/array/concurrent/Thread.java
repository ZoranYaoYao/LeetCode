package com.zoran.data.array.concurrent;

public class Thread {

    /**
     * 线程状态
     */
    public enum State {
        NEW,

        RUNNABLE,

        BLOCKED,

        WAITING,

        TIMED_WAITING,

        TERMINATED;
    }

    /**
     * 开始执行线程，进入RUNNABLE状态
     */
    public synchronized void start() {

    }

    /**
     * 合并一个线程
     * 当线程执行完成之后才会继续执行
     */
    public final void join() throws InterruptedException {
    }
}
