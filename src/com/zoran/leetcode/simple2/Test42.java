package com.zoran.leetcode.simple2;

/**
 * 颠倒二进制位
 * https://leetcode-cn.com/submissions/detail/3104013/
 */
public class Test42 {

	public static void main(String[] args) {
		System.out.println(reverseBits(2));
	}

	/**
	 * case 2 -> leetCode 运行异常
	 */
	public static int reverseBits(int n) {
		String str = new String();
		while(n > 0) {
			str = (n % 2) + str;
			n = n / 2;
		}
		
		if (str.length() < 32) {
			while (32 - str.length() > 0) {
				str = "0" + str;
			}
		}
		
		//System.out.println(str);
		StringBuilder sb = new StringBuilder(str);
		str = sb.reverse().toString();
		
		//int revertNum = Integer.parseInt(str); //java.lang.NumberFormatException
		int revertNum = 0;
		while(str.length() > 0) {
			int i = Integer.valueOf(str.substring(0,1));
			revertNum += i *Math.pow(2, str.length() -1);
			str = str.substring(1,str.length());
			System.out.println(str);
		}
		
		return revertNum;
	}
}
