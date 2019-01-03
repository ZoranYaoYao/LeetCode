package com.zoran.leetcode.medium5;

/**
 * 下一个更大元素 II
 * https://leetcode-cn.com/submissions/detail/11158748/
 *
 * 真正First Submit
 * 对循环数组结构的认识
 */
public class Test204 {

    public int[] nextGreaterElements(int[] nums) {
        //循环数组
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) return res;

        for(int i=0; i<nums.length; i++) {
            boolean find = false;
            for (int j=i+1; j<nums.length+i; j++) {
                int index = j % nums.length;
                if (nums[index] > nums[i]) {
                    res[i] = nums[index];
                    find =true;
                    break;
                }
            }
            if (!find) res[i] = -1;
        }

        return res;
    }
}
