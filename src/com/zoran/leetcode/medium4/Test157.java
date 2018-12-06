package com.zoran.leetcode.medium4;

/**
 * 判断子序列
 * https://leetcode-cn.com/submissions/detail/10156106/
 */
public class Test157 {


    public boolean isSubsequence(String s, String t) {
        //一一对比
        if (s == null || s.length() == 0) return true;

        char[] tchrs = t.toCharArray();
        char[] schrs = s.toCharArray();
        int index = 0;
        for(int i=0; i<tchrs.length; i++) {
            if(tchrs[i] == schrs[index]) {
                if (++index >= schrs.length) return true;
            }
        }

        return false;
    }

}
