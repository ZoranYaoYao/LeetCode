package com.zoran.dp.生成者消费者模式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OneByOne {


    //阻塞队列
    static List<Integer> queue = new ArrayList<>(10);
    static Object full = new Object();
    static Object empty = new Object();

    public static void main(String[] args) {

        Productor productor = new Productor(empty, full, queue);
        productor.start();

        Consumer consumer = new Consumer(empty, full, queue);
        consumer.start();
    }
}

class Productor extends Thread {
    List<Integer> queue;
    Object empty;
    Object full;
    int id;

    public Productor(Object empty, Object full, List<Integer> queue) {
        this.empty = empty;
        this.full = full;
        this.queue = queue;
    }


    @Override
    public void run() {

        while (true) {
            while (queue.size() >= 10) {
                synchronized (full) {
                    try {
                        full.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

            //生产者100ms,生产一次
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queue.add(id++);
            synchronized (empty) {
                empty.notifyAll();
            }
            System.out.println("添加了 id = " + id);
        }

    }
}

class Consumer extends Thread {

    List<Integer> queue;
    Object empty;
    Object full;

    public Consumer(Object empty, Object full, List<Integer> queue) {
        this.empty = empty;
        this.full = full;
        this.queue = queue;
    }

    @Override
    public void run() {

        while (true) {
            while (queue.size() == 0) {
                synchronized (empty) {
                    try {
                        empty.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            //消费者100ms,消费一次
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int id = queue.remove(0);
            synchronized (full) {
                full.notifyAll();
            }
            System.out.println("消费了 id = " + id);
        }


    }
}