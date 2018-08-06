package com.zoran.leetcode.simple5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 计数二进制子串
 * https://leetcode-cn.com/submissions/detail/5169970/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80291791
 * 
 * 经典解法
 */
public class Test158 {
	public static void main(String[] args) {
		Test158 test158 = new Test158();
		System.out.println(test158.Nice_countBinarySubstrings("000111000"));
	}

	/**
	 * matcher匹配  -> 超时
	 */
    public int countBinarySubstrings(String s) {
        int count =0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        boolean flag = true;
        do {
            int temp = 0;
        	sb.insert(0, "1");sb.insert(sb.length(), "0");
            Pattern pattern = Pattern.compile(sb.toString());
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()) {
            	temp++;
            }
            if(temp != 0) {
            	count += temp;
            } else {
            	flag = false;
            }
        } while (flag);
        
        boolean flag2 = true;
        do {
            int temp2= 0;
        	sb2.insert(0, "0");sb2.insert(sb2.length(), "1");
            Pattern pattern = Pattern.compile(sb2.toString());
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
            	temp2++;
            }
            if(temp2 != 0) {
            	count += temp2;
            } else {
            	flag2 = false;
            }
        } while (flag2);
        
        return count;
    }

    public int Nice_countBinarySubstrings(String s) {
    	char[] chars = s.toCharArray();
    	int len = chars.length;
    	int[] group = new int[len];
    	int index =0;
    	group[0] =1;
    	for(int i =0; i<len-1; i++) {
    		if(chars[i] != chars[i+1]) {
    			group[++index] =1; //Core. 
    		} else {
    			group[index]++;
    		}
    	}
    	int res =0;
    	for(int i=0;i<index; i++) {
    		res = res + Math.min(group[i], group[i+1]); //Nice. 求取每组的最小值
    	}
    	return res;
    }
}
