package com.zoran.leetcode.medium2;

import java.util.Arrays;
/**
 * �����еĵ�K�����Ԫ��
 *https://leetcode-cn.com/submissions/detail/8152511/
 */
public class Test97 {

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)  return -1;
        
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
