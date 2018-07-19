package com.zoran.leetcode.simple4;


/**
 * 反转字符串中的单词 III 
 * https://leetcode-cn.com/submissions/detail/4359834/
 */
public class Test122 {

    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String item: arr) {
            sb.append((new StringBuilder(item)).reverse() + " ");
        }
        return sb.toString().substring(0, sb.toString().length() -1);
    }
}
