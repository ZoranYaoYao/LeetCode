package com.zoran.leetcode.simple6;

/**
 * ���Ŀ��ò�����
 * https://leetcode-cn.com/submissions/detail/14542823/
 *
 * ���ڷ����ӣ�������ѭ����2��������ֵ
 */
public class Test242 {

    public int numRookCaptures(char[][] board) {
        //���Ȳ��ҵ�R���ٽ��к����������
        int res = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 'R') {
                    //Core���������� ���Ӿ���
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
