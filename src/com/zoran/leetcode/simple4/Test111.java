package com.zoran.leetcode.simple4;

/**
 * �߽�����
 * https://leetcode-cn.com/submissions/detail/4129910/
 */
public class Test111 {
	
	/**
	 * OT 
	 */
    public String convertToBase7(int num) {
        if(num == 0) return "0";
        boolean isNegave = false;         //����, �����෴.
        if(num<0) {
            num = -num;
            isNegave = true;
        }
        
        String base7 = new String();
        while(num > 0) {
            base7 = (num % 7) + base7; 
            num = num / 7;
        }
        
        return  isNegave ? "-" + base7 : base7;
    }
}
