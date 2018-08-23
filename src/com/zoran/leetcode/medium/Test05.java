package com.zoran.leetcode.medium;

/**
 * 字符串转整数 (atoi)
 * https://leetcode-cn.com/submissions/detail/5944465/
 */
public class Test05 {

	public static void main(String[] args) {
		Test05 test05 = new Test05();
		System.out.println(test05.myAtoi("+1"));
	}

	/*
	 * 结合异常来处理越界问题
	 */
	public int myAtoi(String str) {
		str = str.trim();
		if(str == null || str.length() == 0) return 0;
		if(str.charAt(0)<'0' || str.charAt(0)>'9') {
			if(!(str.charAt(0) =='+' || str.charAt(0) =='-')) {
				return 0;
			}
		}

		int endIndex = str.length();
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i)<'0' || str.charAt(i)>'9') {
				endIndex = i; break;
			}
		}

		int num = 0;
        str = str.substring(0, endIndex);
        if(str.charAt(0) == '+' && str.length()==1) return 0;
        if(str.charAt(0) == '-' && str.length()==1) return 0;
        
		try {
			num = Integer.valueOf(str.substring(0, endIndex));
		} catch (NumberFormatException e) {
			if(str.charAt(0) == '-') {
				num = Integer.MIN_VALUE;
			} else {
				num = Integer.MAX_VALUE;
			}
		}
		
		return (int) num;
	}
}
