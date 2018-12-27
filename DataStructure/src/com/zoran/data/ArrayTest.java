package com.zoran.data;

import java.util.Arrays;
import java.util.List;

/**
 * Array 数据用法
 */
public class ArrayTest {
    public static void main(String[] args) {
        /**
         * 数组的3种创建方式
         */
        String[] strs = {"a","b","c"};
        int[] num = new int[5];
        int[] arr3=new int[]{1,2,3,4,5};

        //数组唯一属性
        int length = strs.length;
        testArraysAPI();
    }

    public static void testArraysAPI() {
        String[] nums = {"a","b","c"};
        /** 1.查找功能 */
        int loc = Arrays.binarySearch(nums, "c");
        System.out.println(loc);

        /** 2.数组的打印 */
        System.out.println(Arrays.toString(nums));

        /** 3.数组的复制 */
        String[] copyNum = Arrays.copyOf(nums, 1);
        System.out.println(Arrays.toString(copyNum));

        /** 4.数组对象的判断是否相等 */
        boolean res = Arrays.equals(nums, copyNum);
        System.out.println(res);

        /** 5.数组对象的填充*/
        String[] str = new String[4];
        Arrays.fill(str, "a");
        System.out.println(Arrays.toString(str));

        /** 6.数组对象的排序， 倒序使用comparator外置比较器*/
        String[] nums2 = {"c","b","a"};
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(nums2));

        /** 7.数组转特殊的ArrayList*/
        List<Integer> list = Arrays.asList(1,2,3);

    }
}
