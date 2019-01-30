package com.zoran.leetcode.medium5;

/**
 * 只有两个键的键盘
 * https://leetcode-cn.com/submissions/detail/12240813/
 *
 * [Solution]
 * https://blog.csdn.net/lml0703/article/details/80289820
 *
 * dp[n] = dp[max(a,b)] + min(a,b);
 */
public class Test247 {
    /**
     * 72 / 126 个通过测试用例
     * 状态：解答错误
     * 算法有问题！
     */
    public int minSteps(int n) {
        //找规律，奇数：n个A, 偶性，2(n)
        if (n == 1) return 0;
        if (n % 2 != 0) return n;

        int res = 0;
        while (n % 2 == 0) {
            n = n/2;
            res += 2; //复制 + 粘贴
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
            i = (int) Math.sqrt(num); //Core 通过开平方根，找2个数相乘,遍历所有的乘极关系
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
