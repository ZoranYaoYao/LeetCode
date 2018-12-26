package com.zoran.leetcode.medium4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一和零
 * https://leetcode-cn.com/submissions/detail/10875748/
 *
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/6188893.html
 */
public class Test193 {
    /**
     * 算法有问题
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //排序，先匹配长度最短的
        if(strs == null || strs.length == 0) return 0;

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //长度升序
            }
        });
        int res = 0;
        for(int i = 0; i<strs.length; i++) {
            int oneNum = 0;
            int zeroNum = 0;
            char[] chrs = strs[i].toCharArray();
            for(int j=0; j<chrs.length; j++) {
                if (chrs[j] == '1') oneNum++;
                else zeroNum++;
            }
            if (m >= zeroNum && n >= oneNum) {
                res++;
                m -= zeroNum;
                n -= oneNum;
            }
        }
        return res;
    }
}

class Nice_Test193 {
    //dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
    //m0 , n1
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1]; //Core m,n对应数组的大小数值
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')  ++zeros ;
                else  ++ones;
            }

            for (int i=m; i>=zeros; i--) { //Nice_Core 倒序遍历，动态规划每一次的遍历，进行修改dp[i][j]的值
                for (int j=n; j>= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }

        }
        return dp[m][n];

    }
}