package com.zoran.data.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * LinkedHashMap extends HashMap
 * 1.���Դ����������hashMapʵ�֣����˱����ǲ���˳��
 * 2.���accessOrder=true,����˳�򣬻�ı�˫�������˳��
 *
 * ���ԣ�
 * ͨ��ʹ��LinkedHashMap ��keySet(), values(), entrySet() ���ص��ǲ����˳��
 *
 * ����
 * map.put(1,1); //Core. �����key���ڣ������Ƿ���ģʽ��afterNodeAccess()���˫��������е���
 * map2.remove(1); //Core. �Ƴ�֮�󣬻����afterNodeRemoval()��˫��ѭ����������Ƴ���
 * map4.replace(1, -1); //Core. ����Ƿ���ģʽ��afterNodeAccess()���˫��������е���
 * map5.get(1); //Core. ����Ƿ���ģʽ��afterNodeAccess()���˫��������е���
 *
 * ����
 * LinkedHashMap (accessOrder)����˳����ص㣺
 * 1. ��put()�޸���ǰ���ڵ�ֵʱ�������afterNodeAccess(), ��put������ڵ�����������
 * 2. ��get()ʱ,�����ȡ���˷���ֵ����ô�Ὣ�ü��������������
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
        map.get(1); //Core�� get(Object ����)
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
        map2.put(1, -1); //Core�� get(Object ����)
        map2.put(2, -2);
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private static void methodTest(LinkedHashMap<Integer, Integer> map) {
        /** ��*/
        map.put(1,1);
        HashMap<Integer, Integer> hashMap = new HashMap<>(); hashMap.put(2,2);
        map.putAll(hashMap);

        /** ɾ*/
        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>(); map2.put(1,1);map2.put(2,2);map2.put(3,3);
        map2.remove(1); //Core. �Ƴ�֮�󣬻����afterNodeRemoval()��˫����������Ƴ���
        map2.remove(2,2);
        map2.remove(3,-3);
        System.out.println(map2.toString());

        /** ��*/
        LinkedHashMap<Integer, Integer> map4 = new LinkedHashMap<>(); map4.put(1,1);map4.put(2,2);map4.put(3,3);
        map4.replace(1, -1); //Core. ����Ƿ���ģʽ��afterNodeAccess()���˫��������е���
        map4.replace(2, 2, -2);
        map4.replace(3, 0, -3); //Core. ����ʱ��Ч��oldValue==0������ǣ����滻Ϊ-3������ʧ��
        System.out.println("��");
        for(Map.Entry<Integer, Integer> item : map4.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }
        map4.replaceAll(new BiFunction<Integer, Integer, Integer>() {
            /**
             * ������next,�������ԭ��
             */
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return 0; //integer-key, integer2-value �� ����ֵΪ�޸ĵĶ�Ӧkeyֵ
            }
        });
        for(Map.Entry<Integer, Integer> item : map4.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** ��*/
        LinkedHashMap<Integer, Integer> map5 = new LinkedHashMap<>(); map5.put(1,1);map5.put(2,2);map5.put(3,3);
        System.out.println("��");
        map5.get(1);
        System.out.println(map5.getOrDefault(1,-1)); //Core. ��ȡʱ���������򷵻�һ��Ĭ��ֵ
        System.out.println(map5.getOrDefault(4, -1));
        System.out.println(map5.getClass());

        /** ????����*/
        System.out.println("����");
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

        /** ��������API*/
        LinkedHashMap<Integer, Integer> map7 = new LinkedHashMap<>(); map7.put(1,1);map7.put(2,2);map7.put(3,3);
        map7.isEmpty();
        map7.size();
        map7.clear();
        map7.clone();
        map7.containsKey(1); map7.containsValue(1);
        System.out.println(map7.toString()); //Core ���ٲ鿴map����
    }
}
