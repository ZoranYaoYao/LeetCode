package com.zoran.leetcode.simple6;

/**
 * 车的可用捕获量
 * https://leetcode-cn.com/submissions/detail/14542823/
 *
 * 对于方向步子，可以用循环对2个变量赋值
 */
public class Test242 {

    public int numRookCaptures(char[][] board) {
        //首先查找到R，再进行横向，竖向遍历
        int res = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'R') {
                    //Core，上下左右 步子距离
                    int[] x = {-1,1,0,0};
                    int[] y = {0,0,-1,1};

                    for(int i=0; i<x.length; i++) {
                        int tempX = row + x[i];
                        int tempY = col + y[i];
                        while (tempX>=0 && tempX < board.length && tempY>=0 && tempY<board.length) {
                            if (board[tempX][tempY] == 'B' || board[tempX][tempY] == 'P')
                                break;
                            if (board[tempX][tempY] == 'p') {
                                res++; break;
                            }
                            tempX += x[i];
                            tempY += y[i];
                        }
                    }
                }
            }
        }
        return res;
    }
}
