package com.zoran.data.array.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * ArrayBlockingQueue ��������
 *
 * �ײ����ݽṹ
 * ѭ�����飨û�����ݻ��ƣ�
 *
 * ����
 * java.util.concurrent.ArrayBlockingQueue;
 *
 * ���ܣ�
 * 1. �����ݵ���ӣ�ɾ����������������������֤���԰�ȫ
 * 2. �ṩ����ʽ���룬��ȡ
 *
 * ʹ�û�����
 * ���������µģ��жӵ�����У�������
 * eg: Executors�̳߳��еĶ���
 *
 * APIʹ�ã�
 * ArrayDeque�Ĳ�������ȥ��Deque�ӿڵķ�����
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
         * ����ʽ����
         */
        //?Core. ͨ��Condition�����������������������
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        abq.take();
        abq.poll(2000, TimeUnit.MILLISECONDS);
        abq.put("123");
        abq.offer("123",2000, TimeUnit.MILLISECONDS);

        /** ��*/
        abq.add("1"); //ĩβ���
//        abq.add(1,"2"); //��֧�֣�ָ������ֵ���

        abq.offer("4"); //ĩβ���
        //Core. ������ˣ��ȴ�2000����֮����в��룬�ȴ���������û��Ӿ����쳣
        abq.offer("6", 2000, TimeUnit.MILLISECONDS);

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        abq.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        abq.addAll(0, list2); //��֧�֣�ָ������ֵ��Ӽ���
        System.out.println(abq);

        /** ɾ��*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        abq.remove();
//        abq.remove(2); //��֧�֣�ָ��λ��ɾ��Ԫ��
        abq.remove("3");

        System.out.println(abq);

        //Core. �Ӷ���ȡһ������
        abq.poll();
        abq.poll(2000, TimeUnit.MILLISECONDS);

        list = new ArrayList<>();list.add("4");list.add("5");
        abq.removeAll(list);
        abq.retainAll(list); //ȡ2�����ϵĽ���

        /** �޸�*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
//        abq.set(0, "-1"); //��֧�֣�ָ��λ���޸Ĳ���


        /** ��*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
//        abq.get(2);
        System.out.println("abq.peek() = " + abq.peek());


        /** ����*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        for (String item : abq) {
            System.out.println(item);
        }

        /** ��������API*/
        abq = new ArrayBlockingQueue<>(16);
        abq.add("1");abq.add("2");abq.add("3");abq.add("4");abq.add("5");
        abq.clear();
//        abq.clone(); //ǳ����
        abq.size();
        abq.isEmpty();
        abq.contains("3");
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
