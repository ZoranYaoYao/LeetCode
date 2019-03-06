package com.zoran.leetcode.simple6;

/**
 * ��ѯ���ż����
 * https://leetcode-cn.com/submissions/detail/14014912/
 *
 * �۲�ǰ������仯֮���ܺ͵ı仯
 */
public class Test237 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        //���ⷭ��
        int[] res = new int[queries.length];
        for (int row=0; row<queries.length; row++) {
            int value = queries[row][0];
            int index = queries[row][1];
            A[index] += value;
            int temp = 0;
            for (int i=0; i<A.length; i++) {
                if (A[i] % 2 == 0) temp += A[i];
            }
            res[row] = temp;
        }

        return res;
    }
}

class LeetCode_Test237 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int N = queries.length;
        int[] res = new int[N];
        int S = 0;
        for (int x: A) {
            if (x%2 == 0) S += x;
        }
        for (int i=0; i< N; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (A[index] % 2 == 0) {
                S -= A[index];
            }
            //Nice_Core ÿ�θ�����ֵ���������飬���ж�ǰ���ֵ�ı仯����
            A[index] = A[index] + val;
            if (A[index] % 2 == 0) {
                S += A[index];
            }
            res[i] = S;
        }
        return res;
    }

}
