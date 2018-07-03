package com.zoran.leetcode.simple3;

import java.math.BigInteger;

/**
 * 字符串相加
 * https://leetcode-cn.com/submissions/detail/3693305/ 
 */
public class Test88 {
	public static void main(String[] args) {
		System.out.println(Nice_addString("11", "111"));
	}
	
    public String addStrings(String num1, String num2) {
//        int numA = Integer.valueOf(num1);
//        int numB = Integer.valueOf(num2);
//        return "" + (numA + numB);
    	
    	BigInteger numA = new BigInteger(num1);
    	BigInteger numB = new BigInteger(num2);
    	return "" +numA.add(numB);
    }
    
    public static String Nice_addString(String num1, String num2) {
    	if (num1.length() < num2.length()) {
    		return Nice_addString(num2, num1);
    	}
    	
    	char[] arr1 = num1.toCharArray();
    	char[] arr2 = num2.toCharArray();
    	for (int i = 0; i < arr2.length; i++) {
			arr1[arr1.length -arr2.length + i] += arr2[i] - '0'; //Nice. 相加对齐的元素值
		}
    	int carry = 0;
    	for (int i = arr1.length - 1; i >= 0; i--) {
			arr1[i] += carry;
			if(arr1[i] > '9') { //Nice. 跟'9' 字符进行比较得到进位数,和自己的元素
				arr1[i] = (char)((arr1[i] -'0')%10 + '0');
				carry = 1;
			} else {
				carry = 0;
			}
		}
    	
    	return carry == 0 ? String.valueOf(arr1) : carry + String.valueOf(arr1);
    }
}
