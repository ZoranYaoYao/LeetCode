package com.zoran.leetcode.medium;

/**
 *  颜色分类
 * https://leetcode-cn.com/submissions/detail/6945111/
 */
public class Test40 {

    public void sortColors(int[] nums) {
        //冒泡排序算法
        if (nums == null || nums.length ==0) return;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=0; j<nums.length-i; j++) {
                if(j+1<nums.length && nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
