package com.zoran.leetcode.medium4;

/**
 * ��ת����
 * https://leetcode-cn.com/submissions/detail/10342236/
 *
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/52511651
 */
public class Test161 {

    /**
     * ��ʱ
     */
    public int maxRotateFunction(int[] A) {
        //�����������
        if (A == null || A.length == 0) return 0;
        int size = A.length;
        int res = Integer.MIN_VALUE;
        for(int i=0; i<size; i++) {
            int count = 0;
            for(int j=0; j<size; j++) {
                count += j * A[(j+i) % size]; //Core. ��ת����
            }
            res = Math.max(count, res);
        }

        return res;
    }
}

class Nice_Test161 {
    /**
     * ��ѧ���ҹ��ɷ�
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























