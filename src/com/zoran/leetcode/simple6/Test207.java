package com.zoran.leetcode.simple6;

/**
 * 斐波那契数
 * https://leetcode-cn.com/submissions/detail/12254286/
 */
public class Test207 {

    public int fib(int N) {
        //动态规划实现 dp[n] = dp[n-1] + dp[n-2];
        if (N == 0) return 0;

        int[] dp = new int[N+1];
        dp[1] = 1; dp[0] = 0;
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }
}
