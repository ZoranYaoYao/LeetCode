package com.zoran.leetcode.simple3;

import java.time.chrono.MinguoChronology;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 最长回文串
 * https://leetcode-cn.com/submissions/detail/3667674/
 */
public class Test85 {

	/**
	 * one time 
	 */
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(Character c: s.toCharArray()) {
            if(map.get(c) == null) {
                map.put(c,1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        
        int count = 0; boolean single = false;
        for(Entry<Character, Integer> item: map.entrySet()) {
            int num = item.getValue();
            if(num %2 == 0) {
                count += num;
            } else {
                count += (num -1);
                if (!single) {
                    count++;
                    single = true;
                }
            }
        }
        
        return count;
    }

    /**
     * LeetCode 
     */
    public int Nice_longestPalindrome(String s) {
    	int[] m = new int[128];
    	for(int i=0; i < s.length(); i++) {
    		m[s.charAt(i)]++; //Core. 映射关系
    	}
    	
    	int cur = 0;
    	int res = 0;
    	for (int i = 'A'; i <= 'z'; i++) {
    		if(m[i] > 0) {
    			if(m[i] %2 == 0) {
    				res += m[i];
    			} else {
    				res += m[i] -1;
    				cur =1;
    			}
    		}
    	}
    	
    	return res +cur;
    }
}
