package com.zoran.data.set;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriteArraySet
 *
 * refer:
 * https://www.cnblogs.com/leesf456/p/5549138.html
 *
 * 底层原理：
 * 包装CopyOnWriteArrayList实现
 *
 * 用法: 与HashSet一致
 *
 * 2个特殊方法：
 * addIfAbsent()
 * addAllAbsent()
 */
public class CopyOnWriteArraySetTest {
    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {

        /** 增*/
        CopyOnWriteArraySet<Integer> hashSet = new CopyOnWriteArraySet<>();
        hashSet.add(1);
        ArrayList<Integer> list = new ArrayList<>(); list.add(2); list.add(3);
        hashSet.addAll(list);
        System.out.println(hashSet.toString());

        /** 删*/
        CopyOnWriteArraySet<Integer> hashSet1 = new CopyOnWriteArraySet<>();hashSet1.add(1);hashSet1.add(2);hashSet1.add(3);
        hashSet1.remove(1);
        ArrayList<Integer> list2 = new ArrayList<>(); list2.add(2); list2.add(3);
        hashSet1.removeAll(list2);
        hashSet1.retainAll(list2); //Core. 求交集

        /** 改*/
        CopyOnWriteArraySet<Integer> hashSet2 = new CopyOnWriteArraySet<>();hashSet2.add(1);hashSet2.add(2);hashSet2.add(3);
        hashSet2.remove(1);
        hashSet2.add(4);

        /** 查*/
        CopyOnWriteArraySet<Integer> hashSet3 = new CopyOnWriteArraySet<>();hashSet3.add(1);hashSet3.add(2);hashSet3.add(3);
        hashSet3.contains(1);

        /** 遍历*/
        CopyOnWriteArraySet<Integer> hashSet4 = new CopyOnWriteArraySet<>();hashSet4.add(1);hashSet4.add(2);hashSet4.add(3);
        for (Integer item : hashSet4) {
            System.out.println(item);
        }

        /** 其他常用API*/
        CopyOnWriteArraySet<Integer> hashSet5 = new CopyOnWriteArraySet<>();hashSet5.add(1);hashSet5.add(2);hashSet5.add(3);
        hashSet5.isEmpty();
        hashSet5.size();
        hashSet5.clear();
//        hashSet5.clone();
    }
}
