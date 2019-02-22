package com.zoran.data.array.concurrent;

/**
 * refer: http://www.cnblogs.com/waterystone/p/4920007.html
 */
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
     * 获取线程状态
     * @return
     */
    public State getState() {
        return null;
    }

    /**
     * 开始执行线程，进入RUNNABLE状态
     */
    public synchronized void start() {

    }

    /**
     * refer: https://blog.csdn.net/u010983881/article/details/80257703
     *
     * 合并一个线程
     * 当线程执行完成之后才会继续执行
     */
    public final void join() throws InterruptedException {
        //内部由 Object wait() 方法实现
        //???Thread(线程)对象执行完之后，会自动释放自己这个锁！！
    }

    /**
     * 判断当前线程是否存活！
     */
    public final native boolean isAlive();

    /**
     * https://www.cnblogs.com/java-spring/p/8309931.html
     * 让出CPU时间片，再一次进行争抢
     * Note: yield() 是运行状态 转化到 就绪状态，所以还是有锁对象的
     */
    public static native void yield();
}
