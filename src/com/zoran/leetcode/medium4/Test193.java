package com.zoran.leetcode.medium4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * һ����
 * https://leetcode-cn.com/submissions/detail/10875748/
 *
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/6188893.html
 */
public class Test193 {
    /**
     * �㷨������
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //������ƥ�䳤����̵�
        if(strs == null || strs.length == 0) return 0;

        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length(); //��������
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
        int[][] dp = new int[m+1][n+1]; //Core m,n��Ӧ����Ĵ�С��ֵ
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')  ++zeros ;
                else  ++ones;
            }

            for (int i=m; i>=zeros; i--) { //Nice_Core �����������̬�滮ÿһ�εı����������޸�dp[i][j]��ֵ
                for (int j=n; j>= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeros][j-ones] + 1);
                }
            }

        }
        return dp[m][n];

    }
}