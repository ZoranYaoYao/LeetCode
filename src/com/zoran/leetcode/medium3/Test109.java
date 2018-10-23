package com.zoran.leetcode.medium3;

/**
 * ������ά���� II
 * https://leetcode-cn.com/submissions/detail/8573106/
 */
public class Test109 {

    public boolean searchMatrix(int[][] matrix, int target) {
        //ͨ������ ����һ�н�������
    
        boolean res = search(matrix, target, 0, 0);
        return res;
    }
    
    private boolean search(int[][] matrix, int target, int curRow, int curCol) {
        for (int i = curRow; i < matrix.length; i++) {
            for (int j = curCol; j< matrix[0].length; j++) {
                if (matrix[i][j] == target) return true;
                else if (matrix[i][j] > target) break;
            }
        }
        
        return false;
    }
}
