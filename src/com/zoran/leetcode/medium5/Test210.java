package com.zoran.leetcode.medium5;

import java.util.Random;

/**
 * Ëæ»ú·­×ª¾ØÕó
 * https://leetcode-cn.com/submissions/detail/11656272/
 */
public class Test210 {
    class Solution {

        int[][] data;
        public Solution(int n_rows, int n_cols) {
            data = new int[n_rows][n_cols];
        }

        public int[] flip() {
            while (true) {
                int row = new Random().nextInt(data.length);
                int col = new Random().nextInt(data[0].length);
                if (data[row][col] == 0) {
                    data[row][col] = 1;
                    return new int[]{row, col};
                }
            }
        }

        public void reset() {
            for (int i=0; i<data.length; i++) {
                for (int j=0; j<data[0].length; j++) {
                    data[i][j] = 0;
                }
            }
        }
    }
}
