package com.zoran.algorithm.define.sort;

import java.util.Arrays;

public class S2ѡ������ {
    public static void main(String[] args) {
        int[] nums = {2, 5, 9, 4, 1, 4, 6, 10};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * ʱ�临�Ӷȣ� O(n^2)
     * �ռ临�Ӷȣ�O(1)
     */
    private static void selectSort(int[] nums) {
        //�ڼ����У�˳��λ����ÿ�ζ�ѡ����С��ֵ
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
