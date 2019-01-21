package com.zoran.data.set;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * TreeSet
 * ��װ��һ��TreeMap ����������й�����TreeMapʵ��
 *
 * ���ԣ�����˳���ǰ���С�������
 */
public class TreeSetTest {
    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {

        /** ��*/
        TreeSet<Integer> hashSet = new TreeSet<>();
        hashSet.add(1);
        ArrayList<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        hashSet.addAll(list);
        System.out.println(hashSet.toString());

        /** ɾ*/
        TreeSet<Integer> hashSet1 = new TreeSet<>();hashSet1.add(1);hashSet1.add(2);hashSet1.add(3);
        hashSet1.remove(1);
        ArrayList<Integer> list2 = new ArrayList<>(); list2.add(2); list2.add(3);
        hashSet1.removeAll(list2);
        hashSet1.retainAll(list2); //Core. �󽻼�

        /** ��*/
        TreeSet<Integer> hashSet2 = new TreeSet<>();hashSet2.add(1);hashSet2.add(2);hashSet2.add(3);
        hashSet2.remove(1);
        hashSet2.add(4);

        /** ��*/
        TreeSet<Integer> hashSet3 = new TreeSet<>();hashSet3.add(1);hashSet3.add(2);hashSet3.add(3);
        hashSet3.contains(1);

        /**???? ����*/
        System.out.println("����");
        TreeSet<Integer> hashSet4 = new TreeSet<>();hashSet4.add(3);hashSet4.add(2);hashSet4.add(1);
        for (Integer item : hashSet4) {
            System.out.println(item);
        }

        /** ��������API*/
        TreeSet<Integer> hashSet5 = new TreeSet<>();hashSet5.add(1);hashSet5.add(2);hashSet5.add(3);
        hashSet5.isEmpty();
        hashSet5.size();
        hashSet5.clear();
        hashSet5.clone();

    }
}
