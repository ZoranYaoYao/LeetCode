package com.zoran.leetcode.medium5;

import java.util.Map;

/**
 * 两个字符串的删除操作
 * https://leetcode-cn.com/submissions/detail/11937881/
 *
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/9574188.html
 *
 * 牛逼的动态规划算法
 */
public class Test231 {
    public int minDistance(String word1, String word2) {
        //先删除异性字符，然后找打最长的连续字符
        int res =0;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (char c : word1.toCharArray()) {
            if (word2.contains(c+"")) {
                sb1.append(c);
            } else {
                res++;
            }
        }

        for (char c : word2.toCharArray()) {
            if (word1.contains(c+"")) {
                sb2.append(c);
            } else {
                res++;
            }
        }

        //找出共同长度？??
        String str1 = sb1.toString();
        String str2 = sb2.toString();
        int length = Math.min(str1.length(), str2.length());
        int count = 0;
        for (int i=0; i<length; i++) {
        }

        return res;
    }
}

class Nice_Test231 {

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for (int i=0; i<word1.length()+1; i++) {
            for (int j=0; j<word2.length()+1; j++) {
                if (i ==0 || j == 0) continue;
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    //Nice_Core 状态转换，依赖字符串-1长度的公共子序列长度
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    //Nice_core 错位进行获取最大的公共子序列长度
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return word1.length()+word2.length()
                - 2*dp[word1.length()][word2.length()];
    }

}





























