package com.zoran.leetcode.simple5;

/**
 * ÍĞÆÕÀû´Ä¾ØÕó
 * https://leetcode-cn.com/submissions/detail/5519816/
 */
public class Test176 {

	public static void main(String[] args) {
		Test176 test176 = new Test176();
		int[][] nums = {
				{1,2,3,4},
				{5,1,2,3},
				{9,5,1,2}
		};
		System.out.println(test176.isToeplitzMatrix(nums));
	}

	public boolean isToeplitzMatrix(int[][] matrix) {
		// matrix = [
	    //   [1,2,3,4],
		//   [5,1,2,3],
		//   [9,5,1,2]
		// ]  
		if (matrix == null || matrix.length == 0) return false;

		//±éÀúÓÒ²à
		for(int i=0; i< matrix[0].length; i++) {
			int temp = matrix[0][i];
			int row = 0; int column = i;
			for(int j=row+1,k=column+1; j < matrix.length; ) {
				if(j<matrix.length && k < matrix[0].length) {
					if(temp != matrix[j][k]) return false;
				}
				j++;
				k++;
			}
		}
		
		//±éÀúÏÂ·½
		for(int i=0; i<matrix.length; i++) {
			int tempCloumn = matrix[i][0];
			int row2 = i; int column2 = 0;
			for(int j=row2+1,k=column2+1; j< matrix.length; ) {
				if(j<matrix.length && k < matrix[0].length) {
					if (tempCloumn != matrix[j][k]) return false;
				}
				j++;
				k++;
			}
		}

		return true;
	}
}


