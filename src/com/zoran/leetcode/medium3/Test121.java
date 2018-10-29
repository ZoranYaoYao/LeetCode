package com.zoran.leetcode.medium3;

/**
 * 二维区域和检索 - 矩阵不可变
 * https://leetcode-cn.com/submissions/detail/8786354/
 * 
 * [Solution]
 * https://blog.csdn.net/zw159357/article/details/82463251
 *
 */
public class Test121 {

	//超时
	class NumMatrix {
		//封装
		int[][] matrix;

		public NumMatrix(int[][] matrix) {
			this.matrix = matrix;    
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for (int i=row1; i<=row2; i++) {
				for (int j=col1; j<=col2; j++) {
					sum += matrix[i][j];
				}
			}

			return sum;
		}
	}
}

class LeetCode_Test121 {
	class NumMatrix {
		private int[][] matrix;
		private int[][] sum;
		public NumMatrix(int[][] matrix) {
			this.matrix = matrix;
			this.sum = null;
			if (matrix==null || matrix.length==0) return;

			int m = matrix.length, n=matrix[0].length;
			sum = new int[m+1][n+1];
			for (int i=1; i<=m; i++) {
				for (int j=1; j<=n; j++) {
					sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + matrix[i-1][j-1];  //Core. +1的好处: 可以用于计算前一个sum值
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (sum == null) return 0;
			return sum[row2+1][col2+1] -sum[row1][col2+1] - sum[row2+1][col1] + sum[row1][col1]; //Core. 新增一行,一列, 在进行对应关系
		}
	}
}