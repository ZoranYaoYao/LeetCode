package com.zoran.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ת��������
 * https://leetcode-cn.com/submissions/detail/5996705/
 * 
 * [Solution]
 * https://blog.csdn.net/hit1110310422/article/details/80808382
 * 
 * 1. ˫������ӳ���ϵ
 * 2. ���ִӴ�С����, ��4,9���ֽ������⴦��
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
			while(num >= number[i]) { //Nice. �Ƚϴ�λ��
				num -= number[i];
				sb.append(flags[i]);
			}
		}
		return sb.toString();
	}
}
