package com.zoran.leetcode.simple5;

/**
 * ×ªÖÃ¾ØÕó
 * https://leetcode-cn.com/submissions/detail/5797365/
 */
public class Test198 {

    public int[][] transpose(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] ans = new int[C][R];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                ans[c][r] = A[r][c];
            }
        return ans;
    }
}
