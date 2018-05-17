package com.zoran.leetcode;

import com.sun.javafx.image.IntPixelAccessor;

import sun.tools.jar.resources.jar;

/**
 * 最大子序和
 * https://blog.csdn.net/zzl913657644/article/details/52431011
 *
 */
public class Test11 {
	public static void main(String[] args) {
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};//1,-3,4,-1,2,1,-5,4
		System.out.println(Nice_maxSubArray(nums));
	}
	
	/**
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
	     输出: 6
            解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
            穷举法: 把所有长度的子序列进行穷举      
	 */
	public static int maxSubArray(int[] nums) {
		if(nums == null || nums.length ==0) return 0;
		int maxNum = nums[0]; int tmp=0;
		
		for(int i = 0; i < nums.length; i++) {
			tmp = 0;
			for(int j = i; j < nums.length; j++) {
				tmp += nums[j];
				if(tmp >= maxNum) {
					maxNum = tmp;
				}
			}
		}
		
		return maxNum;
	}
	
	/**
	 *  只有负数为一个时, 整体一个子序列 如果 < 0时, 则彻底清除 即 b= b>0 ? b =n; b
	 *  
	 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
	 */
	public static int Nice_maxSubArray(int[] nums) {
        int max = nums[0], b = 0;
        for (int n : nums) {
            b = b > 0 ? b + n : n;  //nice 的很,666
            max = max < b ? b : max;
        }
        return max;
    }
	
}
