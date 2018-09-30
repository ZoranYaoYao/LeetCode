package com.zoran.leetcode.medium2;

import java.util.Arrays;

/**
 * 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/submissions/detail/7748414/ 
 * 
 * leetCode
 */
public class Test84 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        return nums[0];
    }
}

class LeetCode_Test84 {
    public int findMin(int[] nums) {
		int left =0; int right = nums.length-1;
		while (left < right) {
			int mid = (left+right)/2;
			if (nums[mid] > nums[right]) { //Core. 是与right相比较
				left = mid+1;
			} else {
				right = mid; //Core. right的索引值要包含中间这个比对的元素!
			}
		}
		return nums[left];
    }
}
