package com.zoran.leetcode.medium5;

/**
 * 回文子串
 * https://leetcode-cn.com/submissions/detail/12165774/
 */
public class Test244 {
    int res;
    public int countSubstrings(String s) {
        //根据长度来遍历
        char[] chrs = s.toCharArray();
        for(int i=0; i<chrs.length; i++) {
            find(chrs, i);
        }
        return res;
    }

    private void find(char[] chrs,int length) {
        for(int i=0; i<chrs.length-length; i++) {
            if(isBack(chrs,i,i+length)) res++;
        }
    }

    private boolean isBack(char[] chrs, int start, int end) {
        if (start > end) return false;
        if (start == end) return true;
        while(start < end) {
            if (chrs[start++] != chrs[end--]) return false;
        }
        return true;
    }
}
