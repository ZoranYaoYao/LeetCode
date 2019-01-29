package com.zoran.data.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList
 *
 * refer:
 * https://www.cnblogs.com/chengxiao/p/6881974.html （rebase）
 * https://www.cnblogs.com/dolphin0520/p/3938914.html
 * https://www.cnblogs.com/leesf456/p/5547853.html
 *
 * 原理：
 * 1.添加时，通过加重入锁，复制原来的数组而成的
 * 2.CopyOnWriteArrayList的源码很简单，其主要用到的快照的思路，使得在迭代的过程中，
 * 只是Object数组之前的某个快照，而不是最新的Object，这样可以保证在迭代的过程中不会抛出ConcurrentModificationException异常。
 *
 * 优点：
 * 1.CopyOnWriteArrayList是一个线程安全，读操作时无锁的ArrayList
 *
 * 缺点：
 * 1.内存占用问题
 * 2.数据一致性问题
 *
 * 结论：
 * 1.如果想线性安全的话，读写都要进行加锁，才能保证实时环境也是线性安全的，eg:Vector
 * 2.增删改上锁、读不上锁
 * 3.读多写少且脏数据影响不大的并发情况下，选择CopyOnWriteArrayList
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        methodTest();

    }

    /***
     * 实例方法
     */
    private static void methodTest() {
        /** 增*/
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("0"); //1
        list.add(1, "1"); //2
        list.addIfAbsent("2"); //Core. 没有时，进行添加
        CopyOnWriteArrayList<String> anotherList = new CopyOnWriteArrayList<String>();anotherList.add("2");
        list.addAll(anotherList); //3
        list.addAll(0,anotherList); //4
        System.out.println(list);

        /** 删*/
        list.remove(0); //1
        list.remove("2"); //2

        //求当前元素剔除另一个集合的元素
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new CopyOnWriteArrayList<>();anotherList.add("1");anotherList.add("3");
        list.removeAll(anotherList); //3
        System.out.println(list);

        //求2个集合的交集
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        anotherList = new CopyOnWriteArrayList<>();anotherList.add("1");anotherList.add("3");
        list.retainAll(anotherList);  //4
        System.out.println(list);

        /** 改*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        list.set(0, "LinkedHashMapTest");
        //替换所有元素
//        list.replaceAll(new CopyOnWriteArrayList<String>() {
//            @Override
//            public String apply(String s) {
//                return "B";
//            }
//        });
        System.out.println(list);

        /** 查*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        list.get(0);

        /** 遍历*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("3");
        for (String item: list) {
            System.out.println(item);
        }

        /** 其他常用API*/
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("33");
        int size = list.size();
        list.clear();
        list.isEmpty();
//        list.sort(new CopyOnWriteArrayList<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length(); //长度升序,长度相等时，往后排
//            }
//        });
        System.out.println(list);
        //List的拷贝过程 是属于浅拷贝，所以对数组对象要进行数组拷贝，而size则是直接深拷贝
        CopyOnWriteArrayList<String> another = (CopyOnWriteArrayList<String>) list.clone();
        System.out.println(another.size());

        //subList 获取的是ArrayList中的内部类SubList
        list = new CopyOnWriteArrayList<>();list.add("1");list.add("2");list.add("33");
//        CopyOnWriteArrayList<String> sublist = (CopyOnWriteArrayList<String>) list.subList(0,1);

        //list转数组
        list.toArray(new String[3]);
    }
}
