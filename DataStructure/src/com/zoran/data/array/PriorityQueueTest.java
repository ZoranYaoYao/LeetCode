package com.zoran.data.array;

import java.util.*;

/**
 * refer：
 * https://github.com/CarpenterLee/JCFInternals/blob/master/markdown/8-PriorityQueue.md
 *
 * PriorityQueue
 *
 * 底层数据结构：
 * 数组
 *
 * 实现原理:
 * 通过完全二叉树（complete binary tree）实现的小顶堆
 * 数组构成的极小堆
 *
 * API操作：
 * 跟ArrayQueue循环队列类似
 *
 * 特殊点：
 * 1. 遍历器Iterator在remove()操作时，可能会出现上移操作，导致遍历不全，所以会有一个记录的过程
 * https://blog.csdn.net/u011518120/article/details/53022406
 */
public class PriorityQueueTest extends PriorityQueue<Integer> {

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        /** 增*/
        priorityQueue.add("1"); //末尾添加
//        dequeue.add(1,"2"); //不支持，指定索引值添加

        priorityQueue.offer("4"); //末尾添加
//
        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        priorityQueue.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        dequeue.addAll(0, list2); //不支持，指定索引值添加集合
        System.out.println(priorityQueue);

        /** 删除*/
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add("1");priorityQueue.add("2");priorityQueue.add("3");priorityQueue.add("4");priorityQueue.add("5");
        priorityQueue.remove();
        priorityQueue.remove("5");

        System.out.println(priorityQueue);

        priorityQueue.poll();

        list = new ArrayList<>();list.add("4");list.add("5");
        priorityQueue.removeAll(list);
        priorityQueue.retainAll(list); //取2个集合的交集

        /** 修改*/
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add("1");priorityQueue.add("2");priorityQueue.add("3");priorityQueue.add("4");priorityQueue.add("5");
//        priorityQueue.set(0, "-1"); //不支持，指定位置修改操作

        /** 查*/
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add("1");priorityQueue.add("2");priorityQueue.add("3");priorityQueue.add("4");priorityQueue.add("5");
//        dequeue.get(2);
        priorityQueue.peek();

        /** 遍历*/
        PriorityQueue<Integer> pri = new PriorityQueue<>();
        pri.add(5);pri.add(4);pri.add(3);pri.add(2);pri.add(1);
        Iterator iterator = pri.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Integer item : pri) {
            System.out.println(item);
        }

        /** 其他常用API*/
        pri = new PriorityQueue<>();
        pri.add(5);pri.add(4);pri.add(3);pri.add(2);pri.add(1);
        pri.clear();
//        dequeue.clone(); //浅拷贝
        pri.size();
        pri.isEmpty();
        pri.contains("3");
        String[] a = new String[pri.size()];
        pri.toArray(a);

    }
}
