package com.zoran.leetcode.medium5;

/**
 * 最长回文子序列
 * https://leetcode-cn.com/submissions/detail/11164326/
 *
 * [Solution]
 * https://www.cnblogs.com/AndyJee/p/4465696.html
 *
 * 该题子序列可以不连续
 * dp[i][j]
 */
public class Test208 {

}

class Nice_Test208 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i=n-1; i>= 0; i--) { //Nice_Core 可以看出依赖从最后，到开始位置
            dp[i][i] = 1;
            for (int j=i+1; j<n; j++) {
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2; //Nice_core
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
            }
        }

        return dp[0][n-1];
    }
}