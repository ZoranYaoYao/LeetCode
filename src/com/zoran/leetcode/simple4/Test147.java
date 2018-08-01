package com.zoran.leetcode.simple4;

/**
 * 非递减数列
 * https://leetcode-cn.com/submissions/detail/4932178/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80204834
 */
public class Test147 {
	public static void main(String[] args) {
		Test147 test147 = new Test147();
		int[] nums = {3,4,2,3};
		System.out.println(test147.Nice_checkPossibility(nums));
	}
	/**
	 * [2,3,3,2,4] 算法不对
	 */
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(i == nums.length -1) continue;
            
            for(int j=i+1; j<nums.length; j++) {
                if(nums[i] > nums[j]) {
                    count++;
                    break;
                }
            }
        }
        
        return count <= 1;
    }
    
    public boolean Nice_checkPossibility(int[] nums) {
    	int i=0, j= nums.length -1;
    	while (i <j && nums[i] <= nums[i+1]) {
    		i++;
    	}
    	while (i<j && nums[j] >= nums[j-1]) {
    		j--;
    	}
    	int head =0;
    	if(i ==0) head = Integer.MIN_VALUE;
    	else head = nums[i-1];
    	
    	int next = (j == nums.length -1)? Integer.MAX_VALUE: nums[j+1];
    	if(j-i <=1 && (head <= nums[j] || nums[i] <= next)) return true;
    	return false;
    	
    }
}
