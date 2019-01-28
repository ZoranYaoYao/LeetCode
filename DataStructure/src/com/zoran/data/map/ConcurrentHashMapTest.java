package com.zoran.data.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * ConcurrentHashMap Դ�����
 *
 * refer:
 * https://www.cnblogs.com/leesf456/p/5453341.html
 * https://www.cnblogs.com/dolphin0520/p/3932905.html
 *
 * ����ԭ��ʵ��
 * 1. ͨ����CAS С����������������֤ͬ��
 * 2. ��סNode[] table��ͷ�ڵ㣬ʵ�ֶַμ���
 *
 * �÷���HashMapһģһ�����ײ����ݽṹҲ��һģһ��
 *
 * Core:
 * ConcurrentHashMap����������ȡ���ݲ��������������ڲ��Ľṹ���������ڽ���д������ʱ���ܹ����������ȱ��ֵؾ�����С�����ö�����ConcurrentHashMap����
 *
 */
public class ConcurrentHashMapTest {

    //����table�Ĵ�С�������sizeCtl��ֵ�������ã����û������szieCtl��ֵ����ôĬ�����ɵ�table��СΪ16�����򣬻����sizeCtl�Ĵ�С����table��С��
    //private transient volatile int sizeCtl;

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        /** ��*/
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(); map.put(1,1);map.put(2,2);
        map.put(null, -1); //map����������һ��null��key
        System.out.println(map.get(null));
        map.put(1, 1);
        ConcurrentHashMap<Integer, Integer> map2 = new ConcurrentHashMap<>(); map2.put(2,2);
        map.putAll(map2);

        /** ɾ*/
        ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>(); map3.put(1,1);map3.put(2,2);
        map3.remove(1);
        map3.remove(2,3);  //Core, ɾ��ʱ������ƥ��value=3��key=2�� ��Ȼɾ��ʧ�ܡ�
        for(Map.Entry<Integer, Integer> item : map3.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** ��*/
        ConcurrentHashMap<Integer, Integer> map4 = new ConcurrentHashMap<>(); map4.put(1,1);map4.put(2,2);map4.put(3,3);
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
        ConcurrentHashMap<Integer, Integer> map5 = new ConcurrentHashMap<>(); map5.put(1,1);map5.put(2,2);map5.put(3,3);
        System.out.println("��");
        map5.get(1);
        System.out.println(map5.getOrDefault(1,-1)); //Core. ��ȡʱ���������򷵻�һ��Ĭ��ֵ
        System.out.println(map5.getOrDefault(4, -1));
        System.out.println(map5.getClass());

        /** ����*/
        ConcurrentHashMap<Integer, Integer> map6 = new ConcurrentHashMap<>(); map6.put(10,1);map6.put(2,2);map6.put(3,3);
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
        ConcurrentHashMap<Integer, Integer> map7 = new ConcurrentHashMap<>(); map7.put(1,1);map7.put(2,2);map7.put(3,3);
        map7.isEmpty();
        map7.size();
        map7.clear();
//        map7.clone();
        map7.containsKey(1); map7.containsValue(1);
        System.out.println(map7.toString()); //Core ���ٲ鿴map����
    }
}


/**
 * Դ����� ����
 */
class ConcurrentHashMap_Copy {
    /** ��¼������������С��ͨ��CAS����*/
    private transient volatile long baseCount;

    /** ???sizeCtl����0��Ĭ��ֵ������0�����ݵķ�ֵ!,��sizeCtlС��0˵���ж���߳�����ȴ����ݽ�����ο�transfer����*/
    private transient volatile int sizeCtl;

    /** ת���������ֵ*/
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * The next table to use; non-null only while resizing.
     * ���ݵ�ʱ�򣬼�¼����һ���������2��ԭ����
     */
    private transient volatile Node<K,V>[] nextTable;

    //region CASģ��
    /** ʹ��Unsafe ��ȡtable����i���¶���*/
    static final <K,V> ConcurrentHashMap.Node<K,V> tabAt(ConcurrentHashMap.Node<K,V>[] tab, int i) {
        return (ConcurrentHashMap.Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
    }

    /** ʹ��Unsafe ����ֵΪc��ʱ������table����i���¶���Ϊv*/
    static final <K,V> boolean casTabAt(ConcurrentHashMap.Node<K,V>[] tab, int i,
                                        ConcurrentHashMap.Node<K,V> c, ConcurrentHashMap.Node<K,V> v) {
        return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
    }

    /** ʹ��Unsafe ����table����i���¶���Ϊv*/
    static final <K,V> void setTabAt(ConcurrentHashMap.Node<K,V>[] tab, int i, ConcurrentHashMap.Node<K,V> v) {
        U.putObjectVolatile(tab, ((long)i << ASHIFT) + ABASE, v);
    }
    //endregion

}


