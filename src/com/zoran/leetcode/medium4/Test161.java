package com.zoran.leetcode.medium4;

/**
 * 旋转函数
 * https://leetcode-cn.com/submissions/detail/10342236/
 *
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/52511651
 */
public class Test161 {

    /**
     * 超时
     */
    public int maxRotateFunction(int[] A) {
        //按照题意遍历
        if (A == null || A.length == 0) return 0;
        int size = A.length;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<size; i++) {
            int count = 0;
            for(int j=0; j<size; j++) {
                count += j * A[(j+i) % size]; //Core. 旋转操作
            }
            res = Math.max(count, res);
        }

        return res;
    }
}

class Nice_Test161 {
    /**
     * 数学，找规律法
     */
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        int f0 = 0;
        int sumOfA = 0;
        for (int i=0; i<n; i++) {
            f0 += i*A[i];
            sumOfA += A[i];
        }

        int max = f0;
        int fi = f0;
        for (int i=1; i<n; i++) {
            fi += sumOfA;
            fi -= n*A[n-i];
            max = Math.max(max, fi);
        }

        return max;
    }
}























