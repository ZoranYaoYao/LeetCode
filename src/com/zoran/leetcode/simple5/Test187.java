package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符的最短距离
 * https://leetcode-cn.com/submissions/detail/5620431/
 */
public class Test187 {

    public int[] shortestToChar(String S, char C) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i< S.length(); i++) {
            if(S.charAt(i) == C) list.add(i);
        }
        
        int[] result = new int[S.length()];
        for(int i=0; i<S.length(); i++) {
            int min = Integer.MAX_VALUE;
            for(Integer item: list) {
                if(Math.abs(i-item) < min) min = Math.abs(i-item);
            }
            result[i] = min;
        }
        
        return result;
    }

    public int[] Nice_shortestToChar(String S, char C) {
    	int[] result = new int[S.length()];
    	char[] chars = S.toCharArray();
    	for (int i=0; i<chars.length; i++) {
    		result[i] = Math.min(forward(chars,C,i), backward(chars,C,i)); //Core. 传递字符数组过去比较前后
    	}
    	return result;
    }


	private int forward(char[] chars, char c, int n) {
		for(int i=0; i<chars.length-n; i++) {
			if(chars[i+n] == c) return i;
		}
		return Integer.MAX_VALUE;
	}
	
	private int backward(char[] chars, char c, int n) {
		for (int i=1; i<=n; i++) {
			if (chars[n-i] == c) return i;
		}
		return Integer.MAX_VALUE;
	}
}
