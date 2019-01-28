package com.zoran.data.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/**
 * ConcurrentHashMap 源码分析
 *
 * refer:
 * https://www.cnblogs.com/leesf456/p/5453341.html
 * https://www.cnblogs.com/dolphin0520/p/3932905.html
 *
 * 并发原理实现
 * 1. 通过用CAS 小颗粒的自旋操作保证同步
 * 2. 锁住Node[] table的头节点，实现分段技术
 *
 * 用法跟HashMap一模一样，底层数据结构也是一模一样
 *
 * Core:
 * ConcurrentHashMap可以做到读取数据不加锁，并且其内部的结构可以让其在进行写操作的时候能够将锁的粒度保持地尽量地小，不用对整个ConcurrentHashMap加锁
 *
 */
public class ConcurrentHashMapTest {

    //对于table的大小，会根据sizeCtl的值进行设置，如果没有设置szieCtl的值，那么默认生成的table大小为16，否则，会根据sizeCtl的大小设置table大小。
    //private transient volatile int sizeCtl;

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        /** 增*/
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>(); map.put(1,1);map.put(2,2);
        map.put(null, -1); //map可以允许有一个null的key
        System.out.println(map.get(null));
        map.put(1, 1);
        ConcurrentHashMap<Integer, Integer> map2 = new ConcurrentHashMap<>(); map2.put(2,2);
        map.putAll(map2);

        /** 删*/
        ConcurrentHashMap<Integer, Integer> map3 = new ConcurrentHashMap<>(); map3.put(1,1);map3.put(2,2);
        map3.remove(1);
        map3.remove(2,3);  //Core, 删除时，还会匹配value=3，key=2。 不然删除失败。
        for(Map.Entry<Integer, Integer> item : map3.entrySet()) {
            System.out.println("key =" + item.getKey() + ", value= " + item.getValue());
        }

        /** 改*/
        ConcurrentHashMap<Integer, Integer> map4 = new ConcurrentHashMap<>(); map4.put(1,1);map4.put(2,2);map4.put(3,3);
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
        ConcurrentHashMap<Integer, Integer> map5 = new ConcurrentHashMap<>(); map5.put(1,1);map5.put(2,2);map5.put(3,3);
        System.out.println("查");
        map5.get(1);
        System.out.println(map5.getOrDefault(1,-1)); //Core. 获取时，不存在则返回一个默认值
        System.out.println(map5.getOrDefault(4, -1));
        System.out.println(map5.getClass());

        /** 遍历*/
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

        /** 其他常用API*/
        ConcurrentHashMap<Integer, Integer> map7 = new ConcurrentHashMap<>(); map7.put(1,1);map7.put(2,2);map7.put(3,3);
        map7.isEmpty();
        map7.size();
        map7.clear();
//        map7.clone();
        map7.containsKey(1); map7.containsValue(1);
        System.out.println(map7.toString()); //Core 快速查看map内容
    }
}


/**
 * 源码抽离 解析
 */
class ConcurrentHashMap_Copy {
    /** 记录容器的容量大小，通过CAS更新*/
    private transient volatile long baseCount;

    /** ???sizeCtl等于0是默认值，大于0是扩容的阀值!,当sizeCtl小于0说明有多个线程正则等待扩容结果，参考transfer函数*/
    private transient volatile int sizeCtl;

    /** 转换红黑树阈值*/
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * The next table to use; non-null only while resizing.
     * 扩容的时候，记录的下一个表格，扩容2倍原数组
     */
    private transient volatile Node<K,V>[] nextTable;

    //region CAS模块
    /** 使用Unsafe 获取table索引i最新对象*/
    static final <K,V> ConcurrentHashMap.Node<K,V> tabAt(ConcurrentHashMap.Node<K,V>[] tab, int i) {
        return (ConcurrentHashMap.Node<K,V>)U.getObjectVolatile(tab, ((long)i << ASHIFT) + ABASE);
    }

    /** 使用Unsafe 期望值为c的时候，设置table索引i最新对象为v*/
    static final <K,V> boolean casTabAt(ConcurrentHashMap.Node<K,V>[] tab, int i,
                                        ConcurrentHashMap.Node<K,V> c, ConcurrentHashMap.Node<K,V> v) {
        return U.compareAndSwapObject(tab, ((long)i << ASHIFT) + ABASE, c, v);
    }

    /** 使用Unsafe 设置table索引i最新对象为v*/
    static final <K,V> void setTabAt(ConcurrentHashMap.Node<K,V>[] tab, int i, ConcurrentHashMap.Node<K,V> v) {
        U.putObjectVolatile(tab, ((long)i << ASHIFT) + ABASE, v);
    }
    //endregion

}


