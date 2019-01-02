package com.zoran.data.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList Դ�����
 */
public class LinkedListTest {

    public static void main(String[] args) {
        staticMethodTest();
        methodTest();
    }

    private static void methodTest() {
        LinkedList<String> linkedList = new LinkedList<>();

        /** ��*/
        linkedList.add("1"); //ĩβ���
        linkedList.add(1,"2"); //ָ������ֵ���
        linkedList.addFirst("0"); //ͷ���
        linkedList.addLast("3"); //ĩβ���

        linkedList.offer("4"); //��Ϊ˫������-ĩβ���
        linkedList.offerFirst("-1"); //��Ϊ˫������-�������
        linkedList.offerLast("5"); //��Ϊ˫������-ĩβ���

        List<String> list = new ArrayList<>();list.add("4");list.add("5");
        linkedList.addAll(list);
        List<String> list2 = new ArrayList<>();list2.add("-2");list2.add("-1");
        linkedList.addAll(0, list2);
        System.out.println(linkedList);

        /** ɾ��*/
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
        linkedList.retainAll(list); //ȡ2�����ϵĽ���

        /** �޸�*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.set(0, "-1");

        /** ��*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.get(2);
        linkedList.getFirst();
        linkedList.getLast();

        /** ����*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        for (String item : linkedList) {
            System.out.println(item);
        }

        /** ��������API*/
        linkedList = new LinkedList<>();
        linkedList.add("1");linkedList.add("2");linkedList.add("3");linkedList.add("4");linkedList.add("5");
        linkedList.clear();
        linkedList.clone(); //ǳ����
        linkedList.size();
        linkedList.isEmpty();
        linkedList.contains("3");
        linkedList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2); //�ַ�����
            }
        });
        String[] a = new String[linkedList.size()];
        linkedList.toArray(a);


        /** ��Ϊջʽ�ṹ*/
        LinkedList<String> linkedList2 = new LinkedList<>();
        linkedList2.push("1"); //��ջ

        linkedList2.pop(); //��ջ

        linkedList.peek(); //�鿴
        linkedList2.peekFirst();
        linkedList.peekLast();

    }

    private static void staticMethodTest() {

    }
}
