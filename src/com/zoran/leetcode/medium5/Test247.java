package com.zoran.leetcode.medium5;

/**
 * ֻ���������ļ���
 * https://leetcode-cn.com/submissions/detail/12240813/
 *
 * [Solution]
 * https://blog.csdn.net/lml0703/article/details/80289820
 *
 * dp[n] = dp[max(a,b)] + min(a,b);
 */
public class Test247 {
    /**
     * 72 / 126 ��ͨ����������
     * ״̬��������
     * �㷨�����⣡
     */
    public int minSteps(int n) {
        //�ҹ��ɣ�������n��A, ż�ԣ�2(n)
        if (n == 1) return 0;
        if (n % 2 != 0) return n;

        int res = 0;
        while (n % 2 == 0) {
            n = n/2;
            res += 2; //���� + ճ��
        }

        return n == 1 ? res : res+n;
    }
}

class Nice_Test247 {
    public int minSteps(int n) {
        int i, num;
        if (n == 1) return 0;
        int[] dp = new int[n+1];
        for (num =1; num <= n; num++) {
            dp[num] = num;
            i = (int) Math.sqrt(num); //Core ͨ����ƽ��������2�������,�������еĳ˼���ϵ
            for (; i>=1; i--) {
                if (num % i == 0) {
                    int tmp = dp[num/i] + i;
                    if (tmp < dp[num]) dp[num] = tmp;
                }
            }
        }

        return dp[n];

    }
}
