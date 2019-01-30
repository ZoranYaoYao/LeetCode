package com.zoran.algorithm.define;

import java.util.Arrays;

/**
 * com.zoran.leetcode.medium6.Test251
 */
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
		int left = 0; int right = nums.length-1; //Nice_Core right为数组可以取到的索引值
		while (left <= right) {
			int mid = (left + right)/2;
			if(nums[mid] == target) return true;
			else if(nums[mid] > target) right = mid-1;
			else left = mid+1;
		}
		
		return false;
	}

	/**
	 * 第二种方式
	 */
	public boolean binarySearch_2(int[] nums, int target) {
		if (nums == null || nums.length == 0) return false;
		Arrays.sort(nums);
		int left = 0; int right = nums.length; //Core. right表示不能超过的范围
		while(left < right) {
			int mid = left + (right-left)/2;
			if (nums[mid] == target) return true;
			else if (nums[mid] > target) right = mid; //Core. right表示不能超过的边界
			else
				left = mid+1;
		}

		return false;
	}
}
