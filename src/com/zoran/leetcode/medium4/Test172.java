package com.zoran.leetcode.medium4;

/**
 * 数组中两个数的最大异或值
 * https://leetcode-cn.com/submissions/detail/10541966/
 */
public class Test172 {
    public int findMaximumXOR(int[] nums) {
        //暴力求解
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                res = Math.max(nums[i]^nums[j], res);
            }
        }
        return res;
    }
}
