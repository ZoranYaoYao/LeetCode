package com.zoran.leetcode.simple3;

import java.util.Arrays;

/**
 * ȱʧ����
 * https://leetcode-cn.com/submissions/detail/3429620/
 */
public class Test63 {
	
	public static void main(String[] args) {
		int[] nums = {3,0,1};
		System.out.println(Nice_missingNumber(nums));
	}

	/**
	 * ����һ˳�� 
	 * ʱ�临�Ӷ�: O(����) + O(n)
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
     * Core: i˳�����, ���ʣ�µ� Ҫô�����һλ, Ҫô����������ȱ�ٵ�һλ
     * ʱ�临�Ӷ�: O(n)
     */
    public static int Nice_missingNumber(int[] nums) {
        int ret = nums.length;  
       for (int i = 0; i < nums.length; i++) {  
           ret += (i - nums[i]);  
       }  
       return ret;   
   }
}
