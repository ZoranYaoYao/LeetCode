package com.zoran.data.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * TreeMap
 * 底层是红黑树 实现
 *
 * 增删改查都是通过红黑树进行操作的
 *
 * 特点： 遍历是按顺序进行遍历的！
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        methodTest(map);
    }

    private static void methodTest(TreeMap<Integer, Integer> map) {
        /** 增*/
        map.put(1,1);
        HashMap<Integer, Integer> hashMap = new HashMap<>(); hashMap.put(2,2); hashMap.put(3,3);
        map.putAll(hashMap); //添加多个元素
        System.out.println(map.toString());

        /** 删*/
        TreeMap<Integer, Integer> map2 = new TreeMap<>();map2.put(1,1); map2.put(2,2);
        map2.remove(1);
        map2.remove(2,-2); //Core. key,value同时满足时，才删除
        System.out.println(map2.toString());

        /** 改*/
        TreeMap<Integer, Integer> map3 = new TreeMap<>();map3.put(1,1); map3.put(2,2);map3.put(3,3);
        map3.put(1, -1);
        map3.replace(2,-2);
        map3.replace(3,3,-3);
        System.out.println(map3.toString());
        map3.replaceAll(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer key, Integer value) {
                //将key小于2对应的值改为0
                if (key<3) return 0;
                return value;
            }
        });
        System.out.println(map3.toString());

        /** 查*/
        TreeMap<Integer, Integer> map4 = new TreeMap<>();map4.put(1,1); map4.put(2,2);map4.put(3,3);
        map4.get(1); //Core. 红黑树二分查找
        map4.getOrDefault(4, -1);

        /** ????遍历*/
        TreeMap<Integer, Integer> map5 = new TreeMap<>();map5.put(3,3);map5.put(1,1); map5.put(2,2);
        for(Map.Entry<Integer, Integer> item : map5.entrySet()) {
            System.out.println("key = " + item.getKey() + ", value = " + item.getValue());
        }

        TreeMap<Integer, Integer> map6 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2); //逆序排序
            }
        });
        map6.put(3,3);map6.put(1,1); map6.put(2,2);
        System.out.println(map6.toString());

        /** 其他常用API*/
        TreeMap<Integer, Integer> map7 = new TreeMap<>();map7.put(3,3);map7.put(1,1); map7.put(2,2);
        map7.isEmpty();
        map7.size();
        map7.clear();
        map7.clone();
        map7.containsKey(1);
        map7.containsValue(1); //Core. 查找包含值，也是通过遍历顺序进行查找的！
    }
}
