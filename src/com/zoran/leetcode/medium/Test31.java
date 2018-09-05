package com.zoran.leetcode.medium;

/**
 *  螺旋矩阵 II
 * https://leetcode-cn.com/submissions/detail/6571104/
 * 
 * [Solution]
 * https://www.cnblogs.com/jimmycheng/p/7215630.html
 */
public class Test31 {

}

/**
 * 边界值定义好 
 */
class Nice_Test31 {
	
	public static void main(String[] args) {
		Nice_Test31 test31 = new Nice_Test31();
		test31.generateMatrix(3);
	}
	
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int total = n*n;
		int num =1;
		
		int rowBegin = 0; int rowEnd = n-1;
		int colBegin = 0; int colEnd = n-1;
		
		while (num <= total) {
			//traverse right (y changes)
			for(int y=colBegin; y<=colEnd; y++) {
				res[rowBegin][y] = num++;
			}
			rowBegin++;
			
			//traverse down (x changes)
			for (int x=rowBegin; x<=rowEnd; x++) {
				res[x][colEnd] = num++;
			}
			colEnd--;
			
			//traverse left (y changes)
			for (int y=colEnd; y>=colBegin; y--) {
				res[rowEnd][y] = num++;
			}
			rowEnd--;
			
			//traverse up (x changes)
			for(int x=rowEnd; x>=rowBegin; x--) {
				res[x][colBegin] = num++;
			}
			colBegin++; //move right one column;
		}
		
		return res;
	}
}
