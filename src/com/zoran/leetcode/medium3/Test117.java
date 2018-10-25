package com.zoran.leetcode.medium3;

/**
 * 寻找重复数
 * https://leetcode-cn.com/submissions/detail/8654626/
 */
public class Test117 {

    public int findDuplicate(int[] nums) {
        //多用一个数组 纪录1-n中的个数
        int[] count = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            count[nums[i]] += 1;
            if(count[nums[i]] > 1) return nums[i];
        }
        
        return -1;
    }
}
