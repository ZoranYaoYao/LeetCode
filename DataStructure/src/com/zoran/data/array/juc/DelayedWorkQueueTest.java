package com.zoran.data.array.juc;

/**
 * DelayWorkQueue
 *
 * refer��
 * https://www.cnblogs.com/java-chen-hao/archive/2019/01/16/10275910.html#_labelTop
 *
 * ���ݽṹ��
 * ���� + ReentrantLock
 *         private RunnableScheduledFuture<?>[] queue =
 *             new RunnableScheduledFuture<?>[INITIAL_CAPACITY];
 * С���ѣ� ÿ�ζ��ǻ�ȡ�ȴ�ʱ�����ٵĹ������̳߳أ���
 *
 * ��������Աȵ㣺
 * ʵ���� Delayed�ӿڣ��Եȴ�ʱ���������
 *
 * ʹ�ó�����
 * ExecutorService executorService = Executors.newScheduledThreadPool(4); ִ�����ӳٵĹ���
 */
public class DelayedWorkQueueTest {

    public static void main(String[] args) throws InterruptedException {
        methodTest();
    }

    private static void methodTest() {
    }
}
