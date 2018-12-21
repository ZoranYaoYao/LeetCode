package com.zoran.leetcode.medium4;

import java.util.HashMap;

/**
 * ������� II
 * https://leetcode-cn.com/submissions/detail/10713786/
 *
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/53192762
 *
 * hashMap ����ֵ getOrDefault()
 * �۰����
 */
public class Test185 {
    /**
     * ����ʱ������
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        //�Ĳ����ѭ�����
        int res = 0;
        for(int i = 0; i<A.length; i++) {
            for (int j=0; j<B.length; j++) {
                for(int k=0; k<C.length; k++) {
                    for(int m=0; m<D.length; m++) {
                        if(A[i] + B[j] + C[k] + D[m] == 0) res++;
                    }
                }
            }
        }

        return res++;
    }
}

class Nice_Test185 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        if (n == 0) return 0;
        HashMap<Integer, Integer> ab = new HashMap<>();
        for (int a: A) {
            for (int b: B) {
                //Nice getOrDefault() ��ȡĬ��ֵ��
                ab.put(a+b, ab.getOrDefault(a+b, 0) + 1);
            }
        }
        int res = 0;
        for (int c : C) {
            for (int d : D) {
                int part2 = c + d;
                int part1 = -part2;
                res += ab.getOrDefault(part1, 0);
            }
        }
        return res;
    }
}
