package com.zoran.leetcode.medium3;

/**
 * 组合总和 Ⅳ
 * https://leetcode-cn.com/submissions/detail/9637052/
 *
 * OT
 */
public class Test148 {

    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        Test148 test148 = new Test148();
        int res = test148.combinationSum4(num, 32);
        System.out.println(res);
    }


    /**
     * 超时 target = 32
     */
    int count;
    public int combinationSum4(int[] nums, int target) {
        //回溯 遍历
        backTrace(nums, target, 0);
        return count;
    }

    private void backTrace(int[] nums, int target, int curTotal) {
        if (curTotal == target) {
            count++;
            return;
        } else if (curTotal > target) {
            return;
        }  else {
            for (int i = 0; i<nums.length; i++) {
                curTotal += nums[i];
                backTrace(nums, target, curTotal);
                curTotal -= nums[i];
            }
        }

    }
}

// dp[target] = dp[target-nums[0]] + dp[target-nums[1]] + ...
class zqs_Test148 {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        zqs_Test148 test148 = new zqs_Test148();
        int res = test148.combinationSum4(num, 32);
        System.out.println(res);
    }

    public int combinationSum4(int[] nums, int target) {
        int res = 0;
        int[] dp = new int[target+1];
        dp[0] = 1; //Core. dp[0]表示包含当前对象
        for (int i = 1; i<=target; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i-nums[j]>=0) {
                    dp[i] += dp[i-nums[j]];
                }

            }
//            System.out.println(dp[i]);
        }
        return dp[target];
    }
}

























