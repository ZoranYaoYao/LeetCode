package com.zoran.leetcode.simple4;

/**
 * ÷ÿÀ‹æÿ’Û
 * https://leetcode-cn.com/submissions/detail/4409600/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_33736809/article/details/79288135
 */
public class Test126 {

	public int[][] Nice_matrixReshape(int[][] nums, int r, int c) {
		int original_r = nums.length;
		int original_c = nums[0].length;
		if (original_r * original_c == r*c) {
			int[][] result = new int[r][c];
			for (int i =0; i < r*c;i++) {
				result[i/c][i%c] = nums[i/original_c][i%original_c]; //Nice_Core.
			}
			
			return result;
		} else {
			return nums;
		}
	}
}
