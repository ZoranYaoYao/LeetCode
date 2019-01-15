package com.zoran.leetcode.medium5;

import java.util.ArrayList;
import java.util.List;

/**
 * ��Ǯ�һ� II
 * https://leetcode-cn.com/submissions/detail/11655266/
 *
 * [Solution]
 * https://blog.csdn.net/amber804105/article/details/81484370
 *
 * ÿ����һ��Ӳ�ң���0��ʼ���µ���������ǰ�Ľ��ֵ��
 */
public class Test209 {

    public static void main(String[] args) {
        Test209 test209 = new Test209();
        int[] coins = {1, 2, 5};
        int a = test209.change(5, coins);
        System.out.println(a);
    }

    /**
     * 1000
     * [3,5,7,8,9,10,11]
     * ��ʱ
     */
//    int res;
//    public int change(int amount, int[] coins) {
//        if (coins == null || coins.length == 0) {
//            if (amount == 0) return 1;
//            return 0;
//        }
//
//        backTrace(coins, 0, 0, amount);
//        return res;
//    }
//
//    private void backTrace(int[] coins, int curCount, int start, int amount) {
//        if (curCount >= amount) {
//            if (curCount == amount) res++;
//            return;
//        }
//
//        for(int i=start; i<coins.length; i++) {
//            curCount += coins[i];
//            backTrace(coins, curCount, i, amount);
//            curCount -= coins[i];
//        }
//    }

    /**
     * �㷨������
     */
    public int change(int amount, int[] coins) {
        //dp[i] = dp[j] + 1
        if (coins == null || coins.length == 0) {
            if (amount == 0) return 1;
            return 0;
        }
        int[] dp = new int[amount + 1];
        List<Integer> list = new ArrayList<>();
        for (int item : coins) list.add(item);
        dp[0] = 1;
        for (int i = amount / 2; i <= amount; i++) {
            for (int j = 0; j <= i; j++) {
                if (list.contains(amount - j)) {
                    dp[i] += dp[j]; //���ظ�����
                }
            }
        }

        return dp[amount];
    }
}

class Nice_Test209 {

    public static void main(String[] args) {
        Nice_Test209 test209 = new Nice_Test209();
        int[] coins = {1, 2, 5};
        int a = test209.change(5, coins);
        System.out.println(a);
    }


    public int change(int amount, int[] coins) {
        if (coins.length == 0) return amount == 0 ? 1 : 0;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) { //Nice_Core ��Ӳ�Ҹ�������
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) dp[j] += dp[j - coins[i]]; //Nice_core, ��ÿ�ν����̬���е���
                System.out.println("dp[" + j + "] = " + dp[j]);
            }
        }
        return dp[amount];
    }
}
