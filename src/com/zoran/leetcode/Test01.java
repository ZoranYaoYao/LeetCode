package com.zoran.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * https://leetcode-cn.com/problems/palindrome-number/description/
 * @author Zoran
 */
public class Test01 {

	//zqs
    public boolean isPalindrome(int x) {
    	boolean result = true;
        if(x < 0) return false;
        if(0 == x) return true;
        
        char[] numbers =String.valueOf(x).toCharArray();
        //折半检查
        for (int i = 0; i < numbers.length/2; i++) {
        	if (numbers[i] != numbers[numbers.length - i - 1]) {
				result = false;
				break;
			}
		}
        return result;
    }
    
    public boolean Nice_isPalindrome(int x) {
        long sum = 0;
        long a = x;
        if(x<0)
            return false;
        
        while(x!=0){
            sum = sum *10 + x%10;  //根据数学取余获取个位上的值, 然后在生成新的一个数字,判断是否与原来相等
            x = x/10;
        }
        
        if (sum==a)
            return true;
        else
            return false;
        
    }
}
