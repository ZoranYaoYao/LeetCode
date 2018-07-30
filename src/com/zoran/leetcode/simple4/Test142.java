package com.zoran.leetcode.simple4;

/**
 * 子数组最大平均数 I
 * https://leetcode-cn.com/submissions/detail/4831398/
 * 
 * [Solution]
 * https://www.cnblogs.com/StoneLuo/p/7376076.html
 * 
 * 充分利用数组的数据结构,能在一次遍历中访问任何数据对象
 */
public class Test142 {
	public static void main(String[] args) {
		Test142 test142 = new Test142();
		int[] nums = {5};
		System.out.println(test142.findMaxAverage(nums, 1));
	}
	
	/**
	 * 超时 
	 */
    public double findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        double result = Integer.MIN_VALUE;
        for (int i=0; i<nums.length-k+1; i++) {
            double sum = 0;
            for(int j=i; j<i+k; j++) {
                sum += nums[j];
            }
            if(sum/k > result) result = sum/k;
        }
        
        return result;
    }
    
    public double Nice_findMaxAverage(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        double result = 0;
        double sum =0;
        for(int i =0; i < k; i++) {
        	sum += nums[i];
        }
        result = sum;
        
        for(int i=k; i<nums.length; i++) {
        	sum += nums[i] - nums[i-k];
        	if(sum > result) result = sum;
        }
        
        return result / k;
    }
    
}
