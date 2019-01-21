package com.zoran.data.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;

/**
 * TreeMap
 * �ײ��Ǻ���� ʵ��
 *
 * ��ɾ�Ĳ鶼��ͨ����������в�����
 *
 * �ص㣺 �����ǰ�˳����б����ģ�
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        methodTest(map);
    }

    private static void methodTest(TreeMap<Integer, Integer> map) {
        /** ��*/
        map.put(1,1);
        HashMap<Integer, Integer> hashMap = new HashMap<>(); hashMap.put(2,2); hashMap.put(3,3);
        map.putAll(hashMap); //��Ӷ��Ԫ��
        System.out.println(map.toString());

        /** ɾ*/
        TreeMap<Integer, Integer> map2 = new TreeMap<>();map2.put(1,1); map2.put(2,2);
        map2.remove(1);
        map2.remove(2,-2); //Core. key,valueͬʱ����ʱ����ɾ��
        System.out.println(map2.toString());

        /** ��*/
        TreeMap<Integer, Integer> map3 = new TreeMap<>();map3.put(1,1); map3.put(2,2);map3.put(3,3);
        map3.put(1, -1);
        map3.replace(2,-2);
        map3.replace(3,3,-3);
        System.out.println(map3.toString());
        map3.replaceAll(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer key, Integer value) {
                //��keyС��2��Ӧ��ֵ��Ϊ0
                if (key<3) return 0;
                return value;
            }
        });
        System.out.println(map3.toString());

        /** ��*/
        TreeMap<Integer, Integer> map4 = new TreeMap<>();map4.put(1,1); map4.put(2,2);map4.put(3,3);
        map4.get(1); //Core. ��������ֲ���
        map4.getOrDefault(4, -1);

        /** ????����*/
        TreeMap<Integer, Integer> map5 = new TreeMap<>();map5.put(3,3);map5.put(1,1); map5.put(2,2);
        for(Map.Entry<Integer, Integer> item : map5.entrySet()) {
            System.out.println("key = " + item.getKey() + ", value = " + item.getValue());
        }

        TreeMap<Integer, Integer> map6 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2); //��������
            }
        });
        map6.put(3,3);map6.put(1,1); map6.put(2,2);
        System.out.println(map6.toString());

        /** ��������API*/
        TreeMap<Integer, Integer> map7 = new TreeMap<>();map7.put(3,3);map7.put(1,1); map7.put(2,2);
        map7.isEmpty();
        map7.size();
        map7.clear();
        map7.clone();
        map7.containsKey(1);
        map7.containsValue(1); //Core. ���Ұ���ֵ��Ҳ��ͨ������˳����в��ҵģ�
    }
}
