package com.zoran.data.array.juc;

/**
 * DelayWorkQueue
 *
 * refer：
 * https://www.cnblogs.com/java-chen-hao/archive/2019/01/16/10275910.html#_labelTop
 *
 * 数据结构：
 * 数组 + ReentrantLock
 *         private RunnableScheduledFuture<?>[] queue =
 *             new RunnableScheduledFuture<?>[INITIAL_CAPACITY];
 * 小顶堆， 每次都是获取等待时间最少的工作给线程池！！
 *
 * 核心排序对比点：
 * 实现了 Delayed接口，对等待时间进行排序
 *
 * 使用场景：
 * ExecutorService executorService = Executors.newScheduledThreadPool(4); 执行有延迟的工作
 */
public class DelayedWorkQueueTest {

    public static void main(String[] args) throws InterruptedException {
        methodTest();
    }

    private static void methodTest() {
    }
}
