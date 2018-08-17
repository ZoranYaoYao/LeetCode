package com.zoran.leetcode.simple5;

/**
 * 翻转图像
 * https://leetcode-cn.com/submissions/detail/5676694/
 */
public class Test190 {

	public int[][] flipAndInvertImage(int[][] A) {
		for(int i=0; i<A.length; i++) {
			int cloumnIndex = A[i].length-1;
			for(int j=0; j<A[i].length/2; j++) { //索引值一半的处理
				int temp = A[i][j];
				A[i][j] = A[i][cloumnIndex-j];
				A[i][cloumnIndex-j] = temp;
			}

			for(int j=0; j<A[i].length; j++) {
				A[i][j] = A[i][j] == 0 ? 1 : 0;
			}
		}

		return A;
	}
}
