package com.zoran.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolCase {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            System.out.println("�����µ����� + i=" + i);
            exec.execute(new LiftOff());
            //��˯�ߵĻ����ᴴ��5���߳̽���ִ��
            //˯��1000ms, �ᴴ��1���߳�ִ��
            Thread.sleep(5);
        }
        exec.shutdown();
    }
}
