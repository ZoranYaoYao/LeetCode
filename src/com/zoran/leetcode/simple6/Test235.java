package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * ���������ƽ��
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
