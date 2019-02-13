package com.zoran.leetcode.medium6;

import java.util.Arrays;

/**
 * �����������ϵĸ���
 * https://leetcode-cn.com/submissions/detail/12645523/
 *
 * [Solution]
 * https://blog.csdn.net/zw159357/article/details/82823924
 *
 * ��dp[0][0]��ʼ�Ķ�̬�滮
 */
public class Test262 {


    public static void main(String[] args) {
        Test262 test262 = new Test262();
        test262.knightProbability(3,
                2,
                0,
                0);
        System.out.println(test262.res);
    }


    /**
     * 11 / 21 ��ͨ����������
     * ״̬������ʱ������
     */
    double res;
    int count;
    public double knightProbability(int N, int K, int r, int c) {
        //����ÿһ��case,����
        int[][] step = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
        count = K;
        backTrace(N, step,r, c, K);
        return res;
    }

    private void backTrace(int N, int[][] step, int r, int c, int K) {
        if (r < 0 || r > N - 1 || c < 0 || c > N - 1) return;
        if (K == 0) {
            res += Math.pow((double) 1 / 8, count);
            return;
        }

        for (int i = 0; i < step.length; i++) {
            backTrace(N, step, r + step[i][0], c + step[i][1], K - 1);
        }
    }
}


class Nice_Test262 {
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        for(double[] d: dp) {
            Arrays.fill(d,1);
        }

        int[][] dt = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
        /**
         * ��̬�滮��
         * dp[i][j] i��j������K�β����п��Ե���Ĵ���
         * dp[i][j] += dp[x][y] ��һ��+dt[][]�������̵Ĵ�������
         */
        for (int k=1; k<=K; k++) {
            double[][] t = new double[N][N];
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    for (int[] d : dt) {
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x<0 || x>=N || y<0 || y>=N) continue;
                        t[i][j] += dp[x][y];
                    }
                }
            }
            dp = t;
        }

        return dp[r][c]/Math.pow(8,K);
    }
}


































