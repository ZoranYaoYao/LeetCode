package com.zoran.leetcode.simple4;

/**
 * 最长特殊序列 Ⅰ 
 * https://leetcode-cn.com/submissions/detail/4264470/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80287368
 */
public class Test115 {
	public int findUSlength(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		if(lenA != lenB) {
			return Math.max(lenA, lenB);
		} else {
			if (a.equals(b)) {
				return -1;
			} else {
				return lenA;
			}
		}
	}
}
