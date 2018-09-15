package com.zoran.algorithm.define;

import java.util.Arrays;

public class 二分查找算法 {

	/**
	 * 搜索二维矩阵
	 * https://leetcode-cn.com/submissions/detail/6883442/
	 */
	
	/**
	 * 标准格式
	 */
	public boolean binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) return false;
		
		Arrays.sort(nums);
		int left = 0; int right = nums.length-1;
		while (left <= right) {
			int mid = (left + right)/2;
			if(nums[mid] == target) return true;
			else if(nums[mid] > target) right = mid-1;
			else left = mid+1;
		}
		
		return false;
	}
}
