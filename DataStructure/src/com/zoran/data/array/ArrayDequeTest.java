package com.zoran.data.array;

import java.util.*;

/**
 * ArrayDequue: Array Double end queue
 *
 * 底层数据结构：
 * 1. 循环数组
 * 2. 双指针， head指向当前队列的头部 tail指向下一个可插入的尾部！！
 * 
 * 作用：JDK 推荐
 * 1. 作为双端队列 （优先级: ArrayDeque > LinkedList）
 * 2. 作为栈结构
 *
 * 经常与LinkedList进行做对比使用
 * 区别：
 * 1. LinkedList能在指定位置进行添加删除修改查询， ArrayDeque不能
 * 2. LinkedList 底层数据结构采用的双向链表结构， ArrayDequeue采用的是循环数组
 *
 * 性能：
 * ArrayDeque 优于 LinkedList
 * 功能上LinkedList能随机索引操作，而ArrayDeque不能
 */
public class ArrayDequeTest {

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        ArrayDeque<String> dequeue = new ArrayDeque<>();

        /** 增*/
        dequeue.add("1"); //末尾添加
//        dequeue.add(1,"2"); //不支持，指定索引值添加
        dequeue.addFirst("0"); //头添加
        dequeue.addLast("3"); //末尾添加

        dequeue.offer("4"); //作为双向链表-末尾添加
        dequeue.offerFirst("-1"); //作为双向链表-队首添加
        dequeue.offerLast("5"); //作为双向链表-末尾添加

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        dequeue.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        dequeue.addAll(0, list2); //不支持，指定索引值添加集合
        System.out.println(dequeue);

        /** 删除*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
        dequeue.remove();
//        dequeue.remove(2); //不支持，指定位置删除元素
        dequeue.remove("3");

        dequeue.removeFirst();
        dequeue.removeLast();
        System.out.println(dequeue);

        dequeue.poll();
        dequeue.pollFirst();
        dequeue.pollLast();

        list = new ArrayList<>();list.add("4");list.add("5");
        dequeue.removeAll(list);
        dequeue.retainAll(list); //取2个集合的交集

        /** 修改*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
//        dequeue.set(0, "-1"); //不支持，指定位置修改操作

        /** 查*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
//        dequeue.get(2);
        dequeue.getFirst();
        dequeue.getLast();

        /** 遍历*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
        for (String item : dequeue) {
            System.out.println(item);
        }

        /** 其他常用API*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
        dequeue.clear();
        dequeue.clone(); //浅拷贝
        dequeue.size();
        dequeue.isEmpty();
        dequeue.contains("3");
//        dequeue.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); //字符升序
//            }
//        });
//        String[] a = new String[dequeue.size()];
//        dequeue.toArray(a);


        /** 作为栈式结构*/
        ArrayDeque<String> dequeue2 = new ArrayDeque<>();
        dequeue2.push("1"); //入栈

        dequeue2.pop(); //出栈

        dequeue.peek(); //查看
        dequeue2.peekFirst();
        dequeue.peekLast();

    }
}
