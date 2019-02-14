package com.zoran.data.array;

/**
 * SparseArray
 *
 * refer:
 * https://blog.csdn.net/wzy_1988/article/details/51559012
 *
 * Android 优化的HashMap结构
 * 限制：
 * 只能针对 key 为int的HashMap结构
 *
 * 优点：
 * ?1. 节约内存
 * ?2. 查找效率快(二分查找，并且不用hash算法找索引)
 *
 * 用法：
 * 与HashMap类似
 */
public class SparseArrayTest {

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        /** 增*/
        SparseArray<String> sa = new SparseArray<>();
        //sa.put(1, "1");

        /** 删*/
        //sa.remove(1);

        /** 改*/
        //sa.put(1, "2");

        /** 查*/
        //sa.get(1);

        /** 遍历*/
//        for (int i=0; i<sa.size(); i++) {
//            int key = sa.keyAt(i);
//            String value = sa.valueAt(i);
//        }

        /** 其他常用API*/
//        sa.clear();
//        sa.size();
    }

    static class SparseArray<E>{

    }
}
