package com.zoran.leetcode.simple5;

/**
 * 矩阵中的幻方
 * https://leetcode-cn.com/submissions/detail/5715389/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_37976559/article/details/81383334
 */
public class Test192 {
	public int numMagicSquaresInside(int[][] grid) {
		int ans=0;
		for(int i=0;i<grid.length-2;i++)
		{
			for(int j=0;j<grid[0].length-2;j++)
			{   ans++;
			int sum=grid[i][j]+grid[i+1][j]+grid[i+2][j];
			if(grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1]!=sum||grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2]!=sum||
					grid[i][j]+grid[i][j+1]+grid[i][j+2]!=sum||grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]!=sum||
					grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2]!=sum||grid[i+1][j+1]+grid[i][j]+grid[i+2][j+2]!=sum
					)
			{
				ans--;
				continue;
			}
			int [] temp=new int [100];       //此处测试是否是1-9的幻阵		
			{
				temp[grid[i][j]]=1;
				temp[grid[i+1][j]]=1;
				temp[grid[i+2][j]]=1;
				temp[grid[i][j+1]]=1;
				temp[grid[i+1][j+1]]=1;
				temp[grid[i+2][j+1]]=1;
				temp[grid[i][j+2]]=1;
				temp[grid[i+1][j+2]]=1;
				temp[grid[i+2][j+2]]=1;       			       			
			}
			for(int k=1;k<=9;k++)
			{
				if(temp[k]!=1)
				{
					ans--;
					break;
				}
			}


			}
		}
		return ans;
	}
}
