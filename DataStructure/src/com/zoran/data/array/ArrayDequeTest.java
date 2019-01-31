package com.zoran.data.array;

import java.util.*;

/**
 * ArrayDequue: Array Double end queue
 *
 * �ײ����ݽṹ��
 * 1. ѭ������
 * 2. ˫ָ�룬 headָ��ǰ���е�ͷ�� tailָ����һ���ɲ����β������
 * 
 * ���ã�JDK �Ƽ�
 * 1. ��Ϊ˫�˶��� �����ȼ�: ArrayDeque > LinkedList��
 * 2. ��Ϊջ�ṹ
 *
 * ������LinkedList�������Ա�ʹ��
 * ����
 * 1. LinkedList����ָ��λ�ý������ɾ���޸Ĳ�ѯ�� ArrayDeque����
 * 2. LinkedList �ײ����ݽṹ���õ�˫������ṹ�� ArrayDequeue���õ���ѭ������
 *
 * ���ܣ�
 * ArrayDeque ���� LinkedList
 * ������LinkedList�����������������ArrayDeque����
 */
public class ArrayDequeTest {

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        ArrayDeque<String> dequeue = new ArrayDeque<>();

        /** ��*/
        dequeue.add("1"); //ĩβ���
//        dequeue.add(1,"2"); //��֧�֣�ָ������ֵ���
        dequeue.addFirst("0"); //ͷ���
        dequeue.addLast("3"); //ĩβ���

        dequeue.offer("4"); //��Ϊ˫������-ĩβ���
        dequeue.offerFirst("-1"); //��Ϊ˫������-�������
        dequeue.offerLast("5"); //��Ϊ˫������-ĩβ���

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        dequeue.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
//        dequeue.addAll(0, list2); //��֧�֣�ָ������ֵ��Ӽ���
        System.out.println(dequeue);

        /** ɾ��*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
        dequeue.remove();
//        dequeue.remove(2); //��֧�֣�ָ��λ��ɾ��Ԫ��
        dequeue.remove("3");

        dequeue.removeFirst();
        dequeue.removeLast();
        System.out.println(dequeue);

        dequeue.poll();
        dequeue.pollFirst();
        dequeue.pollLast();

        list = new ArrayList<>();list.add("4");list.add("5");
        dequeue.removeAll(list);
        dequeue.retainAll(list); //ȡ2�����ϵĽ���

        /** �޸�*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
//        dequeue.set(0, "-1"); //��֧�֣�ָ��λ���޸Ĳ���

        /** ��*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
//        dequeue.get(2);
        dequeue.getFirst();
        dequeue.getLast();

        /** ����*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
        for (String item : dequeue) {
            System.out.println(item);
        }

        /** ��������API*/
        dequeue = new ArrayDeque<>();
        dequeue.add("1");dequeue.add("2");dequeue.add("3");dequeue.add("4");dequeue.add("5");
        dequeue.clear();
        dequeue.clone(); //ǳ����
        dequeue.size();
        dequeue.isEmpty();
        dequeue.contains("3");
//        dequeue.sort(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2); //�ַ�����
//            }
//        });
//        String[] a = new String[dequeue.size()];
//        dequeue.toArray(a);


        /** ��Ϊջʽ�ṹ*/
        ArrayDeque<String> dequeue2 = new ArrayDeque<>();
        dequeue2.push("1"); //��ջ

        dequeue2.pop(); //��ջ

        dequeue.peek(); //�鿴
        dequeue2.peekFirst();
        dequeue.peekLast();

    }
}
