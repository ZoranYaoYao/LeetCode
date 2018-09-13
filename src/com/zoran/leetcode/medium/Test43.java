package com.zoran.leetcode.medium;

/**
 * 单词搜索
 * https://leetcode-cn.com/submissions/detail/7009045/
 * 
 * [Solution]
 * https://www.cnblogs.com/jimmycheng/p/7248179.html
 * 
 * 位置是否拜访作为回退标志, 4种方向进行递归
 */
public class Test43 {
	
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length ==0 
				|| board.length*board[0].length<word.length()) return false;
		
		boolean[][] mark = new boolean[board.length][board[0].length];
		boolean res = false;
		// iterate board, find the match starting character to pass to findWord funcion
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					res = res || findWord(board, word, 0, i, j, mark);
				}
				
				if (res) return true;
			}
		}
		
		return res;
	}

	private boolean findWord(char[][] board, String word, int wordIndex
								, int row, int col, boolean[][] markBoard) {
		// base case 1: if exceed word's length, meaning it is done and found the word
		if (wordIndex == word.length()) {
			return true;
		}
		
		/*
		 * base case 2: if this character is out of bound or 
		 * this character is not match to word's character or
		 * hits character has been already visited
		 */
		if (row >= board.length || row<0 || col >= board[0].length || col <0
				|| word.charAt(wordIndex) != board[row][col] || markBoard[row][col]) {
			return false;
		}
		
		// mark this char as visited
		markBoard[row][col] = true;     //(1) Core. 将该位置是否拜访作为回退标志
		
		// follow top, rigth, bottom, left order  to check character
		// if any direction future path return true, meaning no need to continue other directions
		if(findWord(board, word, wordIndex+1, row-1, col, markBoard) || //(2) Core. 遍历不在是对集合, 而是对4个方向的探索进行遍历
		   findWord(board, word, wordIndex+1, row, col+1, markBoard) ||
		   findWord(board, word, wordIndex+1, row+1, col, markBoard) ||
		   findWord(board, word, wordIndex+1, row, col-1, markBoard)) {
			return true;
		}
		
		// clear the mark of this character
		markBoard[row][col] = false;
		
		// if this character's all four directions path has failed, return false to last level
		return false;
			
	}
	
}






















