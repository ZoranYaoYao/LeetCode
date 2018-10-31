package com.zoran.leetcode.medium3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 零钱兑换
 * https://leetcode-cn.com/submissions/detail/8870148/
 * 
 * [Solution]
 * http://www.cnblogs.com/MrSaver/p/9669668.html
 *
 *NNice: 动态规划变形
 */
public class Test129 {

	public static void main(String[] args) {
		Test129 test129 = new Test129();
		int[] coins = {186,419,83,408};
		int res = test129.coinChange(coins, 6249);
				System.out.println(res);
	}

	//回溯逻辑不对
	public int coinChange(int[] coins, int amount) {
		//回溯
		Arrays.sort(coins);
		for (int i=0; i<coins.length/2; i++) {
			int temp = coins[i];
			coins[i] = coins[coins.length-1-i];
			coins[coins.length-1-i] = temp;
		}
		
		int[] count = new int[coins.length];
		
		backTrace(coins, count, amount, 0);
		for (int i = 0; i>=coins.length; i++) {
			while (count[i]>0) {
				amount += coins[i];
				count[i]--;
				System.out.println(Arrays.toString(count));
				boolean flag = backTrace(coins, count, amount, i+1);
				if (flag) break;
			}
		}
		
		int sum =0;
		int res = 0;
		for (int i=0; i<coins.length; i++) {
			sum += coins[i]*count[i];
			res += count[i];
		}
		
		return sum == amount ? res : -1;
	}

	private boolean backTrace(int[] coins, int[] count, int amount, int coinsIndex) {
		if (amount == 0) return true;
		if (coinsIndex >= coins.length) return false;
		
		while(amount-coins[coinsIndex] > 0) {
			 amount -= coins[coinsIndex];
			 count[coinsIndex]++;
		}
		backTrace(coins, count, amount, coinsIndex+1);
		return false;
	}
}

class Nice_Test129 {
	public int coinChange(int[] coins, int amount) {
		if (amount == 0 || coins.length <= 0) return 0;
		int[] dp = new int[amount+1];
		Arrays.fill(dp, amount+1);
		Arrays.sort(coins);
		for (int i=1; i<=amount; i++) {
			for (int j=0; j<coins.length; j++) {
				if (i-coins[j] == 0) 
					dp[i] = 1;
				else if (i -coins[j] > 0) {
					dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
				} 
					
			}
		}
		
		return dp[amount] > amount ? -1 : dp[amount];
	}
}



















