package com.zoran.leetcode.medium6;

/**
 * 划分为k个相等的子集
 * https://leetcode-cn.com/submissions/detail/12649882/
 *
 * [Solution]
 * https://blog.csdn.net/zw159357/article/details/82805282
 *
 * 难点元素如何正确放在对应的子集中？
 * 通过回溯暴力分配可能的情况
 */
public class Test264 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        //难点元素如何正确放在对应的子集中？
        return false;
    }
}

class Nice_Test264 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
        }
        boolean[] v = new boolean[n];
        if (sum % k != 0) return false;
        return dfs(nums, k, sum/k, 0, 0, v);
    }

    private boolean dfs(int[] nums, int k, int target, int sum, int s, boolean[] v) {
        if (k == 1) return true; //Nice. 当只剩下最后一个子集的时候
        if (target<0) return false;
        if (target == sum) return dfs(nums, k-1, target, 0, 0, v);

        for (int i=s; i<nums.length; i++) {
            if (v[i]) continue;
            v[i] = true;
            if (dfs(nums, k, target, sum+nums[i], i+1, v)) return true;
            v[i] = false;
        }
        return false;
    }
}