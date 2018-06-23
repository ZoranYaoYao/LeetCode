package com.zoran.leetcode.simple3;

import java.util.Arrays;

/**
 * 缺失数字
 * https://leetcode-cn.com/submissions/detail/3429620/
 */
public class Test63 {
	
	public static void main(String[] args) {
		int[] nums = {3,0,1};
		System.out.println(Nice_missingNumber(nums));
	}

	/**
	 * 排了一顺序 
	 * 时间复杂度: O(排序) + O(n)
	 */
    public static int missingNumber(int[] nums) {
    	if(nums == null) return -1;
        if(nums[0] == 0 && nums.length == 1) return 1;
        if(nums[0] == 1 && nums.length == 1) return 0;
    	
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
        	if(i != nums[i]) return i;
        }
        
        return nums[nums.length -1] +1;
    }
    
    /**
     * Core: i顺序相减, 最后剩下的 要么是最后一位, 要么就是数组中缺少的一位
     * 时间复杂度: O(n)
     */
    public static int Nice_missingNumber(int[] nums) {
        int ret = nums.length;  
       for (int i = 0; i < nums.length; i++) {  
           ret += (i - nums[i]);  
       }  
       return ret;   
   }
}
