package com.zoran.data.set;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * LinkedHashSet
 * ͨ����̬���ԣ��ڲ���װһ��LinkedHashMap���󣬹���ȫ������LinkedHashMap����ʵ�֣�
 *
 * ע�⣺
 * LinkedHashSet ��accessOrder��Զ����false����ֻ�в���˳��û�з���˳��
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {

        /** ��*/
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        hashSet.add(1);
        ArrayList<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        hashSet.addAll(list);
        System.out.println(hashSet.toString());

        /** ɾ*/
        LinkedHashSet<Integer> hashSet1 = new LinkedHashSet<>();hashSet1.add(1);hashSet1.add(2);hashSet1.add(3);
        hashSet1.remove(1);
        ArrayList<Integer> list2 = new ArrayList<>(); list2.add(2); list2.add(3);
        hashSet1.removeAll(list2);
        hashSet1.retainAll(list2); //Core. �󽻼�

        /** ��*/
        LinkedHashSet<Integer> hashSet2 = new LinkedHashSet<>();hashSet2.add(1);hashSet2.add(2);hashSet2.add(3);
        hashSet2.remove(1);
        hashSet2.add(4);

        /** ��*/
        LinkedHashSet<Integer> hashSet3 = new LinkedHashSet<>();hashSet3.add(1);hashSet3.add(2);hashSet3.add(3);
        hashSet3.contains(1);

        /**???? ����*/
        System.out.println("����");
        LinkedHashSet<Integer> hashSet4 = new LinkedHashSet<>();hashSet4.add(3);hashSet4.add(2);hashSet4.add(1);
        for (Integer item : hashSet4) {
            System.out.println(item);
        }

        /** ��������API*/
        LinkedHashSet<Integer> hashSet5 = new LinkedHashSet<>();hashSet5.add(1);hashSet5.add(2);hashSet5.add(3);
        hashSet5.isEmpty();
        hashSet5.size();
        hashSet5.clear();
        hashSet5.clone();

    }
}
