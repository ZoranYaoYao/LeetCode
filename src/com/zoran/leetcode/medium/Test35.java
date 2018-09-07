package com.zoran.leetcode.medium;

/**
 * 不同路径 II
 * https://leetcode-cn.com/submissions/detail/6687810/
 * 
 * LeetCode抽风, 本来就是是正确的
 */
public class Test35 {
	
	public static void main(String[] args) {
		Test35 test35 = new Test35();
		int[][] nums = {
				{0,0},
				{1,0}
		};
		int result = test35.uniquePathsWithObstacles(nums);
		System.out.println(result);
	}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //动态规划, 每个位置代表的解决方案
        int[][] result = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        boolean block = false;
        for(int i=0; i<obstacleGrid.length; i++) { //第一列
            if(obstacleGrid[i][0] == 0 && !block) {
                result[i][0] = 1;
            } else {
                result[i][0] = 0;
                block = true;
            }
        }
        
        boolean colblock = false;
        for(int i=0; i<obstacleGrid[0].length; i++) { //第一行
            if(obstacleGrid[0][i] == 0 && !colblock) {
                result[0][i] = 1;
            } else {
                result[0][i] = 0;
                colblock = true;
            }
        }
        
        for(int i=1; i<obstacleGrid.length; i++) {
            for(int j=1; j<obstacleGrid[0].length; j++) { //列
                if(obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = result[i][j-1] + result[i-1][j];
                }

            }
        }
        
        return result[obstacleGrid.length-1][obstacleGrid[0].length-1];
        
    }
}

class LeetCode_Test35 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int j = 1; j<n; j++){
            if(obstacleGrid[0][j]==1) dp[0][j]=0;
            else dp[0][j]=dp[0][j-1];  //Core. 依赖左侧总数 + 上侧总数
        }
        for(int i = 1; i<m; i++){
            if(obstacleGrid[i][0]==1) dp[i][0]=0;
            else dp[i][0]=dp[i-1][0]; //Core. 依赖左侧总数 + 上侧总数
        }
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j]==1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];                            
            }
        }
        return dp[m-1][n-1];
    }
}
