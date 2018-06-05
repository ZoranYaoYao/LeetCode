package com.zoran.leetcode.simple2;
/**
 * 验证回文串
 * https://leetcode-cn.com/submissions/detail/2909345/
 * 
 * 理解什么是回文字符串
 * https://blog.csdn.net/vvnnnn/article/details/80066085
 */
public class Test31 {

	public boolean Nice_isPalindrome(String s) {
		char[] cha = s.toCharArray();
		int i = 0, j = cha.length -1;
		while (i < j) {
			if (!Character.isLetterOrDigit(cha[i])) 
				i++;
			else if (!Character.isLetterOrDigit(cha[j])) {
				j--;
			}else {
				if (Character.toLowerCase(cha[i]) == Character.toLowerCase(cha[j])) {
					i++;
					j--;
				} else {
					return false;
				}
			}
		}
		
		return true;
	}
}
