package com.zoran.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/description/
 * 
 * 思路:
 * 1. 有对应规则 - > 用HashMap存储对应的值
 * 2. 罗马数字的规则是每次运算时,必须考虑后一个值的大小, 如果大于当前值则2个数字一起处理. 如果小于,直接加上当前数字
 * @author Zoran
 *
 */
public class Test02 {
	public static void main(String[] args) {
		System.out.println(romanToInt("MCMXCIV"));
	}

    public static int romanToInt(String s) {
    	int number = 0;
    	Map<Character, Integer> map = new HashMap<>();
    	getRule(map);
    	
    	for (int i = 0; i <= s.length() - 1; i++) {
    		int currentNumber = map.get(s.charAt(i));
    		if (i == s.length() -1) {
    			number += currentNumber;
				break;
			}
    		
    		int nextNumber = map.get(s.charAt(i+1));
    		if (currentNumber < nextNumber) {
    			number += nextNumber - currentNumber;
    			i++;
			} else {
				number += currentNumber;
			}

    	}
    	
        return number;
    }
    
    public static void getRule(Map<Character, Integer> map) {
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    }
    
}
