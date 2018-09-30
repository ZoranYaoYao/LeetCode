package com.zoran.leetcode.medium2;

import java.util.Arrays;

/**
 * Ѱ����ת���������е���Сֵ
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
			if (nums[mid] > nums[right]) { //Core. ����right��Ƚ�
				left = mid+1;
			} else {
				right = mid; //Core. right������ֵҪ�����м�����ȶԵ�Ԫ��!
			}
		}
		return nums[left];
    }
}
