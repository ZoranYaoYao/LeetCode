package com.zoran.algorithm;

/**
 * ¶ş·Ö²éÕÒ 
 */
public class Demo02 {
	
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
