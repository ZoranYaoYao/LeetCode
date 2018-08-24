package com.zoran.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 整数转罗马数字
 * https://leetcode-cn.com/submissions/detail/5996705/
 * 
 * [Solution]
 * https://blog.csdn.net/hit1110310422/article/details/80808382
 * 
 * 1. 双数组解决映射关系
 * 2. 数字从大到小处理, 对4,9数字进行特殊处理
 */
public class Test07 {

	public static void main(String[] args) {
		Test07 test07 = new Test07();
		System.out.println(test07.Nice_intToRoman(5));
	}
	
	public String Nice_intToRoman(int num) {
		if (num <= 0) return "";
		StringBuilder sb = new StringBuilder();
		int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] flags = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		for(int i=0; i<13 && num>0; i++) {
			while(num >= number[i]) { //Nice. 比较大位数
				num -= number[i];
				sb.append(flags[i]);
			}
		}
		return sb.toString();
	}
}
