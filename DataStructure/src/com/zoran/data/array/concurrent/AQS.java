package com.zoran.data.array.concurrent;

/**
 * AbstractQueuedSynchronizer �������ͬ����
 *
 * refer:
 * https://www.cnblogs.com/waterystone/p/4920797.html
 *
 * �ײ�ԭ��ʵ�֣�
 * sun.misc.Unsafe UNSAFE; park(Object object) unpark(Object object) ���еȴ�״̬������״̬�л�
 * CAS
 *
 * 1. ά��һ�����ݽṹΪNode�������̶߳���͵ȴ�״̬��װ��һ��Node��
 * 2. ͨ��������������һ����ȡ���������߳̽����л���
 *
 */
public class AQS {
    /**
     * The synchronization state.
     * ������Դ����
     */
    private volatile int state;

    /**
     * ��ռģʽ��ȡ������Դ
     * �����������£�
     *
     * 1.tryAcquire()����ֱ��ȥ��ȡ��Դ������ɹ���ֱ�ӷ��أ�
     * 2.addWaiter()�����̼߳���ȴ����е�β���������Ϊ��ռģʽ��
     * 3.acquireQueued()ʹ�߳��ڵȴ������л�ȡ��Դ��һֱ��ȡ����Դ��ŷ��ء�����������ȴ������б��жϹ����򷵻�true�����򷵻�false��
     * 4. ����߳��ڵȴ������б��жϹ������ǲ���Ӧ�ġ�ֻ�ǻ�ȡ��Դ����ٽ��������ж�selfInterrupt()�����жϲ��ϡ�
     */
    public final void acquire(int arg) {

    }

    /**
     * release()�Ƕ�ռģʽ���߳��ͷŹ�����Դ�Ķ������
     */
    public final boolean release(int arg) {
        return true;
    }

    /**
     * ͬ����������Ľ��ṹ��
     */
    static final class Node {
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;

        static final int CANCELLED =  1;
        static final int SIGNAL    = -1;
        static final int CONDITION = -2;
        static final int PROPAGATE = -3;

        /**
         * ��ͬ�����������еĵȴ�״̬��
         */
        volatile int waitStatus;
    }
}
