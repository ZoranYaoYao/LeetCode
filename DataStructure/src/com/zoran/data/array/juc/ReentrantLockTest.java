package com.zoran.data.array.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantLock.*;

/**
 * ReentrantLockTest
 *
 * refer:
 * https://blog.csdn.net/tomato__/article/details/25782747
 *
 * ReentrantLockTest 公平锁与非公平锁区别？
 * 公平锁尽量保证获取锁的公平性，采用先来先得的原则
 * 非公平锁不保证锁的获取的公平性，新到的线程将和等待队列中的线程竞争锁。
 * 公平锁具备公平性但性能差，而非公平锁不保证公平性但具有更好的性能。
 */
public class ReentrantLockTest {

    private final Sync sync;

    //默认非公平锁，追逐性能
    public ReentrantLockTest() {
        sync = new NonfairSync();
    }

    /**公平锁*/
    static final class FairSync extends Sync {

    }

    /*** 非公平锁*/
    static final class NonfairSync extends Sync {

    }


    abstract static class Sync extends AbstractQueuedSynchronizer {}


}
