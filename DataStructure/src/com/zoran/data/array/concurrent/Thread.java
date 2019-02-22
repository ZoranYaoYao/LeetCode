package com.zoran.data.array.concurrent;

/**
 * refer: http://www.cnblogs.com/waterystone/p/4920007.html
 */
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
     * ��ȡ�߳�״̬
     * @return
     */
    public State getState() {
        return null;
    }

    /**
     * ��ʼִ���̣߳�����RUNNABLE״̬
     */
    public synchronized void start() {

    }

    /**
     * refer: https://blog.csdn.net/u010983881/article/details/80257703
     *
     * �ϲ�һ���߳�
     * ���߳�ִ�����֮��Ż����ִ��
     */
    public final void join() throws InterruptedException {
        //�ڲ��� Object wait() ����ʵ��
        //???Thread(�߳�)����ִ����֮�󣬻��Զ��ͷ��Լ����������
    }

    /**
     * �жϵ�ǰ�߳��Ƿ��
     */
    public final native boolean isAlive();

    /**
     * https://www.cnblogs.com/java-spring/p/8309931.html
     * �ó�CPUʱ��Ƭ����һ�ν�������
     * Note: yield() ������״̬ ת���� ����״̬�����Ի������������
     */
    public static native void yield();
}
