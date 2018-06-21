package com.zoran.leetcode.simple2;

import java.util.LinkedList;

/**
 * 有效的字母异位词
 * https://leetcode-cn.com/submissions/detail/3363265/
 */
public class Test59 {
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}
	
	/**
	 * one
	 */
    public static boolean isAnagram(String s, String t) {
        LinkedList<Character> list1 = new LinkedList<>();
        char[] chr = s.toCharArray();
        for(int i = 0; i < chr.length; i++) {
            list1.add(chr[i]);
        }
        
        LinkedList<Character> list2 = new LinkedList<>();
        chr = t.toCharArray();
        for(int i = 0; i < chr.length; i++) {
            list2.add(chr[i]);
        }
        
        while(!list1.isEmpty()) {
            char item = list1.get(0);
            if(list2.contains(item)) {
                list1.pop();
                list2.remove((Character)item);
            } else {
                return false;
            }
        }
        
        if(list1.isEmpty() && list2.isEmpty()) return true;
        
        return false;
    }

}
