package com.zoran.leetcode.medium2;

/**
 * 最大正方形
 * https://leetcode-cn.com/submissions/detail/8437651/
 */
public class Test100 {

	public static void main(String[] args) {
		char[][] chars = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
		Test100 test100 = new Test100();
		int res = test100.maximalSquare(chars);
		System.out.println(res);
		
	}

	public int maximalSquare(char[][] matrix) {
		//穷举, 纪录每个位置左上点宽高
		//矩形: 从2开始无限扩大到边界!
		if (matrix == null || matrix.length ==0) return 0;

		int max = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] == '0') continue;
				System.out.println("i=" + i + ",j=" + j + " ,  " + iterator(matrix, i, j));
				max = Math.max(max, iterator(matrix, i, j));
			}
		}

		return max*max;
	}

	private int iterator(char[][] matrix,int i, int j) {
		int maxWidth = matrix[0].length - j;
		
		for(int k=2; k<=maxWidth; k++) {
			if(!fill(matrix, i, j, k)) return k-1;
		}
		
		return maxWidth;
	}
	
	private boolean fill(char[][] matrix, int i, int j, int width) {
		
		for(int m =i; m<i+width;m++) {   //Core. 位置索引值
			for(int n=j; n<j+width; n++) {
				if(m >= matrix.length || n > matrix[0].length || matrix[m][n] == '0') return false; //边界问题
			}
		}
		
		return true;
	}
	
	//算法有问题: 不应该层级遍历
	//		char[][] chars = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
	private int iterator_Old(char[][] matrix,int i, int j) {
		int width = Integer.MAX_VALUE;
		int height =Integer.MAX_VALUE;
		//矩形思想
		for(int m=i; m<matrix.length; m++){
			int temp = 1;
			for(int n=j+1; n<matrix[0].length; n++) {
				if(matrix[m][n] != '0') {
					temp++;
				} else break;
			}
			width = Math.min(width, temp);
		}

		//列遍历
		for(int m=j; m<width; m++){  //注意遍历的是j, 列必须小于width!
			int temp = 1;
			for(int n=i+1; n<matrix.length; n++) {
				if (matrix[n][m] != '0') {
					temp++;
				} else break;
			}
			height = Math.min(height, temp);
		}

		return Math.min(width, height);
	}

}
