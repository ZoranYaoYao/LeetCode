package com.zoran.data.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * HashMap API 源码分析
 *
 * 1. hashMap数据结构的hash算法是怎么实现的？
 * 2. HashMap的扩容机制？
 * 3. JDK 1.8的hashMap链表的优化？
 * 4. 单链表是如何转化为红黑树的？
 *
 * 二. 扩容机制
 * loadFactor ： 只有在传参构造器才会时候
 * threhold: 默认为数组大小的0.75，是扩容阈值。（Note：只有在有参构造函数时，会临时等于2的倍数，其他情况都是，数组大小的2倍*factory!!!!）
 *
 * 扩容是针对 Entry个数 > threhold(数组长度*loadFactor) 跟数组长度相关！！
 * if (++size > threshold)
 *             resize();
 * 三.
 *   HashMap 1.7之前，线性不安全，因为头插法 。 1.8没有这个问题，但是有数据丢失的问题！
 *   https://www.toutiao.com/a6665069080048828936/?tt_from=weixin&utm_campaign=client_share&wxshare_count=1&timestamp=
 *   1551932813&app=news_article&utm_source=weixin&iid=65380750003&utm_medium=toutiao_android&group_id=6665069080048828936
 *
 */
public class HashMapTest {

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(9, 0.75f);
        methodTest(map);
        int lo = 0;
        System.out.println("~0 = " + ~0);
    }

    private static void methodTest(HashMap<Integer, Integer> map) {
        /** 增*/
        map.put(null, -1); //map可以允许有一个null的key
        System.out.println(map.get(null));
        map.put(1, 1);
        HashMap<Integer, Integer> map2 = new HashMap<>(); map2.put(2,2);
        map.putAll(map2);

        /** 删*/
        HashMap<Integer, Integer> map3 = new HashMap<>(); map3.put(1,1);map3.put(2,2);
        map3.remove(1);
        map3.remove(2,3);  //Core, 删除时，还会匹配value=3，key=2。 不然删除失败。
        for(Map.Entry<Integer, Integer> item : map3.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** 改*/
        HashMap<Integer, Integer> map4 = new HashMap<>(); map4.put(1,1);map4.put(2,2);map4.put(3,3);
        map4.replace(1, -1);
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
        HashMap<Integer, Integer> map5 = new HashMap<>(); map5.put(1,1);map5.put(2,2);map5.put(3,3);
        System.out.println("查");
        map5.get(1);
        System.out.println(map5.getOrDefault(1,-1)); //Core. 获取时，不存在则返回一个默认值
        System.out.println(map5.getOrDefault(4, -1));
        System.out.println(map5.getClass());

        /** 遍历*/
        HashMap<Integer, Integer> map6 = new HashMap<>(); map6.put(10,1);map6.put(2,2);map6.put(3,3);
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
        HashMap<Integer, Integer> map7 = new HashMap<>(); map7.put(1,1);map7.put(2,2);map7.put(3,3);
        map7.isEmpty();
        map7.size();
        map7.clear();
        map7.clone();
        map7.containsKey(1); map7.containsValue(1);
        System.out.println(map7.toString()); //Core 快速查看map内容

    }
}
