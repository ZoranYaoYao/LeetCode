package com.zoran.leetcode.medium;

/**
 * ËÑË÷¶şÎ¬¾ØÕó
 * https://leetcode-cn.com/submissions/detail/6883442/
 */
public class Test39 {

	public static void main(String[] args) {
		Test39 test39 = new Test39();
		int[][] nums =  {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		boolean result = test39.searchMatrix(nums, 3);
		System.out.println(result);
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		//¶şÎ¬Êı×é,ÕÛ°ë²éÕÒ
		if(matrix == null || matrix.length == 0) return false;

		int row=matrix.length; int col = matrix[0].length;
		int left = 0; int right = row*col-1;

		while(left<= right) {
			int mid = (left + right)/2;
			int tempRow = mid / col;
			int tempCol = mid % col;
			int midNum = matrix[tempRow][tempCol];  
			if(midNum== target) return true;
			else if(midNum < target) {
				left = mid +1;
			} else {
				right = mid-1;
			}
		}

		return false;
	}
}
