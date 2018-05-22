package com.zoran.leetcode;

import java.util.Arrays;

public class Test14 {
	public static void main(String[] args) {
		//输入: a = "1010", b = "1011"
		//输出: "10101"
		System.out.println(addBinary("101111", "10"));
	}
	
	
	/**
	 * 1.先处理长度相等的时候
	 * 2.在处理更长的字符数组
	 * 3.最高位是否进位
	 */
    public static String addBinary(String a, String b) {
    	char[] charA = a.toCharArray();
    	char[] charB = b.toCharArray();
    	int lessLength = charA.length >= charB.length ? charB.length : charA.length;
    	char[] moreArr = charA.length >= charB.length ? charA : charB;
    	int carry = 0;
    	for(int i = 0; i < lessLength; i++) {
    		int tmpA = charA[charA.length-1-i] == '1' ? 1: 0;
    		int tmpB = charB[charB.length-1-i] == '1' ? 1: 0;
    		if(tmpA + tmpB +carry> 1 ) {
    			if((tmpA + tmpB + carry)%2 == 1) {    //zqs 进位 余1的情况
        			moreArr[moreArr.length-1-i] = '1'; //字符要用单引号括起来
    			} else {
    				moreArr[moreArr.length-1-i] = '0'; //字符要用单引号括起来
    			}
    			carry =1; //进位
    		} else {
    			moreArr[moreArr.length-1-i] = String.valueOf((tmpA + tmpB + carry)).toCharArray()[0]; //zqs. 向前进位 要加carry
    			carry =0; //重置
    		}
    	}
    	
    	int yu = moreArr.length - lessLength; //余留位置
    	for(int j =0; j < yu;j++) {
    		int tmp = moreArr[yu-j-1] == '1' ? 1: 0;
    		if(tmp + carry > 1) {   //zqs 一切运算都先转化为int型,在进行计算
    			moreArr[yu-j-1]= '0';
    			carry=1; //进位
    		} else {
    			if(tmp + carry ==1) { //zqs 进位来的1
    				moreArr[yu-j-1]= '1';
    			}
    			carry=0; //zqs 重置
    		}
    	}
    	
    	char[] finalChar;
    	if(carry == 1) { // 最高位进位
    		finalChar = new char[moreArr.length + 1];
    		finalChar[0] = '1';
    		System.arraycopy(moreArr, 0, finalChar, 1, moreArr.length);
    		return String.valueOf(finalChar);
    	}
    	
        return String.valueOf(moreArr);
    }
    
    /**
     * 根据字符位置 '0' ,开始进行加法运算
     */
    public String Nice_addBinary(String a, String b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        int m = a.length();
        int n = b.length();
        int size = Math.max(m, n);
        char[] result = new char[size];
        char[] longArray = m > n ? a.toCharArray() : b.toCharArray();
        char[] shortArray = m > n ? b.toCharArray() : a.toCharArray();
        int diff = longArray.length - shortArray.length; // important
        int carry = 0;
        for (int i = size - 1; i >= 0; i--) {
            int sum = carry + (longArray[i] - '0');
            if (i - diff >= 0) {
                sum += (shortArray[i - diff] - '0');
            }
            carry = sum / 2;
            result[i] = (char)(sum % 2 + '0');
        }

        if (carry != 0) {
            return "1" + new String(result);
        }
        return new String(result);
    }
}
