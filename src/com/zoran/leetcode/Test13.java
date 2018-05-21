package com.zoran.leetcode;

import sun.security.util.Length;

/**
 * 加一
 * https://leetcode-cn.com/submissions/detail/2468356/
 * 
 * https://www.cnblogs.com/beliveli/p/9016614.html
 */
public class Test13 {

	public static void main(String[] args) {
//		输入: [1,2,3]
//		输出: [1,2,4]
//		解释: 输入数组表示数字 123。
		int[] arr = new int[] {9,8,7,6,5,4,3,2,1,0};
		//int[] arr = new int[] {9,9};
		for(int item: Nice_plusOne(arr)) {
			System.out.println(item);
		}
	}
	
	//数过大时, 范围溢出
    public static int[] plusOne(int[] digits) {
    	int num = 0;
    	for(int i = 0; i< digits.length; i++) {
    		num += digits[i] * Math.pow(10, digits.length - i -1);
    	}
    	num = num + 1;
    	String string = String.valueOf(num);
    	int[] result = new int[string.length()];
    	
    	//[9,8,7,6,5,4,3,2,1,0] 通不过
    	for(int j = 0; j < string.length(); j ++) {
    		result[j] = Integer.valueOf(string.substring(j, j+1));
    	}
    	return result;
    }
    
    /**
     * 1.从最后开始加1
     * 2.若果进位,则继续比较是否进位
     */
    public static int[] Nice_plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            if(carry==0) { 
                return digits;
            }
            int tmp = digits[i] + carry; //从个位数开始 +1
            carry = tmp / 10;  //进位 1 , 不进位0 (只有10/10 才会进位, 其余都会是0)
            digits[i] = tmp % 10;
        }
        if(carry!=0) { //如果carry 进位数不为0, 则表示要进位
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
