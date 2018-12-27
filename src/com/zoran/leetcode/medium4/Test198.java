package com.zoran.leetcode.medium4;

/**
 * 预测赢家
 * https://leetcode-cn.com/submissions/detail/10925984/
 *
 * [Solution]
 * https://pamleft.github.io/2018/05/25/leetcode486%E9%A2%84%E6%B5%8B%E8%B5%A2%E5%AE%B6/
 * https://blog.csdn.net/OneDeveloper/article/details/79929819  reabse!
 *
 * dp[i][j]
 */
public class Test198 {


}

class Nice_Test198 {
    /**
     * 自己拿得最大值，同时对手也会这么拿，所以会出现 ：
     * nums - dp[i][j];
     */
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        dp[dp.length-1][dp.length-1] = nums[nums.length-1];
        //Core 这个遍历是中数组最后一个元素进行遍历的！
        for (int left = dp.length -2; left >= 0; left--) {
            for (int right = left; right<dp.length; right++) {
                if (left == right) {
                    dp[left][right] = nums[left];
                } else {
                    int pickLeft = nums[left] - dp[left+1][right];
                    int pickRight = nums[right] - dp[left][right-1];
                    dp[left][right] = Math.max(pickLeft, pickRight);
                }
            }
        }
        return dp[0][nums.length-1] >= 0;
    }
}
