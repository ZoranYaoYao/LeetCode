package com.zoran.leetcode.medium2;

/**
 * 被围绕的区域
 * https://leetcode-cn.com/submissions/detail/7528960/
 * 
 * [Solution]
 * https://blog.csdn.net/whdAlive/article/details/80467536
 * 
 * 递归找相邻是否满足 "被围绕的条件"
 */
public class Test69 {

}

class Nice_Test69 {
	//遍历四周, 将所有与"O"都标记出来, 然后对整个矩阵未被标胶的元素赋值为"X"
	public void solve(char[][] board) {
		if (board==null || board.length<=1 || board[0].length<=1) return; //Core, 过滤单行,单列情况
		
		for (int i=0; i<board.length; i++) {
			if (board[i][0] == 'O') dfs(board, i, 0);
			if (board[i][board[0].length-1] == 'O') dfs(board, i, board[0].length-1);
		}
		
		for (int j=0; j<board[0].length; j++) {
			if (board[0][j] == 'O') dfs(board, 0, j);
			if (board[board.length-1][j] == 'O') dfs(board, board.length-1, j);
		}
		
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[i][j] == '+') board[i][j] = 'O';
				else if (board[i][j] == 'O') board[i][j] = 'X';
			}
		}
		
	}

	//深度优先
	private void dfs(char[][] board, int row, int col) {
		if (row<0 || row>=board.length || col<0 || col>= board[0].length) return; //Core. 处理矩阵边界
		
		if (board[row][col] != 'O') return;
		board[row][col] = '+';
		dfs(board, row+1, col);
		dfs(board, row, col+1);
		dfs(board, row-1, col);
		dfs(board, row, col-1);
	}
}