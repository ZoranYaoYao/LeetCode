package com.zoran.algorithm.define.sort;

import java.util.Arrays;

public class S2选择排序 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 时间复杂度： O(n^2)
     * 空间复杂度：O(1)
     */
    private static void selectSort(int[] nums) {
        //在集合中，顺序位置上每次都选择最小的值
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
