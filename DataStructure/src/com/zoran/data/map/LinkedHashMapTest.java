package com.zoran.data.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * LinkedHashMap extends HashMap
 * 1.所以大多数功能由hashMap实现，除了遍历是插入顺序
 * 2.如果accessOrder=true,访问顺序，会改变双向链表的顺序
 *
 * 特性：
 * 通过使用LinkedHashMap 的keySet(), values(), entrySet() 返回的是插入的顺序！
 *
 * 区别：
 * map.put(1,1); //Core. 如果该key存在，并且是访问模式，afterNodeAccess()会对双向链表进行调整
 * map2.remove(1); //Core. 移除之后，会调用afterNodeRemoval()将双向循环链表进行移除！
 * map4.replace(1, -1); //Core. 如果是访问模式，afterNodeAccess()会对双向链表进行调整
 * map5.get(1); //Core. 如果是访问模式，afterNodeAccess()会对双向链表进行调整
 *
 * 二。
 * LinkedHashMap (accessOrder)访问顺序的特点：
 * 1. 当put()修改以前存在的值时，会调用afterNodeAccess(), 将put的这个节点放在链表最后
 * 2. 当get()时,如果获取到了返回值，那么会将该及结点放在链表最后
 */
public class LinkedHashMapTest {

    /**
     * The iteration ordering method for this linked hash map: <tt>true</tt>
     * for access-order, <tt>false</tt> for insertion-order.
     *
     * @serial
     */
//    final boolean accessOrder;

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(9, 0.75f);
//        methodTest(map);
        methodAccessor();
    }

    private static void methodAccessor() {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(0, 0.75f, true);
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.get(1); //Core， get(Object 方法)
        map.get(2);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("----------");
        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>(0, 0.75f, true);
        map2.put(0, 0);
        map2.put(1, 1);
        map2.put(2, 2);
        map2.put(3, 3);
        map2.put(4, 4);
        map2.put(5, 5);
        map2.put(6, 6);
        map2.put(1, -1); //Core， get(Object 方法)
        map2.put(2, -2);
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static void methodTest(LinkedHashMap<Integer, Integer> map) {
        /** 增*/
        map.put(1,1);
        HashMap<Integer, Integer> hashMap = new HashMap<>(); hashMap.put(2,2);
        map.putAll(hashMap);

        /** 删*/
        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>(); map2.put(1,1);map2.put(2,2);map2.put(3,3);
        map2.remove(1); //Core. 移除之后，会调用afterNodeRemoval()将双向链表进行移除！
        map2.remove(2,2);
        map2.remove(3,-3);
        System.out.println(map2.toString());

        /** 改*/
        LinkedHashMap<Integer, Integer> map4 = new LinkedHashMap<>(); map4.put(1,1);map4.put(2,2);map4.put(3,3);
        map4.replace(1, -1); //Core. 如果是访问模式，afterNodeAccess()会对双向链表进行调整
        map4.replace(2, 2, -2);
        map4.replace(3, 0, -3); //Core. 调换时，效验oldValue==0，如果是，则替换为-3，否则失败
        System.out.println("改");
        for(Map.Entry<Integer, Integer> item : map4.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }
        map4.replaceAll(new BiFunction<Integer, Integer, Integer>() {
            /**
             * 利用了next,单链表的原理
             */
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return 0; //integer-key, integer2-value ， 返回值为修改的对应key值
            }
        });
        for(Map.Entry<Integer, Integer> item : map4.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** 查*/
        LinkedHashMap<Integer, Integer> map5 = new LinkedHashMap<>(); map5.put(1,1);map5.put(2,2);map5.put(3,3);
        System.out.println("查");
        map5.get(1);
        System.out.println(map5.getOrDefault(1,-1)); //Core. 获取时，不存在则返回一个默认值
        System.out.println(map5.getOrDefault(4, -1));
        System.out.println(map5.getClass());

        /** ????遍历*/
        System.out.println("遍历");
        LinkedHashMap<Integer, Integer> map6 = new LinkedHashMap<>(); map6.put(10,1);map6.put(2,2);map6.put(3,3);
        for(Integer item : map6.keySet()) {
            System.out.println(item);
        }
        for (Integer item : map6.values()) {
            System.out.println(item);
        }
        for (Map.Entry<Integer, Integer> item : map6.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** 其他常用API*/
        LinkedHashMap<Integer, Integer> map7 = new LinkedHashMap<>(); map7.put(1,1);map7.put(2,2);map7.put(3,3);
        map7.isEmpty();
        map7.size();
        map7.clear();
        map7.clone();
        map7.containsKey(1); map7.containsValue(1);
        System.out.println(map7.toString()); //Core 快速查看map内容
    }
}
