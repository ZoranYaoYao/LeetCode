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
 * ReentrantLockTest ��ƽ����ǹ�ƽ������
 * ��ƽ��������֤��ȡ���Ĺ�ƽ�ԣ����������ȵõ�ԭ��
 * �ǹ�ƽ������֤���Ļ�ȡ�Ĺ�ƽ�ԣ��µ����߳̽��͵ȴ������е��߳̾�������
 * ��ƽ���߱���ƽ�Ե����ܲ���ǹ�ƽ������֤��ƽ�Ե����и��õ����ܡ�
 */
public class ReentrantLockTest {

    private final Sync sync;

    //Ĭ�Ϸǹ�ƽ����׷������
    public ReentrantLockTest() {
        sync = new NonfairSync();
    }

    /**��ƽ��*/
    static final class FairSync extends Sync {

    }

    /*** �ǹ�ƽ��*/
    static final class NonfairSync extends Sync {

    }


    abstract static class Sync extends AbstractQueuedSynchronizer {}


}
