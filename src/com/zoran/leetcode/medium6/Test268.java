package com.zoran.leetcode.medium6;

/**
 * 买卖股票的最佳时机含手续费
 * https://leetcode-cn.com/submissions/detail/12699416/
 *
 * [Solution]
 * https://blog.csdn.net/Viscu/article/details/82352743
 *
 * dp[0] dp[1] 的意义！！
 */
public class Test268 {

}

class Nice_Test268 {
   public int maxProfit(int[] prices, int fee) {
       if (prices.length == 0) return 0;
       int[] dp = new int[2];
       dp[1] = -prices[0];
       for (int i=0; i<prices.length; i++) {
           //Nice, dp[0] 表示没有股票时，手上的收益
           dp[0] = Math.max(dp[0], dp[1]+prices[i]-fee);
           //Nice, dp[1] 表示有股票时，手上的收益
           dp[1] = Math.max(dp[1], dp[0]-prices[i]);
       }
       return Math.max(dp[0],dp[1]);
   }
}
