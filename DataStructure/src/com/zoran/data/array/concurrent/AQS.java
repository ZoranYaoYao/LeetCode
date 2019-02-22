package com.zoran.data.array.concurrent;

/**
 * AbstractQueuedSynchronizer 抽象队列同步器
 *
 * refer:
 * https://www.cnblogs.com/waterystone/p/4920797.html
 *
 * 底层原理实现：
 * sun.misc.Unsafe UNSAFE; park(Object object) unpark(Object object) 进行等待状态，唤醒状态切换
 * CAS
 *
 * 1. 维护一个数据结构为Node链表，将线程对象和等待状态封装成一个Node。
 * 2. 通过队列来查找下一个获取对象锁的线程结点进行唤醒
 *
 */
public class AQS {
    /**
     * The synchronization state.
     * 共享资源标量
     */
    private volatile int state;

    /**
     * 独占模式获取共享资源
     * 函数流程如下：
     *
     * 1.tryAcquire()尝试直接去获取资源，如果成功则直接返回；
     * 2.addWaiter()将该线程加入等待队列的尾部，并标记为独占模式；
     * 3.acquireQueued()使线程在等待队列中获取资源，一直获取到资源后才返回。如果在整个等待过程中被中断过，则返回true，否则返回false。
     * 4. 如果线程在等待过程中被中断过，它是不响应的。只是获取资源后才再进行自我中断selfInterrupt()，将中断补上。
     */
    public final void acquire(int arg) {

    }

    /**
     * release()是独占模式下线程释放共享资源的顶层入口
     */
    public final boolean release(int arg) {
        return true;
    }

    /**
     * 同步队列里面的结点结构！
     */
    static final class Node {
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;

        static final int CANCELLED =  1;
        static final int SIGNAL    = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;

        /**
         * 在同步容器队列中的等待状态！
         */
        volatile int waitStatus;
    }
}
