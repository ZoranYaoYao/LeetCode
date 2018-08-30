package com.zoran.leetcode.medium;

import java.util.HashSet;

/**
 * ��Ч������
 * https://leetcode-cn.com/submissions/detail/6268367/
 * 
 * [Solution]
 * https://blog.csdn.net/mine_song/article/details/70207326
 */
public class Test19 {
	public boolean isValidSudoku(char[][] board) {
		for (int i=0; i<9; i++) {
			HashSet<Character> row = new HashSet<>();
			HashSet<Character> column = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			
			for(int j=0; j<9; j++) {
				//����i��, �ں�����λ��
				if (board[i][j] !='.' && !row.add(board[i][j])) return false;
				//����j��, ��������λ��
				if(board[j][i]!='.' && !column.add(board[j][i])) return false;
				//�к�+ƫ����
				int rowIndex = 3*(i/3) + j/3;
				//�к�+ƫ����
				int colIndex = 3*(i%3) + j%3;
				//ÿ��С�Ź���, �ܹ�9��
				if(board[rowIndex][colIndex]!='.' && !cube.add(board[rowIndex][colIndex])) return false;
			}
		}
		
		return true;
	}
}
