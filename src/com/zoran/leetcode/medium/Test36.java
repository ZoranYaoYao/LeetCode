package com.zoran.leetcode.medium;

/**
 * 最小路径和
 * https://leetcode-cn.com/submissions/detail/6730792/
 */
public class Test36 {
	
	public static void main(String[] args) {
		Test36 test36 = new Test36();
		int[][] nums = {
				  {1,3,1},
				  {1,5,1},
				  {4,2,1}
		};
		test36.minPathSum(nums);
	}

    public int minPathSum(int[][] grid) {
        //动态规划 , 依赖左侧, 上侧最小值
        if(grid == null || grid.length == 0) return 0;
        
        int row = grid.length; int col = grid[0].length;
        int[][] res = new int[row][col];
        
        res[0][0] = grid[0][0];
        for (int i=1; i<row; i++) {
            res[i][0] = grid[i][0] + res[i-1][0];
        }
        for (int j=1; j<col; j++) {
            res[0][j] = grid[0][j] + res[0][j-1];
        }
        
        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                res[i][j] = grid[i][j] + Math.min(res[i-1][j], res[i][j-1]);
            }
        }
        
        return res[row-1][col-1];
    }
}
