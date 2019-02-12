package com.zoran.data.array;

import java.util.*;

/**
 * refer��
 * https://github.com/CarpenterLee/JCFInternals/blob/master/markdown/8-PriorityQueue.md
 *
 * PriorityQueue
 *
 * �ײ����ݽṹ��
 * ����
 *
 * ʵ��ԭ��:
 * ͨ����ȫ��������complete binary tree��ʵ�ֵ�С����
 * ���鹹�ɵļ�С��
 *
 * API������
 * ��ArrayQueueѭ����������
 *
 * ����㣺
 * 1. ������Iterator��remove()����ʱ�����ܻ�������Ʋ��������±�����ȫ�����Ի���һ����¼�Ĺ���
 * https://blog.csdn.net/u011518120/article/details/53022406
 */
public class PriorityQueueTest extends PriorityQueue<Integer> {

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        /** ��*/
        priorityQueue.add("1"); //ĩβ���
//        dequeue.add(1,"2"); //��֧�֣�ָ������ֵ���

        priorityQueue.offer("4"); //ĩβ���
//
        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        priorityQueue.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        dequeue.addAll(0, list2); //��֧�֣�ָ������ֵ��Ӽ���
        System.out.println(priorityQueue);

        /** ɾ��*/
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add("1");priorityQueue.add("2");priorityQueue.add("3");priorityQueue.add("4");priorityQueue.add("5");
        priorityQueue.remove();
        priorityQueue.remove("5");

        System.out.println(priorityQueue);

        priorityQueue.poll();

        list = new ArrayList<>();list.add("4");list.add("5");
        priorityQueue.removeAll(list);
        priorityQueue.retainAll(list); //ȡ2�����ϵĽ���

        /** �޸�*/
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add("1");priorityQueue.add("2");priorityQueue.add("3");priorityQueue.add("4");priorityQueue.add("5");
//        priorityQueue.set(0, "-1"); //��֧�֣�ָ��λ���޸Ĳ���

        /** ��*/
        priorityQueue = new PriorityQueue<>();
        priorityQueue.add("1");priorityQueue.add("2");priorityQueue.add("3");priorityQueue.add("4");priorityQueue.add("5");
//        dequeue.get(2);
        priorityQueue.peek();

        /** ����*/
        PriorityQueue<Integer> pri = new PriorityQueue<>();
        pri.add(5);pri.add(4);pri.add(3);pri.add(2);pri.add(1);
        Iterator iterator = pri.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Integer item : pri) {
            System.out.println(item);
        }

        /** ��������API*/
        pri = new PriorityQueue<>();
        pri.add(5);pri.add(4);pri.add(3);pri.add(2);pri.add(1);
        pri.clear();
//        dequeue.clone(); //ǳ����
        pri.size();
        pri.isEmpty();
        pri.contains("3");
        String[] a = new String[pri.size()];
        pri.toArray(a);

    }
}
