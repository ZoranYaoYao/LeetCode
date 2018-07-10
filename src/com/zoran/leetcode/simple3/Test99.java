package com.zoran.leetcode.simple3;

/**
 * ÖØ¸´µÄ×Ó×Ö·û´®
 * https://leetcode-cn.com/submissions/detail/3993798/
 */
public class Test99 {
	public static void main(String[] args) {
		System.out.println(repeatedSubstringPattern("ab"));
	}
	
	public static boolean repeatedSubstringPattern(String s) {
		for(int i =0; i < s.length()/2; i++) {  //Core. ÅÐ¶Ï×Ö·û´®×Ó´®Ò»°ëµÄ¾àÀë
			String tmp = s.substring(0,i+1);
			int count = i+1;
			for(int j =0;j < s.length(); j+=count) {
				if(j+count <= s.length()) {
					String sub = s.substring(j,j+count);
					if(!tmp.equals(sub)) {
						break;
					}

					if(j+count == s.length()) {
						return true;
					}    
				}
			}
		}
		return false;
	}
}