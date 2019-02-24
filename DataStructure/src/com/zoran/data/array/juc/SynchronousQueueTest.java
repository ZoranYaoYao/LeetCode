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
 * �ײ�ԭ��
 * �޼��ϴ洢�ṹ����
 *
 * ���ã�
 * �̳߳�(Executors) �е�Executors.newCachedThreadPool()
 *
 * ��ƽ���ƣ�
 * û�и㶮��
 *
 * API:
 * ����
 * ����������
 * put(E e)
 * offer(E e, long timeout, TimeUnit unit)
 * ������������
 * offer(E e) һֱ����ͷ���
 * add(E e) ���ʧ�ܣ������쳣
 *
 * ����
 * ����������
 * take()
 * poll(long timeout, TimeUnit unit)
 * ������������
 * poll()
 * �ܽ᣺ ��������ʽ��������ȡ�� �����������κ�һ����Ʒ��
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
//                    int goodsId =  sq.take();  //��������
                     //2.
//                    Integer goodsId = sq.poll(1, TimeUnit.MILLISECONDS); //��ʱ��������
//                    if (goodsId == null) continue;

                      Integer goodsId = sq.poll(); //��������������

                    System.out.println("��ȡ��ƷID : " + goodsId);
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
                    System.out.println("���ɲ�ƷID : " + goodsId);
                    /**��������*/
//                    sq.put(goodsId++); // ���������һ������������ֻ�������˸�Node�����ܻ�����һ������
//                    sq.offer(goodsId++, 1000, TimeUnit.MILLISECONDS); //�������룬�����ʱ������������

                    /**����������*/
                    sq.offer(goodsId++);
//                    sq.add(goodsId++); //���Ԫ��ʧ��ʱ�����쳣
                    Thread.sleep(1000);

//                    System.out.println(sq.size()); // Դ����Զ����0
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
         * ����ʽ����
         */
        //?Core. ͨ��Condition�����������������������
        sq.put("123");
        sq.offer("123",2000, TimeUnit.MILLISECONDS);

        sq.take();
        sq.poll(2000, TimeUnit.MILLISECONDS);

        /** ��*/
        sq.add("1"); //ĩβ���
//        abq.add(1,"2"); //��֧�֣�ָ������ֵ���

        sq.offer("4"); //ĩβ���
        //Core. ������ˣ��ȴ�2000����֮����в��룬�ȴ���������û��Ӿ����쳣
        sq.offer("6", 2000, TimeUnit.MILLISECONDS);

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        sq.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        abq.addAll(0, list2); //��֧�֣�ָ������ֵ��Ӽ���
        System.out.println(sq);

        /** ɾ��*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
        sq.remove();
//        abq.remove(2); //��֧�֣�ָ��λ��ɾ��Ԫ��
        sq.remove("3");

        System.out.println(sq);

        //Core. �Ӷ���ȡһ������
        sq.poll();
        sq.poll(2000, TimeUnit.MILLISECONDS);

        list = new ArrayList<>();list.add("4");list.add("5");
        sq.removeAll(list);
        sq.retainAll(list); //ȡ2�����ϵĽ���

        /** �޸�*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
//        abq.set(0, "-1"); //��֧�֣�ָ��λ���޸Ĳ���


        /** ��*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
//        abq.get(2);
        System.out.println("abq.peek() = " + sq.peek());


        /** ����*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
        for (String item : sq) {
            System.out.println(item);
        }

        /** ��������API*/
        sq = new SynchronousQueue<>();
        sq.add("1");sq.add("2");sq.add("3");sq.add("4");sq.add("5");
        sq.clear();
//        abq.clone(); //ǳ����
        sq.size();
        sq.isEmpty();
        sq.contains("3");
//        abq.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); //�ַ�����
//            }
//        });
//        String[] a = new String[abq.size()];
//        abq.toArray(a);

    }
}
