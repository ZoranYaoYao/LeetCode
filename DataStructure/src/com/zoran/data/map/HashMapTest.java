package com.zoran.data.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * HashMap API Դ�����
 *
 * 1. hashMap���ݽṹ��hash�㷨����ôʵ�ֵģ�
 * 2. HashMap�����ݻ��ƣ�
 * 3. JDK 1.8��hashMap������Ż���
 * 4. �����������ת��Ϊ������ģ�
 *
 * ��. ���ݻ���
 * loadFactor �� ֻ���ڴ��ι������Ż�ʱ��
 * threhold: Ĭ��Ϊ�����С��0.75����������ֵ����Note��ֻ�����вι��캯��ʱ������ʱ����2�ı���������������ǣ������С��2��*factory!!!!��
 *
 * ��������� Entry���� > threhold(���鳤��*loadFactor) �����鳤����أ���
 * if (++size > threshold)
 *             resize();
 * ��.
 *   HashMap 1.7֮ǰ�����Բ���ȫ����Ϊͷ�巨 �� 1.8û��������⣬���������ݶ�ʧ�����⣡
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
        /** ��*/
        map.put(null, -1); //map����������һ��null��key
        System.out.println(map.get(null));
        map.put(1, 1);
        HashMap<Integer, Integer> map2 = new HashMap<>(); map2.put(2,2);
        map.putAll(map2);

        /** ɾ*/
        HashMap<Integer, Integer> map3 = new HashMap<>(); map3.put(1,1);map3.put(2,2);
        map3.remove(1);
        map3.remove(2,3);  //Core, ɾ��ʱ������ƥ��value=3��key=2�� ��Ȼɾ��ʧ�ܡ�
        for(Map.Entry<Integer, Integer> item : map3.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** ��*/
        HashMap<Integer, Integer> map4 = new HashMap<>(); map4.put(1,1);map4.put(2,2);map4.put(3,3);
        map4.replace(1, -1);
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
        HashMap<Integer, Integer> map5 = new HashMap<>(); map5.put(1,1);map5.put(2,2);map5.put(3,3);
        System.out.println("��");
        map5.get(1);
        System.out.println(map5.getOrDefault(1,-1)); //Core. ��ȡʱ���������򷵻�һ��Ĭ��ֵ
        System.out.println(map5.getOrDefault(4, -1));
        System.out.println(map5.getClass());

        /** ����*/
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

        /** ��������API*/
        HashMap<Integer, Integer> map7 = new HashMap<>(); map7.put(1,1);map7.put(2,2);map7.put(3,3);
        map7.isEmpty();
        map7.size();
        map7.clear();
        map7.clone();
        map7.containsKey(1); map7.containsValue(1);
        System.out.println(map7.toString()); //Core ���ٲ鿴map����

    }
}
