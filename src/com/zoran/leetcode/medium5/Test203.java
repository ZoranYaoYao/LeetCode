package com.zoran.leetcode.medium5;

/**
 * 对角线遍历
 * https://leetcode-cn.com/submissions/detail/11130953/
 *
 * OT
 */
public class Test203 {
    public int[] findDiagonalOrder(int[][] matrix) {
        //根据对角线边界进行遍历
        if (matrix == null || matrix.length == 0) return new int[0];
        int orientation = 0; //0-上， 1-下

        int count = 0;
        int row = matrix.length - 1;
        int column = matrix[0].length - 1;
        int all = (row + 1) * (column + 1);
        int[] res = new int[all];
        int curRow = 0, curColumn = 0;
        while (count < all) {
            res[count] = matrix[curRow][curColumn];
            count++;

            if (orientation == 0) {
                if (curColumn + 1 > column) {
                    orientation = 1;
                    curRow += 1;
                } else if (curRow == 0) {
                    orientation = 1;
                    curColumn += 1;
                } else {
                    curRow -= 1;
                    curColumn += 1;
                }
            } else {
                if (curRow + 1 > row) {
                    orientation = 0;
                    curColumn += 1;
                } else if (curColumn == 0) {
                    orientation = 0;
                    curRow += 1;
                } else {
                    curRow += 1;
                    curColumn -= 1;
                }
            }
        }

        return res;
    }
}
