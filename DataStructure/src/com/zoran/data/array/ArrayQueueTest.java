package com.zoran.data.array;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayQueue 数组队列
 *
 * 包：com.sun.jmx.remote.internal
 *
 * 底层实现：循环数组
 * tail指针 指向下一次添加的位置！！
 *
 * 1. 只能手动扩容
 * 2. 不支持添加特定索引元素，只支持从队尾插入
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        methodTest();
    }


    private static void methodTest() {
        /** 增*/
        ArrayQueue<Integer> queue = new ArrayQueue<>(16); //Core. 初始化必须定义好容量
        queue.add(0);
//        queue.add(1,1); // 不支持该操作
        List<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        queue.addAll(list);
        System.out.println(queue);
//        queue.addAll(3, list); // 不支持该操作

        queue.resize(32); //Core. 只能手动扩容

        /** 删*/
        ArrayQueue<Integer> queue2 = new ArrayQueue<>(16); //Core. 初始化必须定义好容量
        queue2.add(0);queue2.add(1);queue2.add(2);
        queue2.remove(0); //Core. 只支持删除队列的头端

        /** 改*/
        //无此功能

        /** 查*/
        ArrayQueue<Integer> queue3 = new ArrayQueue<>(16); //Core. 初始化必须定义好容量
        queue3.add(0);queue3.add(1);queue3.add(2);
        queue3.get(0);queue3.get(1);queue3.get(2);

        /** 遍历*/
        ArrayQueue<Integer> queue4 = new ArrayQueue<>(16); //Core. 初始化必须定义好容量
        queue4.add(0);queue4.add(1);queue4.add(2);
        for(int i=0; i<queue4.size(); i++) {
            System.out.println(queue.get(i));
        }

        /** 其他常用API*/
        ArrayQueue<Integer> queue5 = new ArrayQueue<>(16); //Core. 初始化必须定义好容量
        queue5.add(0);queue5.add(1);queue5.add(2);
        queue5.clear();
        queue5.size();
        queue5.isEmpty();
        queue5.contains(2);

    }
}
