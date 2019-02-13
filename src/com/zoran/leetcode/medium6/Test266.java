package com.zoran.leetcode.medium6;

/**
 * 两个字符串的最小ASCII删除和
 * https://leetcode-cn.com/submissions/detail/12655143/
 *
 * [Solution]
 * https://blog.csdn.net/OneDeveloper/article/details/79945091
 *
 */
public class Test266 {
    public static void main(String[] args) {
        Test266 test266 = new Test266();
        String s1 = "delete";
        String s2 = "leet";
        int res = test266.minimumDeleteSum(s1,s2);
        System.out.println(res);
    }

    public int minimumDeleteSum(String s1, String s2) {
        //求出2个字符串删除的最大子集
        //穷举删除
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        int res = Integer.MAX_VALUE;
        for (int i=0; i<s2.length(); i++) {
            for (int j=i+1; j<=s2.length(); j++) {
                int temp = 0;
                /**
                 * 算法不对，最大公共子集，可以不是连续的子集！！
                 */
                String s = s2.substring(i,j);
                int cur = 0;
                for(int k=0; k<s1.length(); k++) {
                    char c1 = s1.charAt(k);

                    if (cur>=s.length() || c1 != s.charAt(cur)) {
                        temp += c1;
                    } else {
                        cur++;
                    }
                }
                //cur 指配对的个数
                if (cur != s.length()) continue;

                //加上S2剩余部分
                for (int m=j; m<s2.length(); m++) {
                    temp += s2.charAt(m);
                }

                res = Math.min(temp, res);
            }
        }
        return res;
    }
}

class Nice_Test266 {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 0;
        for (int j=1; j<len2+1; j++) {
            //Core 计算0，j边界值
            dp[0][j] = dp[0][j-1] + s2.charAt(j-1);
        }

        for (int i=1; i<len1+1; i++) {
            dp[i][0] = dp[i-1][0] + s1.charAt(i-1);
            for (int j=1; j<len2+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    /**Nice 根据动态规划，获取最小值是针对最后一个元素删除，来查看的！！*/
                    dp[i][j] = Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1] + s2.charAt(j-1));
                }
            }
        }

        return dp[len1][len2];
    }
}





































