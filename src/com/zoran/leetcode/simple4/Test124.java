package com.zoran.leetcode.simple4;

import java.util.Arrays;

/**
 * Êý×é²ð·Ö I
 * https://leetcode-cn.com/submissions/detail/4391127/
 */
public class Test124 {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) count+= nums[i];
        }
        
        return count;
    }
}
