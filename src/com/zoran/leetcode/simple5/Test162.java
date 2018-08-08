package com.zoran.leetcode.simple5;

/**
 * ¶ş·Ö²éÕÒ
 * https://leetcode-cn.com/submissions/detail/5262240/
 */
public class Test162 {
	
    public int search(int[] nums, int target) {
        if(nums == null || nums.length ==0) return -1;
        
        int left = 0; int right = nums.length -1;
        while (left <= right) {
            int middle = left + (right -left)/2;
            if(nums[middle] == target) {
                return middle;
            }else if (nums[middle] > target) {
                right = middle -1;
            } else if (nums[middle] < target) {
                left = middle + 1;  
            }
        }
        return -1;
    }
}
