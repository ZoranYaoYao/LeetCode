package com.zoran.leetcode.simple5;

import java.util.Arrays;

/**
 * 至少是其他数字两倍的最大数
 * https://leetcode-cn.com/submissions/detail/5467933/
 */
public class Test174 {
	
	public static void main(String[] args) {
		Test174 test174 = new Test174();
		int[] nums = {0,0,0,1};
		
		System.out.println(test174.dominantIndex(nums));
	}

    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;
        
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        
        Arrays.sort(temp);
        int max = temp[nums.length-1];
        if(max < temp[nums.length-2]*2) return -1;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == max) return i;
        }
        
        return -1;
    }
}
