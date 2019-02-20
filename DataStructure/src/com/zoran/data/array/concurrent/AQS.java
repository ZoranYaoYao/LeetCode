package com.zoran.data.array.concurrent;

/**
 * AbstractQueueSynchronizer 抽象队列同步器
 *
 * refer:
 * https://www.cnblogs.com/waterystone/p/4920797.html
 *
 */
public class AQS {
    /**
     * The synchronization state.
     * 共享资源标量
     */
    private volatile int state;
}
