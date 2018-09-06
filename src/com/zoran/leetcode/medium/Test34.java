package com.zoran.leetcode.medium;

/**
 * 不同路径
 * https://leetcode-cn.com/submissions/detail/6628626/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_14821023/article/details/50759747
 * https://blog.csdn.net/u013115610/article/details/71354736
 *
 */
public class Test34 {
	public static void main(String[] args) {
		Test34 test34 = new Test34();
		int reuslt = test34.uniquePaths(3, 2);
		System.out.println(reuslt);
	}

    int count;

    public int uniquePaths(int m, int n) {
      //回溯: 结果值时到达 数组[n][m]位置 
      int[][] nums = new int[n][m];
      int[] curLoc = new int[2];
      backTrace(curLoc, n, m);
      
      return count;
    }
    
    public void backTrace(int[] curLoc, int row, int col) {
        if(curLoc[0] == row && curLoc[1] == col) {
            count++;
        } else {
            if(curLoc[0] > row || curLoc[1] > col) return;
            
            for(int i=curLoc[0]+1; i<=row; i++) { //全排列问题
                curLoc[0] = i;
                backTrace(curLoc, row, col);
                curLoc[0] = i-1;
                
                curLoc[1] = i;
                backTrace(curLoc, row, col); 
                curLoc[1] = i-1;
            }
        }
    }
}

class Nice_Test34 {
	public int uniquePaths(int m, int n) {
		int temp = m;
		m = n;
		n = temp;
        // m 代表行, n 代表列;
		int[][] path = new int[m][n];
		for (int i=0; i<n; i++) path[0][i] = 1; //第一行为1
		for (int i=0; i<m; i++) path[i][0] = 1; //第一列为1
		
		for (int i=1; i<n; i++) {
			for (int j=1; j<m; j++) {
				path[j][i] = path[j-1][i] + path[j][i-1];
			}
		} 
		return path[m-1][n-1];
	}
}
























