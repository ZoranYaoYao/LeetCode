package com.zoran.data.array.concurrent;

public class Thread {

    /**
     * �߳�״̬
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
     * ��ʼִ���̣߳�����RUNNABLE״̬
     */
    public synchronized void start() {

    }

    /**
     * �ϲ�һ���߳�
     * ���߳�ִ�����֮��Ż����ִ��
     */
    public final void join() throws InterruptedException {
    }
}
