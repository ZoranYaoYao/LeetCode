package com.zoran.data.array.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * LinkedBlockingQueue
 *
 * refer :
 * https://www.cnblogs.com/java-zhao/p/5135958.html
 *
 * 底层数据结构：
 * 一个单向链表 + 2把锁 + 2个条件
 *
 * 运用：
 * ExecutorService executors = Executors.newFixedThreadPool(16);  * 获取固定线程个数的线程池
 *
 * API用法：
 * 与ArrayBlockingQueue类似
 *
 * 区别：
 * ArrayBlockingQueue与LinkedBlockingQueue对比
 *
 * ArrayBlockingQueue：
     * 一个对象数组+一把锁+两个条件
     * 入队与出队都用同一把锁
     * 在只有入队高并发或出队高并发的情况下，因为操作数组，且不需要扩容，性能很高
     * 采用了数组，必须指定大小，即容量有限
 * LinkedBlockingQueue：
     * 一个单向链表+两把锁+两个条件
     * 两把锁，一把用于入队，一把用于出队，有效的避免了入队与出队时使用一把锁带来的竞争。
     * 在入队与出队都高并发的情况下，性能比ArrayBlockingQueue高很多
     * 采用了链表，最大容量为整数最大值，可看做容量无限
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        methodTest();
    }

    private static void methodTest() throws InterruptedException {
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");

        /**
         * 阻塞式方法
         */
        //?Core. 通过Condition条件类就你行阻塞方法！！
        lbq.put("123");
        lbq.offer("123",2000, TimeUnit.MILLISECONDS);

        lbq.take();
        lbq.poll(2000, TimeUnit.MILLISECONDS);

        /** 增*/
        lbq.add("1"); //末尾添加
//        abq.add(1,"2"); //不支持，指定索引值添加

        lbq.offer("4"); //末尾添加
        //Core. 如果满了，等待2000毫秒之类进行插入，等待过来，还没添加就抛异常
        lbq.offer("6", 2000, TimeUnit.MILLISECONDS);

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        lbq.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        abq.addAll(0, list2); //不支持，指定索引值添加集合
        System.out.println(lbq);

        /** 删除*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
        lbq.remove();
//        abq.remove(2); //不支持，指定位置删除元素
        lbq.remove("3");

        System.out.println(lbq);

        //Core. 从队首取一个对象
        lbq.poll();
        lbq.poll(2000, TimeUnit.MILLISECONDS);

        list = new ArrayList<>();list.add("4");list.add("5");
        lbq.removeAll(list);
        lbq.retainAll(list); //取2个集合的交集

        /** 修改*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
//        abq.set(0, "-1"); //不支持，指定位置修改操作


        /** 查*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
//        abq.get(2);
        System.out.println("abq.peek() = " + lbq.peek());


        /** 遍历*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
        for (String item : lbq) {
            System.out.println(item);
        }

        /** 其他常用API*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
        lbq.clear();
//        abq.clone(); //浅拷贝
        lbq.size();
        lbq.isEmpty();
        lbq.contains("3");
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
