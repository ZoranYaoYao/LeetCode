package com.zoran.leetcode.simple6;

/**
 * 查询后的偶数和
 * https://leetcode-cn.com/submissions/detail/14014912/
 *
 * 观察前后数组变化之后，总和的变化
 */
public class Test237 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        //题意翻译
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
            //Nice_Core 每次更改了值，跟新数组，并判断前后差值的变化！！
            A[index] = A[index] + val;
            if (A[index] % 2 == 0) {
                S += A[index];
            }
            res[i] = S;
        }
        return res;
    }

}
