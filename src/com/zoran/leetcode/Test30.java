package com.zoran.leetcode;

/**
 * 买卖股票的最佳时机 II
 * https://leetcode-cn.com/submissions/detail/2898441/
 */
public class Test30 {
	//	输入: [7,1,5,3,6,4]
	//	输出: 7
	//	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
	//	随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
	//	示例 2:
	//	输入: [1,2,3,4,5]
	//	输出: 4
	//	解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
	//	注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
	//	因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
	//	示例 3:
	//	输入: [7,6,4,3,1]
	//	输出: 0
	//	解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

	public static void main(String[] args) {
		//int[] prices = new int[] {7,1,5,3,6,4};
		int[] prices = new int[] {1,2,3,4,5};
		System.out.println(Nice_maxProfit(prices));
	}

	/**
	 *  算法: 
	 *  1. 如果后一位大于前一位, 则直接调到下一位进行计算
	 *  2. 如果前一位大于后一位, 则计算前面的利润
	 *  
	 */
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length ==0) return 0;

		int profit = 0;int startIndex = 0;int endIndex = 0;
		for (int i = 0; i < prices.length; i++) {
			if(i == prices.length - 1) {
				if (prices[startIndex] < prices[i]) profit += prices[i] - prices[startIndex];
				continue;
			}

			if(prices[i] < prices[i+1]) {
				endIndex = i;
			} else if (prices[i] > prices[i+1]) {
				//计算上一笔
				endIndex = i;
				profit += prices[endIndex] - prices[startIndex];
				startIndex = endIndex + 1;
			}
		}

		return profit;
	}

	/**
	 *  注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
	 *  core: 卖出之后, 立马买一只股票
	 */
	public static int Nice_maxProfit(int[] prices) {
		int totalSum = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i] > prices[i-1]){  //因为数字是排序的, 如果值是递增的,2个数的利润总和就是(后一个数 - 前一个数)
				totalSum += prices[i] - prices[i-1];
			}
		}

		return totalSum;
	}
}
