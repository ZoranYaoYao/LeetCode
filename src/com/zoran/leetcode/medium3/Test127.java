package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * ��󵥴ʳ��ȳ˻�
 * https://leetcode-cn.com/submissions/detail/8862235/
 * 
 * OT
 */
public class Test127 {

    public int maxProduct(String[] words) {
        //�������, �������
        if (words == null || words.length == 0) return 0;
        int max = 0;
        Arrays.sort(words);
        for (int i=words.length-1; i>=0; i--) {
            for (int j=i-1; j>=0; j--) {
                int cur = curResult(words[i], words[j]);
                max = Math.max(max, cur);
            }
        }
        
        return max;
    }
    
    private int curResult(String str1, String str2) {
        for (int i=0; i<str2.length(); i++) {
            if (str1.contains(str2.charAt(i)+"")) return 0;
        }
        
        return str1.length() * str2.length();
    }
}
