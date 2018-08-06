package com.zoran.leetcode.simple5;

/**
 * 岛屿的最大面积
 * https://leetcode-cn.com/submissions/detail/5165837/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80204849
 * 
 * 每个点的个数,都依赖旁边的点值,产生递归
 */
public class Test157 {

	public int maxAreaOfIsland(int[][] grid) {
		int max =0;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				int nums = deepSearch(grid, i, j);
				max = Math.max(nums, max);
			}
		}
		return max;
	}

	private int deepSearch(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1) {
			grid[i][j] =0; //Core. 算过一次,就覆盖为0, 不然左右递归导致.死循环
			int num = 1 + deepSearch(grid, i-1, j)
			+ deepSearch(grid, i+1, j)+deepSearch(grid, i, j-1)+deepSearch(grid, i, j+1);
			return num;
		} else 
		return 0;
	}
}
