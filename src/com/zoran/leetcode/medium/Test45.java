package com.zoran.leetcode.medium;

import java.util.Arrays;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ËÑË÷Ğı×ªÅÅĞòÊı×é II
 * https://leetcode-cn.com/submissions/detail/7012343/
 */
public class Test45 {

    public boolean search(int[] nums, int target) {
        //ÅÅĞò,ÕÛ°ë²éÕÒ
        if (nums == null || nums.length == 0) return false;
        
        Arrays.sort(nums);
        int left = 0; int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(nums[mid]== target) return true;
            else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return false;
    }
}
