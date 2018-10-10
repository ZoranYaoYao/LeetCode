package com.zoran.leetcode.medium2;


/**
 * 岛屿的个数
 * https://leetcode-cn.com/submissions/detail/8062820/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_38595487/article/details/79486962
 * 
 *  改变原值法
 */
public class Test92 {

}


class Nice_Test92 {
	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int row = grid.length;
		int column = grid[0].length;
		int count = 0;
		for (int i=0; i<row; i++) {
			for (int j=0; j<column; j++) {
				if (grid[i][j] == '1') {
					count++;
					combine(grid, i, j);
				}
			}
		}
		
		return count;
	}

	private void combine(char[][] grid, int x, int y) {
		grid[x][y] = '2'; //Core. 改变原值, 不与后续遍历值冲突!!
		if (x>grid.length-1 && y>grid[0].length-1) return;
		
		if (x>0 && grid[x-1][y] == '1') combine(grid, x-1, y); //上
		if (y<grid[0].length-1 && grid[x][y+1] == '1') combine(grid, x, y+1); //下
		if (y>0 && grid[x][y-1] == '1') combine(grid, x, y-1); //左
		if (x<grid.length-1 && grid[x+1][y] == '1') combine(grid, x+1, y); //右
	}
}