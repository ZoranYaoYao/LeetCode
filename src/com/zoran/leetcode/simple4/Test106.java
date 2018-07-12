package com.zoran.leetcode.simple4;

/**
 * 最大连续1的个数
 * https://leetcode-cn.com/submissions/detail/4073186/
 */
public class Test106 {
	
	public static void main(String[] args) {
		int[] nums = {1,0,1,1,0,1};
		System.out.println(findMaxConsecutiveOnes(nums));
	}

    public static int findMaxConsecutiveOnes(int[] nums) {
    	if(nums == null || nums.length ==0) return 0;
    	
        int maxCount = 0; int count = 0;
        for (int i =0; i < nums.length; i++) {
            if(nums[i] == 1) {
                count++;
            } else {
                if(count > maxCount) maxCount = count;
                count = 0;
            }
        }
        
        if(count != 0 && count > maxCount) maxCount = count; 
        
        return maxCount;
    }
}
