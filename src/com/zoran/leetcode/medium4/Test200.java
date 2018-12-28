package com.zoran.leetcode.medium4;

/**
 * 目标和
 * https://leetcode-cn.com/submissions/detail/10973505/
 *
 * 回溯，dps深度优先算法
 *
 * 真正的OT
 */
public class Test200 {
    int res;
    public int findTargetSumWays(int[] nums, int S) {
        //数前面要么是正，要么是负
        //回溯算法
        backTrace(nums, S, 0, 0);
        return res;
    }

    public void backTrace(int[] nums, int S, int start, int curCount) {
        if (start == nums.length) {
            if (curCount == S) res++;
            return ;
        }

        for (int i=start; i<start+1; i++) {
            curCount += nums[i];
            backTrace(nums, S, i+1, curCount);

            curCount -= nums[i]*2;
            backTrace(nums, S, i+1, curCount);
        }
    }
}
