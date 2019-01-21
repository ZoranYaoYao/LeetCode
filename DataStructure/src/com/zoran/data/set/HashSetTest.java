package com.zoran.data.set;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * HashSet
 * 内部封装一个HashMap对象，基本上所有的功能都是内部hashmap对象实现的！
 *
 * 功能对照HashMap
 */
public class HashSetTest {
    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {

        /** 增*/
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        ArrayList<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        hashSet.addAll(list);
        System.out.println(hashSet.toString());

        /** 删*/
        HashSet<Integer> hashSet1 = new HashSet<>();hashSet1.add(1);hashSet1.add(2);hashSet1.add(3);
        hashSet1.remove(1);
        ArrayList<Integer> list2 = new ArrayList<>(); list2.add(2); list2.add(3);
        hashSet1.removeAll(list2);
        hashSet1.retainAll(list2); //Core. 求交集

        /** 改*/
        HashSet<Integer> hashSet2 = new HashSet<>();hashSet2.add(1);hashSet2.add(2);hashSet2.add(3);
        hashSet2.remove(1);
        hashSet2.add(4);

        /** 查*/
        HashSet<Integer> hashSet3 = new HashSet<>();hashSet3.add(1);hashSet3.add(2);hashSet3.add(3);
        hashSet3.contains(1);

        /** 遍历*/
        HashSet<Integer> hashSet4 = new HashSet<>();hashSet4.add(1);hashSet4.add(2);hashSet4.add(3);
        for (Integer item : hashSet4) {
            System.out.println(item);
        }

        /** 其他常用API*/
        HashSet<Integer> hashSet5 = new HashSet<>();hashSet5.add(1);hashSet5.add(2);hashSet5.add(3);
        hashSet5.isEmpty();
        hashSet5.size();
        hashSet5.clear();
        hashSet5.clone();
    }
}
