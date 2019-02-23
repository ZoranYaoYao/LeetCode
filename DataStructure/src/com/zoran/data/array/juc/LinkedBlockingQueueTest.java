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
 * �ײ����ݽṹ��
 * һ���������� + 2���� + 2������
 *
 * ���ã�
 * ExecutorService executors = Executors.newFixedThreadPool(16);  * ��ȡ�̶��̸߳������̳߳�
 *
 * API�÷���
 * ��ArrayBlockingQueue����
 *
 * ����
 * ArrayBlockingQueue��LinkedBlockingQueue�Ա�
 *
 * ArrayBlockingQueue��
     * һ����������+һ����+��������
     * �������Ӷ���ͬһ����
     * ��ֻ����Ӹ߲�������Ӹ߲���������£���Ϊ�������飬�Ҳ���Ҫ���ݣ����ܸܺ�
     * ���������飬����ָ����С������������
 * LinkedBlockingQueue��
     * һ����������+������+��������
     * ��������һ��������ӣ�һ�����ڳ��ӣ���Ч�ı�������������ʱʹ��һ���������ľ�����
     * ���������Ӷ��߲���������£����ܱ�ArrayBlockingQueue�ߺܶ�
     * �����������������Ϊ�������ֵ���ɿ�����������
 */
public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        methodTest();
    }

    private static void methodTest() throws InterruptedException {
        LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");

        /**
         * ����ʽ����
         */
        //?Core. ͨ��Condition�����������������������
        lbq.put("123");
        lbq.offer("123",2000, TimeUnit.MILLISECONDS);

        lbq.take();
        lbq.poll(2000, TimeUnit.MILLISECONDS);

        /** ��*/
        lbq.add("1"); //ĩβ���
//        abq.add(1,"2"); //��֧�֣�ָ������ֵ���

        lbq.offer("4"); //ĩβ���
        //Core. ������ˣ��ȴ�2000����֮����в��룬�ȴ���������û��Ӿ����쳣
        lbq.offer("6", 2000, TimeUnit.MILLISECONDS);

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        lbq.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        abq.addAll(0, list2); //��֧�֣�ָ������ֵ��Ӽ���
        System.out.println(lbq);

        /** ɾ��*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
        lbq.remove();
//        abq.remove(2); //��֧�֣�ָ��λ��ɾ��Ԫ��
        lbq.remove("3");

        System.out.println(lbq);

        //Core. �Ӷ���ȡһ������
        lbq.poll();
        lbq.poll(2000, TimeUnit.MILLISECONDS);

        list = new ArrayList<>();list.add("4");list.add("5");
        lbq.removeAll(list);
        lbq.retainAll(list); //ȡ2�����ϵĽ���

        /** �޸�*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
//        abq.set(0, "-1"); //��֧�֣�ָ��λ���޸Ĳ���


        /** ��*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
//        abq.get(2);
        System.out.println("abq.peek() = " + lbq.peek());


        /** ����*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
        for (String item : lbq) {
            System.out.println(item);
        }

        /** ��������API*/
        lbq = new LinkedBlockingQueue<>(16);
        lbq.add("1");lbq.add("2");lbq.add("3");lbq.add("4");lbq.add("5");
        lbq.clear();
//        abq.clone(); //ǳ����
        lbq.size();
        lbq.isEmpty();
        lbq.contains("3");
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
