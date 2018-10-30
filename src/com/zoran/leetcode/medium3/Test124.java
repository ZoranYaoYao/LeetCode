package com.zoran.leetcode.medium3;

/**
 * 最佳买卖股票时机含冷冻期
 * https://leetcode-cn.com/submissions/detail/8825215/
 * 
 * [Solution]
 * https://blog.csdn.net/wv1dfw38/article/details/82954210
 */
public class Test124 {

//    public int maxProfit(int[] prices) {
//        //动态规划, 如何判断冻结期?
//        //dp[i] = dp[i-1] || dp[i-2]
//    }
}

//分状态
class Nice_Test124 {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1) return 0;
		if (prices.length == 2) return prices[1] > prices[0] ? prices[1] -prices[0] : 0;
		
		int n = prices.length;
		int[] dp1 = new int[n]; 
		int[] dp2 = new int[n];
		dp1[0] = 0;
		dp2[0] = -prices[0]; dp2[1] = prices[1]>prices[0] ? -prices[0] : -prices[1];
		
		for (int i=1; i<prices.length; i++) {
			dp1[i] = Math.max(dp1[i-1], dp2[i-1] + prices[i]);
			int temp =0;
			if (i >= 2) temp = dp1[i-2];
			dp2[i] = Math.max(dp2[i-1], temp-prices[i]);
		}
		
		return Math.max(dp1[n-1], dp2[n-1]);
	}
}
