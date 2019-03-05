package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/%E8%AE%A1%E6%95%B0%E6%8E%92%E5%BA%8F/8518144?fr=aladdin
 * https://www.cnblogs.com/onepixel/articles/7674659.html#undefined
 *
 * 时间复杂度：O(n+k)
 * 空间复杂度：O(n+k)
 *
 * <p>
 * 优点：它的复杂度为Ο(n+k)（其中k是整数的范围），快于任何比较排序算法
 * 缺点：只适用用能计数的对象（byte,int,long,char）
 *      当然这是一种牺牲空间换取时间的做法，而且当O(k)>O(n*log(n))的时候其效率反而不如基于比较的排序
 */
public class S8计数排序 {

    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        int max = Integer.MIN_VALUE;
        for (int item : nums){
            max = Math.max(max, item);
        }
        countingSort(nums, max);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 通过数组索引存值， 地址存个数的方式进行遍历排序
     * @param arr 原始数组
     * @param maxValue 该数组中最大的元素
     */
    private static void countingSort(int[] arr,int  maxValue) {
        int[] bucket = new int[maxValue+1]; //Core 利用数组进行索引存数值，值存个数

        for (int i=0; i<arr.length; i++) {
            bucket[arr[i]]++;
        }

        int sortedIndex = 0;
        for (int j=0; j<bucket.length; j++) {
            while (bucket[j]>0){
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
    }
}
