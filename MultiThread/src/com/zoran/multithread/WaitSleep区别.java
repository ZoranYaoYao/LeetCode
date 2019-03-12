package com.zoran.multithread;

import java.util.concurrent.locks.LockSupport;

/**
 * 通过代码可以看到，
 * 当是synchronized阻塞的话，Thread是阻塞状态，state为BLOCKED
 * 当是wait，join等待状态的话，Thread是等待状态，state为WAITING
 *
 * 源码注释：
 * BLOCKED
 * A thread in the blocked state is waiting for a monitor lock
 * to enter a synchronized block/method
 *
 * WAITING
 * Thread state for a waiting thread.
 * A thread is in the waiting state due to calling one of the
 * following methods:
 * <ul>
 *   <li>{@link Object#wait() Object.wait} with no timeout</li>
 *   <li>{link #join() Thread.join} with no timeout</li>
 *   <li>{@link LockSupport#park() LockSupport.park}</li>
 * </ul>
 */
public class WaitSleep区别 {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                WaitSleep区别.run();

            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    WaitSleep区别.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        thread1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("thread1 state = " + thread1.getState());
            Thread.currentThread().sleep(1000);
        }

    }

    public static void waitAndSleep() throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a) {
                    try {
                        System.out.println("aaa");
//                    Thread.currentThread().sleep(5000);
                        a.wait();
                        System.out.println("bbbb");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();


        for (int i = 0; i < 10; i++) {
            System.out.println("thread state = " + thread.getState());
            Thread.currentThread().sleep(1000);
        }
    }

    public static synchronized void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
