package com.zoran.leetcode.simple4;

/**
 * 图片平滑器
 * https://leetcode-cn.com/submissions/detail/4929341/
 * 
 * [Solution]
 * https://www.cnblogs.com/jimmycheng/p/7697511.html
 */
public class Test146 {
	
	public int[][] Nice_imageSmoother(int[][] M) {
		int rows = M.length;
		int cols = M[0].length;
		int[][] res = new int[rows][cols];
		
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				int sum =0;
				int count =0;
				for (int x =Math.max(0, i-1); x<=Math.min(rows-1, i+1); x++) { //Nice: 用Math.min Math.max处理边界值问题
					for (int y=Math.max(0, j-1); y<=Math.min(cols-1, j+1); y++) {
						sum += M[x][y];
						count++;
					}
				}
				res[i][j] = sum / count;
			}
		}
		
		return res;
	}

}
