package com.zoran.leetcode.simple6;

/**
 * ��ά����ı����
 * https://leetcode-cn.com/submissions/detail/13070179/
 */
public class Test213 {

    public static void main(String[] args) {
        Test213 test213 = new Test213();
        int[][] a = {{1,0},{0,2}};
        int res = test213.surfaceArea(a);
        System.out.println(res);
    }

    public int surfaceArea(int[][] grid) {
        //�ݹ����ÿ���������Ӵ���� �� ����� - �Ӵ����
        int res = 0;
        for (int row=0; row<grid.length; row++) {
            for (int col=0; col<grid[0].length; col++) {
                //���㵥Ԫ����������
                int cur = grid[row][col];
                if (cur == 0) continue;

                res +=  cur*6 - 2*(cur -1);
                //��
                if (row>0) {
                    int up = grid[row-1][col];
                    res -= cur>up? up : cur;
                }
                //��
                if (row<grid.length-1) {
                    int down = grid[row+1][col];
                    res -= cur>down?down : cur;
                }
                //��
                if (col>0) {
                    int left = grid[row][col-1];
                    res -= cur>left ? left : cur;
                }
                //��
                if (col<grid[0].length-1) {
                    int right = grid[row][col+1];
                    res -= cur>right ? right : cur;
                }
            }
        }

        return res;
    }
}

class LeetCode_Test213 {
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] != 0)
                    res += grid[i][j]*4 + 2;
                if (i>0)
                    //Nice_Core ȥ��������ظ���
                    res -= Math.min(grid[i-1][j], grid[i][j])*2;
                if (j>0)
                    //Nice_Core ȥ�������ظ��棬�ݹ�2������������ȥ���������ظ��棡��
                    res -= Math.min(grid[i][j-1], grid[i][j])*2;
            }
        }
        return res;
    }
}
