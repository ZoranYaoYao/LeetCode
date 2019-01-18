package com.zoran.leetcode.medium5;

import java.util.Arrays;

/**
 * 01 ����
 * https://leetcode-cn.com/submissions/detail/11781170/
 *
 * [Solution]
 * https://www.jianshu.com/p/f97dc9adbd53
 *
 * �㷨��ȷ���ǳ�ʱ
 */
public class Test222 {

    public static void main(String[] args) {
        Test222 test222 = new Test222();
        int[][] nums = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] res = test222.updateMatrix(nums);
        for (int i=0; i<res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }

    }

    /**
     * ��ʱ��
     * �㷨��ȷ���ǳ�ʱ��
     */
    int curMin = Integer.MAX_VALUE;
    public int[][] updateMatrix(int[][] matrix) {
        //��ٱ���+�滻���ֵ
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] res = new int[row][col];
        boolean[][] marked = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int value = findmin(matrix, marked, i, j, 0);
                res[i][j] = value;
                curMin = Integer.MAX_VALUE;
            }
        }
        return res;
    }

    //�������Ҷ���1�Ļ���������ѭ��
    private int findmin(int[][] matrix, boolean[][] marked, int i, int j, int cur) {
        if (i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1) return Integer.MAX_VALUE;
        if (cur > curMin ) return cur;

        if (matrix[i][j] == 0) return cur;
        int res = Integer.MAX_VALUE;
        int temp = Integer.MAX_VALUE;
        if (matrix[i][j] == 1 && !marked[i][j]) {
            marked[i][j] = true;
            curMin = res = Math.min(res, findmin(matrix, marked, i, j - 1, cur + 1)); //��
            curMin = res = Math.min(res, findmin(matrix, marked, i - 1, j, cur + 1)); //��
            curMin = res = Math.min(res, findmin(matrix, marked, i, j + 1, cur + 1)); //��
            curMin = res = Math.min(res, findmin(matrix, marked, i + 1, j, cur + 1)); //��
            marked[i][j] = false;
        }
        return res;
    }
}
