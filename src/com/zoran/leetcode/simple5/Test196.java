package com.zoran.leetcode.simple5;

/**
 * 859. 亲密字符串
 * https://leetcode-cn.com/submissions/detail/5795638/
 * 
 * https://leetcode-cn.com/problems/buddy-strings/solution/
 * 题意理解不对 , 参考阅读解答
 */
public class Test196 {

	//理解题意不对, 交换字符, 不是替换
    public boolean buddyStrings(String A, String B) {
        if(A == null || B == null) return false;
        if(A.length() <2 || B.length() <2 || A.length() != B.length()) return false;
        
        int chance = 2;
        for(int i=0; i<A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) chance--;
        }
        
        return chance >= 0;
    }
    
    //阅读解答
    public boolean LeetCode_buddyStrings(String A, String B) {
    	if(A.length() != B.length()) return false;
    	if(A.equals(B)) {
    		int[] count = new int[26];
    		for (int i=0; i<A.length(); i++) {
    			count[A.charAt(i)-'a']++;
    		}
    		
    		for(int c: count) {
    			if (c > 1) return true;
    		}
    		return false;
    	} else {
    		int first = -1; int second =-1;
    		for (int i=0; i<A.length(); i++) {
    			if (A.charAt(i) != B.charAt(i)) {
    				if (first == -1) {
    					first = i;
    				} else if (second == -1) {
    					second =i;
    				} else 
    					return false;
    			}
    		}
        	return (second != -1 && A.charAt(first) == B.charAt(second) &&
        			A.charAt(second) == B.charAt(first));
    	} 

    }
}
