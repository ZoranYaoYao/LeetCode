package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * K 次取反后最大化的数组和
 * https://leetcode-cn.com/submissions/detail/14718790/
 *
 * 找规律
 */
public class Test244 {

    public int largestSumAfterKNegations(int[] A, int K) {
        //排序之后，优先改变负数，然后最小正数
        Arrays.sort(A);
        while(K > 0) {
            A[0] = -A[0];
            K--;
            Arrays.sort(A);
        }

        int res = 0;
        for (int item : A) {
            res += item;
        }
        return res;
    }
}
