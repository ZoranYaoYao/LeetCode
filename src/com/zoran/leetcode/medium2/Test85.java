package com.zoran.leetcode.medium2;

/**
 * Ñ°ÕÒ·åÖµ
 * https://leetcode-cn.com/submissions/detail/7963695/
 */
public class Test85 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        
        for(int i=0; i<nums.length; i++) {
            if (i+2<nums.length && nums[i+1] > nums[i] && nums[i+1] > nums[i+2] ) {
                return i+1;
            }
            
            if (i==0 && nums[i]>nums[i+1]) return 0;
            if (i==nums.length-1 && nums[i] > nums[i-1]) return nums.length-1;
        }
        
        return 0;
    }
}
