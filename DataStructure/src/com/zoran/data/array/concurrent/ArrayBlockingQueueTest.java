package com.zoran.data.array.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue 阻塞队列
 *
 * 底层数据结构
 * 循环数组（没后扩容机制）
 *
 * 包：
 * java.util.concurrent.ArrayBlockingQueue;
 *
 * 功能：
 * 1. 对数据的添加，删除，都加入了重入锁，保证线性安全
 * 2. 提供阻塞式插入，获取
 *
 * 使用环境：
 * 并发环境下的，列队的入队列，出队列
 * eg: Executors线程池中的队列
 *
 * API使用：
 * ArrayDeque的并发对象，去除Deque接口的方法！
 */
public class ArrayBlockingQueueTest extends ArrayBlockingQueue {

    public ArrayBlockingQueueTest(int capacity) {
        super(capacity);
    }

    public ArrayBlockingQueueTest(int capacity, boolean fair) {
        super(capacity, fair);
    }

    public static void main(String[] args) throws InterruptedException {
        methodTest();
    }

    private static void methodTest() throws InterruptedException {
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(16);

        /**
         * 阻塞式方法
         */
        //?Core. 通过Condition条件类就你行阻塞方法！！
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        abq.take();
        abq.poll(2000, TimeUnit.MILLISECONDS);
        abq.put("123");
        abq.offer("123",2000, TimeUnit.MILLISECONDS);

        /** 增*/
        abq.add("1"); //末尾添加
//        abq.add(1,"2"); //不支持，指定索引值添加

        abq.offer("4"); //末尾添加
        //Core. 如果满了，等待2000毫秒之类进行插入，等待过来，还没添加就抛异常
        abq.offer("6", 2000, TimeUnit.MILLISECONDS);

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        abq.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        abq.addAll(0, list2); //不支持，指定索引值添加集合
        System.out.println(abq);

        /** 删除*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        abq.remove();
//        abq.remove(2); //不支持，指定位置删除元素
        abq.remove("3");

        System.out.println(abq);

        //Core. 从队首取一个对象
        abq.poll();
        abq.poll(2000, TimeUnit.MILLISECONDS);

        list = new ArrayList<>();list.add("4");list.add("5");
        abq.removeAll(list);
        abq.retainAll(list); //取2个集合的交集

        /** 修改*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
//        abq.set(0, "-1"); //不支持，指定位置修改操作


        /** 查*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
//        abq.get(2);
        System.out.println("abq.peek() = " + abq.peek());


        /** 遍历*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        for (String item : abq) {
            System.out.println(item);
        }

        /** 其他常用API*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        abq.clear();
//        abq.clone(); //浅拷贝
        abq.size();
        abq.isEmpty();
        abq.contains("3");
//        abq.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); //字符升序
//            }
//        });
//        String[] a = new String[abq.size()];
//        abq.toArray(a);

    }
}
