package com.zoran.leetcode.simple3;

import java.util.HashMap;
import java.util.Map;

/**
 * ����ģʽ
 * https://leetcode-cn.com/submissions/detail/3498115/
 */
public class Test66 {
	public static void main(String[] args) {
		System.out.println(wordPattern("abba","dog dog dog dog"));
	}
	
	/**
	 * 2��HashMap , ����ӳ��
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
            } else if (map.get(chr[i]) != null) { //�Ѵ���ӳ���ϵ
            	if(!map.get(chr[i]).equals(strArr[i]))    return false;
            } else if (mutualMap.get(strArr[i]) != null) { //�Ѵ���ӳ���ϵ
            	if(!mutualMap.get(strArr[i]).equals(chr[i])) return false;
            }
        }
        
        return true;
    }

}
