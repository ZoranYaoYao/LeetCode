package com.zoran.data;

import java.util.Arrays;
import java.util.List;

/**
 * Array �����÷�
 */
public class ArrayTest {
    public static void main(String[] args) {
        /**
         * �����3�ִ�����ʽ
         */
        String[] strs = {"a","b","c"};
        int[] num = new int[5];
        int[] arr3=new int[]{1,2,3,4,5};

        //����Ψһ����
        int length = strs.length;
        testArraysAPI();
    }

    public static void testArraysAPI() {
        String[] nums = {"a","b","c"};
        /** 1.���ҹ��� */
        int loc = Arrays.binarySearch(nums, "c");
        System.out.println(loc);

        /** 2.����Ĵ�ӡ */
        System.out.println(Arrays.toString(nums));

        /** 3.����ĸ��� */
        String[] copyNum = Arrays.copyOf(nums, 1);
        System.out.println(Arrays.toString(copyNum));

        /** 4.���������ж��Ƿ���� */
        boolean res = Arrays.equals(nums, copyNum);
        System.out.println(res);

        /** 5.�����������*/
        String[] str = new String[4];
        Arrays.fill(str, "a");
        System.out.println(Arrays.toString(str));

        /** 6.������������ ����ʹ��comparator���ñȽ���*/
        String[] nums2 = {"c","b","a"};
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums2));

        /** 7.����ת�����ArrayList*/
        List<Integer> list = Arrays.asList(1,2,3);

    }
}
