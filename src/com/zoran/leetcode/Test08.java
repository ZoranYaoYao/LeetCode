package com.zoran.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 实现strStr()
 * https://leetcode-cn.com/submissions/detail/2313807/
 */
public class Test08 {
	public static void main(String[] args) {
		//haystack = "hello", needle = "ll"
		//System.out.println(strStr("helloll","ll"));
		System.out.println(strStr("aaaaa",""));
	}
	
	/**
	 * 1.通过正则表达式去获取符合规则的子串
	 * 2.用String indexof() 获取首次出现的子串
	 */
	public static int strStr(String haystack, String needle) {
		if(needle == null ) {
			return -1;
		} else if(needle.length() == 0) {
			return 0;
		}
		
		
        int index = -1; String subStr = null;
        Pattern pattern =Pattern.compile(needle);
        Matcher matcher = pattern.matcher(haystack);
        
        while(matcher.find()) {
        	subStr = matcher.group();  //返回首个匹配的子字符串
        	break;
        }
        
        if (subStr == null || subStr.length() == 0){
        	index = -1;
		} else {
        	index = haystack.indexOf(subStr);
		}
        
    	return index;
    }
	
	/**
	 * 匹配的字符串固定,所以可以直接截取
	 */
    public int Nice_strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
