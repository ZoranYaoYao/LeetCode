package com.zoran.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors
 *
 * refer:
 * https://blog.csdn.net/denghonghao/article/details/82428531
 * https://www.cnblogs.com/baizhanshi/p/5469948.html rebase!
 * https://www.cnblogs.com/dolphin0520/p/3932921.html rebase!!
 *
 * �̳߳ص������ܽᶼ��ͨ���ײ�ԭ���ʵ��������ģ���
 *
 * �ײ�ԭ��:
 * ReentrantLock ʵ���߳�֮��Ļ������
 *
 * Դ��:
 * private final ReentrantLock mainLock = new ReentrantLock();   //�̳߳ص���Ҫ״̬�������̳߳�״̬�������̳߳ش�С
 *                                                               //��runState�ȣ��ĸı䶼Ҫʹ�������
 * private final HashSet<Worker> workers = new HashSet<Worker>();  //������Ź�����
 */
public class ExecutorsTest {

    public static void main(String[] args) {

        /**
         * ��ȡ�̶��̸߳���ͬʱ�������̳߳�, �����������ֵ��������ȴ�
         *
         * �̶������̲߳������
         *
         * ���ó�����
         * �̶�ִ��ĳһ������ʱ
         */
        ExecutorService moreExecutors = Executors.newFixedThreadPool(16);

        /**
         * ��ȡ�����̵߳��̳߳أ���ѭFIFO��ԭ�򣬽���������
         */
        ExecutorService singleExecutors = Executors.newSingleThreadExecutor();

        /**
         * newCachedThreadPool()
         * ����أ�ÿ���߳�ʹ�����֮��
         * ����60��֮�ڣ�������������������ÿ����߳�
         * ����60��֮�⣬���ջظ��̣߳�����������ʱ���򴴽��µ��߳�ִ��
         *
         * ���ó�����
         * �߲�������ʱ�����Ļ���
         */
        ExecutorService cacheExecutorService = Executors.newCachedThreadPool();

        /**
         * ִ�����ӳٵĹ���
         */
        ExecutorService executorService = Executors.newScheduledThreadPool(4);


    }

}
