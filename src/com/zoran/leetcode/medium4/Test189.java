package com.zoran.leetcode.medium4;

/**
 * 我能赢吗
 * https://leetcode-cn.com/submissions/detail/10804902/
 * <p>
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/79968342
 */
public class Test189 {
    /**
     * 算法有问题
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //动态规划
        //奇偶性
        if (desiredTotal <= maxChoosableInteger) return true;

        boolean[] dp = new boolean[desiredTotal + 1];
        for (int i = maxChoosableInteger + 1; i <= desiredTotal; i++) {
            int count = 0;
            int temp = i;
            for (int j = 0; j < maxChoosableInteger; j++) {
                temp -= maxChoosableInteger - j;
                if (temp < 0) {
                    break;
                } else {
                    count++;
                }
            }
            dp[i] = count % 2 == 0;
        }
        return dp[desiredTotal];
    }
}

class Nice_Test189 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        int n = maxChoosableInteger;
        int sum = n * (n + 1) / 2;
        if (sum < desiredTotal) return false;
        Boolean[] dp = new Boolean[1 << n]; //Nice_Core 记录位置
        return canIWin(0, n, desiredTotal, dp);
    }

    private boolean canIWin(int state, int n, int remain, Boolean[] dp) {
        if (remain <= 0) {
            //dp[state] = false;
            //Base case:
            return false;
        }

        if (dp[state] == null) {
            dp[state] = false;
            int mask = 1;
            //Key Point: take from the tail
            for (int i = 1; i <= n; i++) {
                int future = state | mask;
                if (future != state && !canIWin(future, n, remain - i, dp)) {
                    //update current status = true
                    dp[state] = true;
                    break;
                }
                mask <<= 1; //记录选中值
            }
        }

        return dp[state];
    }
}
