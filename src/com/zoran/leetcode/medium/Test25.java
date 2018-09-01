package com.zoran.leetcode.medium;

/**
 * 旋转图像
 * https://leetcode-cn.com/submissions/detail/6369473/
 * 
 * [Solution]
 * https://www.cnblogs.com/Xieyang-blog/p/9015493.html
 * 
 * 对数组旋转操作 就是找规律 变化值
 */
public class Test25 {

	public static void main(String[] args) {
		Test25 test25 = new Test25();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		test25.rotate(matrix);

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(""+ matrix[i][j]+",");
				if(j==matrix[0].length-1) System.out.println();
			}
		}
	}

	/**
	 * 调用方法中去改变形参的引用地址 是不会改变实参的引用地址的 
	 */
	public void rotate(int[][] matrix) {
		int[][] rotateMatrix = new int[matrix.length][matrix[0].length];
		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				rotateMatrix[j][matrix[0].length-1 - i] = matrix[i][j];
			}
		}

		matrix =  rotateMatrix;
	}
}

class Nice_Test25 {
	public void rotate(int[][] matrix) {
		int n= matrix.length;
		if (n<=1) return;
		
		int x = (n-1)/2;
		for (int i=0; i<=x; i++) {  //Core.交换行
			int[] temp = matrix[i];
			matrix[i] =  matrix[n-1-i];
			matrix[n-1-i] = temp;
		}
		
		for (int i=0; i< n; i++) { //沿着对角线对折交换
			for(int j=i+1; j<n; j++) { //Core. j=i+1, 表示每行的对角线之后的数据进行翻转
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}