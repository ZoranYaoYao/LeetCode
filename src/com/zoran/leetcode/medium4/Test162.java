package com.zoran.leetcode.medium4;

/**
 * �����滻
 * https://leetcode-cn.com/submissions/detail/10379265/
 *
 * [Solution]
 * https://blog.csdn.net/u011934885/article/details/52510297
 */
public class Test162 {

    public static void main(String[] args) {
        Test162 test162 = new Test162();
        int res = test162.integerReplacement_U1(65535);
        System.out.println(res);
    }

    /**
     * 9999 ��ʱ
     */
    int res = Integer.MAX_VALUE;

    public int integerReplacement(int n) {
        //�������������ֵ���滻����ֵ
        compute(n, 0);
        System.out.println("res = " + res);
        return res;
    }

    public void compute(int n, int count) {
        if (n < 0) return;
//        System.out.println(n);

        if (n % 2 == 0) {
            n /= 2;
            compute(n, count + 1);
        } else {
            if (n == 1) {
                res = Math.min(res, count);
                return;
            }
            compute(n - 1, count + 1);
            compute(n + 1, count + 1);

        }
    }

    /**
     * �����ڴ�����
     * 200000000
     */
    public int integerReplacement_U1(int n) {
        //�������������ֵ���滻����ֵ-��ʱ
        // dp(n) = (dp(n-1)+1 || dp(n+1)+1) || dp(n/2)+1
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2); //����dp[i+1]��0

            }
        }

        // System.out.println("res = " + res);
        return dp[n];
    }
}

class Nice_Test162 {

    /**
     * ��ͬ������Ϊɶ�ҵĵ�һ�ֵݹ鷽ʽ���У�
     * �������������>> ���ҳ�����
     */
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } else if (n == Integer.MAX_VALUE){
            return 2 + integerReplacement((n>>1) +1);
        }

        if (n % 2 == 0) {
            return integerReplacement(n>>1) +1;
        } else {
            return Math.min(integerReplacement(n+1) + 1, integerReplacement(n-1) +1);
        }
    }
}
