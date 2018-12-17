package com.zoran.leetcode.medium4;

/**
 * 甲板上的战舰
 * https://leetcode-cn.com/submissions/detail/10541611/
 */
public class Test171 {

    public int countBattleships(char[][] board) {
        //遍历， 标记
        int res = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for(int j=0; j<board.length; j++) {
                if(!visited[i][j] && board[i][j] == 'X') {
                    visited[i][j] = true;
                    res++;
                    iterator(i, j, board, visited);
                }
            }
        }

        return res;
    }

    public void iterator(int i, int j, char[][] board, boolean[][] visited) {
        //向下遍历
        if (i+1 < board.length && !visited[i+1][j] && board[i+1][j] == 'X') {
            iterator(i+1, j, board, visited);
        } else if (j+1 < board[0].length && !visited[i][j+1] && board[i][j+1] == 'X') {
            iterator(i, j+1, board, visited);
        }
    }
}
