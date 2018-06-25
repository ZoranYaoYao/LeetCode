package com.zoran.leetcode.simple3;

import java.util.HashMap;
import java.util.Map;

/**
 * 单词模式
 * https://leetcode-cn.com/submissions/detail/3498115/
 */
public class Test66 {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog dog dog dog"));
	}
	
	/**
	 * 2个HashMap , 互相映射
	 */
    public static boolean wordPattern(String pattern, String str) {
        char[] chr = pattern.toCharArray();
        String[] strArr = str.split(" ");
        Map<Character,String> map = new HashMap<>();
        Map<String, Character> mutualMap = new HashMap<>();
        if(chr.length != strArr.length) return false;
        for(int i = 0; i < chr.length; i++) {
            if(map.get(chr[i]) ==null && mutualMap.get(strArr[i]) == null) {
                map.put(chr[i], strArr[i]);
                mutualMap.put(strArr[i], chr[i]);
            } else if (map.get(chr[i]) != null) { //已存在映射关系
            	if(!map.get(chr[i]).equals(strArr[i]))    return false;
            } else if (mutualMap.get(strArr[i]) != null) { //已存在映射关系
            	if(!mutualMap.get(strArr[i]).equals(chr[i])) return false;
            }
        }
        
        return true;
    }

}
