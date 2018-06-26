package com.zoran.leetcode.simple3;

/**
 * 3����
 * https://leetcode-cn.com/submissions/detail/3514485/
 */
public class Test69 {
	public static void main(String[] args) {
		System.out.println(isPowerOfThree(-3));
	}
	
    public static boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        
        while (n != 1) { //Core: n != 1, ��ʾ �������滹������������,eg: 45 = 3*3*5*1
           if(n % 3 != 0) return false;
           n = n / 3;
        }
        return true;
    }
}
