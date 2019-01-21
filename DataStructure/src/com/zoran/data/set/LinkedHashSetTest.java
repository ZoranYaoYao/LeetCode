package com.zoran.data.set;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * LinkedHashSet
 * 通过多态特性，内部封装一个LinkedHashMap对象，功能全部是有LinkedHashMap对象实现！
 *
 * 注意：
 * LinkedHashSet 的accessOrder永远等于false，即只有插入顺序，没有访问顺序
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {

        /** 增*/
        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>();
        hashSet.add(1);
        ArrayList<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        hashSet.addAll(list);
        System.out.println(hashSet.toString());

        /** 删*/
        LinkedHashSet<Integer> hashSet1 = new LinkedHashSet<>();hashSet1.add(1);hashSet1.add(2);hashSet1.add(3);
        hashSet1.remove(1);
        ArrayList<Integer> list2 = new ArrayList<>(); list2.add(2); list2.add(3);
        hashSet1.removeAll(list2);
        hashSet1.retainAll(list2); //Core. 求交集

        /** 改*/
        LinkedHashSet<Integer> hashSet2 = new LinkedHashSet<>();hashSet2.add(1);hashSet2.add(2);hashSet2.add(3);
        hashSet2.remove(1);
        hashSet2.add(4);

        /** 查*/
        LinkedHashSet<Integer> hashSet3 = new LinkedHashSet<>();hashSet3.add(1);hashSet3.add(2);hashSet3.add(3);
        hashSet3.contains(1);

        /**???? 遍历*/
        System.out.println("遍历");
        LinkedHashSet<Integer> hashSet4 = new LinkedHashSet<>();hashSet4.add(3);hashSet4.add(2);hashSet4.add(1);
        for (Integer item : hashSet4) {
            System.out.println(item);
        }

        /** 其他常用API*/
        LinkedHashSet<Integer> hashSet5 = new LinkedHashSet<>();hashSet5.add(1);hashSet5.add(2);hashSet5.add(3);
        hashSet5.isEmpty();
        hashSet5.size();
        hashSet5.clear();
        hashSet5.clone();

    }
}
