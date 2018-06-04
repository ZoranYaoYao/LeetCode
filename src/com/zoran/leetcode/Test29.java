package com.zoran.leetcode;

import java.util.HashMap;
import java.util.Map;

import sun.tools.jar.resources.jar;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/submissions/detail/2878623/
 */
public class Test29 {


	//	输入: [7,1,5,3,6,4]
	//	输出: 5
	//	解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
	//	注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。\

	public static void main(String[] args) {
		//int[] prices = new int[] {7,1,5,3,6,4};
		//int[] prices = new int[] {7,6,4,3,1};
		//int[] prices = new int[] {2,4,1};
		int[] prices = new int[] {2,4,1,2};
		System.out.println(Nice_maxProfit(prices));
	}

	//问题: 最大利润不一定是 从最小值 开始的
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length ==0) return 0;

		int minPrice =prices[0]; int maxPrice = prices[0];
		int minIndex = 0;int maxIndex = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] > maxPrice) {
				maxPrice = prices[i];
				maxIndex = i;
			} else if (prices[i] < minPrice) {
				minPrice = prices[i];
				minIndex = i;
			}
		}

		if(minIndex < maxIndex) {
			return maxPrice - minPrice;
		} else if(minIndex == maxIndex) {
			return 0;
		} else if (minIndex > maxIndex) {
			int tmp = minPrice;
			for(int j = minIndex; j < prices.length; j++) {
				if(prices[j] > tmp) {
					maxPrice = prices[j];
					maxIndex = j;
					tmp = maxPrice;
				}
			}

			if (maxIndex > minIndex) return maxPrice - minPrice;
		}

		return 0;
	}

	// 穷举法 找到2个点最小的值
	public static int maxProfit_2(int[] prices) {
		if (prices == null || prices.length ==0) return 0;

		int max = 0;

		for(int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				int tmp = prices[j] - prices[i];
				if( tmp > max) {
					max = tmp;
				}
			}
		}
		
		return max;
	}
	
	//	case:	int[] prices = new int[] {2,4,1,2};  //最小值,不一定会产生最大收益
	/**
	 * nice地方: 最小值的替换地方, 如果后面有更小的值, 那么最小值必定被替换
	 * 			  因为产生的最大利益 就是 后面的最大值,前去前面的最小值!
	 */
    public static int Nice_maxProfit(int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int min = prices[0];
        int profit = 0;
        for(int i = 0;i<prices.length;i++){
            if(prices[i]<min){
                min = prices[i];
            }else{
                if(profit<prices[i]-min){
                    profit = prices[i]-min; // 截取到当前节点, 与收益进行对比, 如果大于,则更改
                }
            }
        }
        return profit;
    }
}
