package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * 有序数组的平方
 * https://leetcode-cn.com/submissions/detail/14012434/
 */
public class Test235 {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        for (int i=0; i<A.length; i++) {
            res[i] = A[i] * A[i];
        }

        Arrays.sort(res);
        return res;
    }
}
