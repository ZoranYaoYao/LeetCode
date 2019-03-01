package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * �ظ� N �ε�Ԫ��
 * https://leetcode-cn.com/submissions/detail/13544029/
 */
public class Test231 {

    public int repeatedNTimes(int[] A) {
        //�������򣬶Աȴ���
        int N = A.length/2;
        Arrays.sort(A);

        int curNum = 1;
        for (int i=0; i<A.length-1; i++) {
            if (A[i] == A[i+1]) {
                curNum++;
            } else {
                if (curNum == N) return A[i];
                curNum = 1;
            }
        }

        return A[A.length-1];
    }
}
