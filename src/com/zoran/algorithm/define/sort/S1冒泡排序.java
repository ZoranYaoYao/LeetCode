package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F/4602306?fr=aladdin
 */
public class S1冒泡排序 {

    public static void main(String[] args) {
        int[] nums = {2,5,9,4,1,4,6,10};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡，每次获得该轮的最大的元素到最后
     * 平均时间复杂度为O(n^2)
     * 空间复杂度O(1)
     */
    private static void bubbleSort(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            for (int j=0; j<nums.length-1-i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
