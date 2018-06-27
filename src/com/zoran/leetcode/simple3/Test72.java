package com.zoran.leetcode.simple3;

import java.util.Arrays;
import java.util.List;

/**
 * 反转字符串中的元音字母
 * https://leetcode-cn.com/submissions/detail/3546942/ 
 */
public class Test72 {
	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
	}

	/**
	 * 2个指针, 前后遍历, 替换 
	 */
	public static String reverseVowels(String s) {
		//A、E、I、O、U
		List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
		char[] chr = s.toCharArray();
		for(int i = 0,j = chr.length -1; i < j; i++) {
			if(list.contains(chr[i]) && i < j) {
				boolean changed = false;
				for(;j > i; j--) {
					if(changed) break;
					if(list.contains(chr[j])) {
						char tmp = chr[j];
						chr[j] = chr[i];
						chr[i] = tmp;
						changed = true;
					}
				}
			}
		}

		return new String(chr);
	}
}
