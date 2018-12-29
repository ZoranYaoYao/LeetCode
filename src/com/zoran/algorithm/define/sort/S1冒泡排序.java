package com.zoran.algorithm.define.sort;

import java.util.Arrays;

/**
 * https://baike.baidu.com/item/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F/4602306?fr=aladdin
 */
public class S1ð������ {

    public static void main(String[] args) {
        int[] nums = {2,5,9,4,1,4,6,10};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * ð�ݣ�ÿ�λ�ø��ֵ�����Ԫ�ص����
     * ƽ��ʱ�临�Ӷ�ΪO(n^2)
     * �ռ临�Ӷ�O(1)
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
