package com.zoran.dp.������������ģʽ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OneByOne {


    //��������
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

            //������100ms,����һ��
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            queue.add(id++);
            synchronized (empty) {
                empty.notifyAll();
            }
            System.out.println("����� id = " + id);
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

            //������100ms,����һ��
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int id = queue.remove(0);
            synchronized (full) {
                full.notifyAll();
            }
            System.out.println("������ id = " + id);
        }


    }
}