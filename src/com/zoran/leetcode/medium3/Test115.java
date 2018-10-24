package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * 完全平方数
 * https://leetcode-cn.com/submissions/detail/8618243/
 * 
 * [Solution]
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51584790
 *
 * 动态规划:
 * dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
 * 
 * 优化动态规划: 找规律可得, 最小个数, 一个是以个 (平方数 + 一个剩余值)!!
 * 	dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
 */
public class Test115 {

}

class Nice_Test115 {
	public int numSquares(int n) {
		int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
		dp[1] = 1;
		for (int i=1; i<=n; i++) {
			int sqr = (int) Math.sqrt(i);
			if (sqr*sqr == i) dp[i] = 1;
			else {
				for (int j=1; j<=i/2; j++) { //Core. 一半之后, 又是重复2个数相加+
					dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
				}
			}
		}
		
		return dp[n];
	}
}

class NNice_Test115 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i * i <= n; i++) 
            dp[i * i] = 1;
        for(int i = 1; i <= n; i++) {  //选定第一个数为 i
            for(int j = 1; i + j * j <= n; j++) {  //选定另一个数为 j*j  NNice_Core. 一定是以个平方数 + 剩余值
                dp[i + j * j] = Math.min(dp[i] + 1, dp[i + j * j]);  //从小到大查找
            }
        }
        return dp[n];
    }
}