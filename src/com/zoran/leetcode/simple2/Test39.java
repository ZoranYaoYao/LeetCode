package com.zoran.leetcode.simple2;

/**
 * Excel�������
 * https://leetcode-cn.com/submissions/detail/3035172/
 */
public class Test39 {

	/**
	 * 26���� ת10����
	 * one time success!
	 */
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chr = s.toCharArray();
        int length = s.length(); int count = 0;
        for (char item : chr) {
            count += ((int)item - 'A') * Math.pow(26, length -1);
            length--;
        }
        return count;
    }
}
