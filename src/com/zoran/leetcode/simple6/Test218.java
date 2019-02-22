package com.zoran.leetcode.simple6;

/**
 * 最小差值 I
 * https://leetcode-cn.com/submissions/detail/13135105/
 *
 * 数学问题
 */
public class Test218 {

    public int smallestRangeI(int[] A, int K) {
        //找出最大，最小值，距离-2K
        if (A.length <= 1) return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }
        return max-min-2*K < 0 ? 0 : max-min-2*K;
    }
}
