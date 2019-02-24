package com.zoran.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolCase {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            System.out.println("开心新的任务 + i=" + i);
            exec.execute(new LiftOff());
            //不睡眠的画，会创建5个线程进行执行
            //睡眠1000ms, 会创建1个线程执行
            Thread.sleep(5);
        }
        exec.shutdown();
    }
}
