package com.zoran.leetcode.medium3;


/**
 * 猜数字大小 II
 * https://leetcode-cn.com/submissions/detail/9552052/
 * 
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/79874949?utm_source=blogxgwz1
 * https://www.cnblogs.com/grandyang/p/5677550.html
 * 
 * niubi的算法
 */
public class Test146 {
}

class Nice_Test146 {
	
	public int getMoneyAmount(int n) {
		int[][] table = new int[n+1][n+1];
		
		for (int j=2; j<=n; j++) {
			for (int i=j-1;i>=0; i--) {
				int globalMin = Integer.MAX_VALUE;
				for (int k=i+1; k<j; k++) {
					int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
					globalMin = Math.min(globalMin, localMax);
				}
				table[i][j] = i+1 ==j ? i : globalMin; //Core. 边界问题，区分2个数的时候
			}
		}
		return table[1][n];
		
	}
}











