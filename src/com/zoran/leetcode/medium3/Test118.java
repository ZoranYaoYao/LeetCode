package com.zoran.leetcode.medium3;

/**
 * 生命游戏
 * https://leetcode-cn.com/submissions/detail/8657113/
 * 
 * Nice_Core. 通过双循环 去计算周围8个点,包含自己点的活细胞
 *
 */
public class Test118 {
	public static void main(String[] args) {
		Test118 test118 =new Test118();
		int[][] nums = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		test118.gameOfLife(nums);
	}

	public void gameOfLife(int[][] board) {
		//用一个二维数组纪录下一状态, 然后改原数组对应的值
		int[][] res = new int[board.length][board[0].length];

		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				nextStatus(res, board, i, j);
			}
		}

		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				board[i][j] = res[i][j];
			}
		}
	}

	private void nextStatus(int[][] res, int[][] board, int row, int col) {
		if (board[row][col] == 0) {
			if (aliveCount(board, row, col) == 3) res[row][col] = 1;
		} else {
			int count = aliveCount(board, row, col);
			if (count ==2 || count ==3) res[row][col] =1;
			else res[row][col] =0;
		}
	}

	//Core.对于0 要取等号
	private int aliveCount(int[][] board, int row, int col) {
		System.out.println("============== row = " + row + ", col = " + col + " ==============");
		int count =0;
		if (row-1 >= 0 && board[row-1][col] == 1) {count++; System.out.println("row-1 , col");}
		if (row+1 < board.length && board[row+1][col] == 1) {count++; System.out.println("row+1 , col");}
		if (col-1 >= 0 && board[row][col-1] == 1) {count++; System.out.println("row , col-1");}
		if (col+1 < board[0].length && board[row][col+1] == 1) {count++; System.out.println("row , col+1");}

		if (row-1>=0 && col-1>=0 && board[row-1][col-1] == 1) {count++; System.out.println("row-1 , col-1");}
		if (row-1>=0 && col+1<board[0].length && board[row-1][col+1] == 1) {count++; System.out.println("row-1, col+1");}
		if (row+1<board.length && col-1>=0 && board[row+1][col-1] == 1) {count++; System.out.println("row+1 , col-1");}
		if (row+1<board.length && col+1<board[0].length && board[row+1][col+1] == 1) {count++; System.out.println("row+1 , col+1");}

		return count;
	}
}

class LeetCode_Test118 {
	//Nice_Core. 通过双循环 去计算周围8个点,包含自己点的活细胞
    public int livecell(int[][] board,int row,int column){//计算周围的活细胞数
        int count=0;
        for(int i=row-1;i<=row+1;i++){
            for(int j=column-1;j<=column+1;j++){
                if(i>=0&&i<board.length&&j>=0&&j<board[0].length&&board[i][j]==1)
                    count++;
            }
        }
        return count;
    }
}
