package com.zoran.data.array;

/**
 * SparseArray
 *
 * refer:
 * https://blog.csdn.net/wzy_1988/article/details/51559012
 *
 * Android �Ż���HashMap�ṹ
 * ���ƣ�
 * ֻ����� key Ϊint��HashMap�ṹ
 *
 * �ŵ㣺
 * ?1. ��Լ�ڴ�
 * ?2. ����Ч�ʿ�(���ֲ��ң����Ҳ���hash�㷨������)
 *
 * �÷���
 * ��HashMap����
 */
public class SparseArrayTest {

    public static void main(String[] args) {
        methodTest();
    }

    private static void methodTest() {
        /** ��*/
        SparseArray<String> sa = new SparseArray<>();
        //sa.put(1, "1");

        /** ɾ*/
        //sa.remove(1);

        /** ��*/
        //sa.put(1, "2");

        /** ��*/
        //sa.get(1);

        /** ����*/
//        for (int i=0; i<sa.size(); i++) {
//            int key = sa.keyAt(i);
//            String value = sa.valueAt(i);
//        }

        /** ��������API*/
//        sa.clear();
//        sa.size();
    }

    static class SparseArray<E>{

    }
}
