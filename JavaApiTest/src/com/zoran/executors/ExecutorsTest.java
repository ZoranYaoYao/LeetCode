package com.zoran.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors
 *
 * refer:
 * https://blog.csdn.net/denghonghao/article/details/82428531
 * https://www.cnblogs.com/baizhanshi/p/5469948.html rebase!
 */
public class ExecutorsTest {

    public static void main(String[] args) {

        /**
         * 获取固定线程个数同时工作的线程池, 如果超过该阈值，则任务等待
         *
         * 固定几个线程不会回收
         *
         * 运用场景：
         * 固定执行某一个任务时
         */
        ExecutorService moreExecutors = Executors.newFixedThreadPool(16);

        /**
         * 获取单个线程的线程池，遵循FIFO的原则，进行任务处理
         */
        ExecutorService singleExecutors = Executors.newSingleThreadExecutor();

        /**
         * newCachedThreadPool()
         * 缓存池，每个线程使用完成之后，
         * 保活60秒之内，如果有新任务来，则复用空闲线程
         * 保活60秒之外，则收回该线程，有新任务来时，则创建新的线程执行
         *
         * 运用场景：
         * 高并发的临时任务多的环境
         */
        ExecutorService cacheExecutorService = Executors.newCachedThreadPool();

        /**
         * 执行有延迟的工作
         */
        ExecutorService executorService = Executors.newScheduledThreadPool(4);


    }

}
