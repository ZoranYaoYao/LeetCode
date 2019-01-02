package com.zoran.data.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList 源码分析
 */
public class LinkedListTest {

    public static void main(String[] args) {
        staticMethodTest();
        methodTest();
    }

    private static void methodTest() {
        LinkedList<String> linkedList = new LinkedList<>();

        /** 增*/
        linkedList.add("1"); //末尾添加
        linkedList.add(1,"2"); //指定索引值添加
        linkedList.addFirst("0"); //头添加
        linkedList.addLast("3"); //末尾添加

        linkedList.offer("4"); //作为双向链表-末尾添加
        linkedList.offerFirst("-1"); //作为双向链表-队首添加
        linkedList.offerLast("5"); //作为双向链表-末尾添加

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        linkedList.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
        linkedList.addAll(0, list2);
        System.out.println(linkedList);

        /** 删除*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.remove();
        linkedList.remove(0);
        linkedList.remove("3");

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

        linkedList.poll();
        linkedList.pollFirst();
        linkedList.pollLast();

        list = new ArrayList<>();list.add("4");list.add("5");
        linkedList.removeAll(list);
        linkedList.retainAll(list); //取2个集合的交集

        /** 修改*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.set(0, "-1");

        /** 查*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.get(2);
        linkedList.getFirst();
        linkedList.getLast();

        /** 遍历*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        for (String item : linkedList) {
            System.out.println(item);
        }

        /** 其他常用API*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.clear();
        linkedList.clone(); //浅拷贝
        linkedList.size();
        linkedList.isEmpty();
        linkedList.contains("3");
        linkedList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); //字符升序
            }
        });
        String[] a = new String[linkedList.size()];
        linkedList.toArray(a);


        /** 作为栈式结构*/
        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.push("1"); //入栈

        linkedList2.pop(); //出栈

        linkedList.peek(); //查看
        linkedList2.peekFirst();
        linkedList.peekLast();

    }

    private static void staticMethodTest() {

    }
}
