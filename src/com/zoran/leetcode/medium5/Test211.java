package com.zoran.leetcode.medium5;

/**
 * 最长特殊序列 II
 * https://leetcode-cn.com/submissions/detail/11691106/
 *
 * [Solution]
 * https://blog.csdn.net/zrh_CSDN/article/details/85254691
 *
 * 遍历找到最长的字符串，并且字符数组中没有他的相同字符串
 * */
public class Test211 {

}

class Nice_Test211 {
    public int findLUSlength(String[] strs) {
        int res =-1, j=0, n = strs.length;
        for (int i=0; i<n; i++) {
            for (j=0; j<n; j++) {
                if (i==j) continue;
                if (checkSubs(strs[i], strs[j])) break;
            }
            if (j == n) res = Math.max(res, strs[i].length()); //Core. 穷举找出最长的字符串！
        }
        return res;
    }

    private boolean checkSubs(String subs, String str) {
        int i=0;
        for(char c : str.toCharArray()) {
            if (c == subs.charAt(i)) i++;
            if (i == subs.length()) break;
        }

        return i == subs.length();
    }
}