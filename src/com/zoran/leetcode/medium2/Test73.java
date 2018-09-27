package com.zoran.leetcode.medium2;

import java.util.Arrays;

/**
 * 只出现一次的数字 II
 * https://leetcode-cn.com/submissions/detail/7611816/
 */
public class Test73 {

    public int singleNumber(int[] nums) {
        //排序,判断前后值是否相等
        Arrays.sort(nums);
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        
        int res = nums[nums.length-1];
        for(int i=1; i<nums.length; i++) {
            if(i == nums.length-1) break;
                
            if (nums[i] != nums[i-1] && nums[i] != nums[i+1]) {
                res = nums[i];
                break;
            } 
        }
        
        return res;
    }
}
