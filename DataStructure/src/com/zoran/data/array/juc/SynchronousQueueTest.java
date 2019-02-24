package com.zoran.data.array.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue
 *
 * refer:
 * https://blog.csdn.net/qq_38293564/article/details/80604194
 * https://blog.csdn.net/zmx729618/article/details/52980158
 *
 * 底层原理
 * 无集合存储结构！！
 *
 * 运用：
 * 线程池(Executors) 中的Executors.newCachedThreadPool()
 *
 * 公平机制：
 * 没有搞懂？
 *
 * API:
 * 生产
 * 阻塞方法：
 * put(E e)
 * offer(E e, long timeout, TimeUnit unit)
 * 非阻塞方法：
 * offer(E e) 一直跟新头结点
 * add(E e) 添加失败，则抛异常
 *
 * 消费
 * 阻塞方法：
 * take()
 * poll(long timeout, TimeUnit unit)
 * 非阻塞方法：
 * poll()
 * 总结： 多用阻塞式的生产获取， 这样不会错过任何一个产品！
 *
 */
public class SynchronousQueueTest {

    public static void main(String[] args) throws InterruptedException {
//        methodTest();
        SynchronousQueue<Integer> sq = new SynchronousQueue<>(true);


        Productor productor = new Productor(sq);
        productor.start();

        Consumer consumer = new Consumer(sq);
        consumer.start();



    }

    static class Consumer extends Thread {
        SynchronousQueue<Integer> sq;

        public Consumer (SynchronousQueue<Integer> sq) {
            this.sq = sq;
        }

        @Override
        public void run() {
            try {
                for (;;) {
//                    int goodsId =  sq.take();  //阻塞方法
                     //2.
//                    Integer goodsId = sq.poll(1, TimeUnit.MILLISECONDS); //超时阻塞方法
//                    if (goodsId == null) continue;

                      Integer goodsId = sq.poll(); //非阻塞方法！！

                    System.out.println("获取产品ID : " + goodsId);
                    Thread.sleep(900);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Productor extends Thread {
        SynchronousQueue<Integer> sq;

        int goodsId = 0;

        public Productor (SynchronousQueue<Integer> sq) {
            this.sq = sq;
        }

        @Override
        public void run() {
            try {
                for (;;) {
                    System.out.println("生成产品ID : " + goodsId);
                    /**阻塞方法*/
//                    sq.put(goodsId++); // 插入队列是一个阻塞方法，只有消费了该Node，才能唤起下一次生产
//                    sq.offer(goodsId++, 1000, TimeUnit.MILLISECONDS); //阻塞插入，如果超时，则跳出阻塞

                    /**非阻塞方法*/
                    sq.offer(goodsId++);
//                    sq.add(goodsId++); //添加元素失败时，抛异常
                    Thread.sleep(1000);

//                    System.out.println(sq.size()); // 源码永远返回0
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private static void methodTest() throws InterruptedException {
        SynchronousQueue<String> sq = new SynchronousQueue<>();
        sq.put("-1");
        System.out.println(sq.take());
        sq.put("1");

        sq.add("2");
//        sq.add("3");
//        sq.add("4");
//        sq.add("5");

        /**
         * 阻塞式方法
         */
        //?Core. 通过Condition条件类就你行阻塞方法！！
        sq.put("123");
        sq.offer("123",2000, TimeUnit.MILLISECONDS);

        sq.take();
        sq.poll(2000, TimeUnit.MILLISECONDS);

        /** 增*/
        sq.add("1"); //末尾添加
//        abq.add(1,"2"); //不支持，指定索引值添加

        sq.offer("4"); //末尾添加
        //Core. 如果满了，等待2000毫秒之类进行插入，等待过来，还没添加就抛异常
        sq.offer("6", 2000, TimeUnit.MILLISECONDS);

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        sq.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        abq.addAll(0, list2); //不支持，指定索引值添加集合
        System.out.println(sq);

        /** 删除*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
        sq.remove();
//        abq.remove(2); //不支持，指定位置删除元素
        sq.remove("3");

        System.out.println(sq);

        //Core. 从队首取一个对象
        sq.poll();
        sq.poll(2000, TimeUnit.MILLISECONDS);

        list = new ArrayList<>();list.add("4");list.add("5");
        sq.removeAll(list);
        sq.retainAll(list); //取2个集合的交集

        /** 修改*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
//        abq.set(0, "-1"); //不支持，指定位置修改操作


        /** 查*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
//        abq.get(2);
        System.out.println("abq.peek() = " + sq.peek());


        /** 遍历*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
        for (String item : sq) {
            System.out.println(item);
        }

        /** 其他常用API*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
        sq.clear();
//        abq.clone(); //浅拷贝
        sq.size();
        sq.isEmpty();
        sq.contains("3");
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
