package com.zoran.leetcode.simple3;

/**
 * ��ת�ַ���
 * https://leetcode-cn.com/submissions/detail/3546740/
 */
public class Test71 {

	/**
	 * ������������������໥����˳�� 
	 */
    public String reverseString(String s) {
        if(s == null) return null;
        if(s.equals("")) return "";
        
        char[] chr = s.toCharArray();
        for(int i = 0; i <= (chr.length -1)/2; i++) {
            char tmp =  chr[i];
            chr[i] = chr[chr.length-1-i];
            chr[chr.length-1-i] = tmp;
        }
        
        return new String(chr);
    }
}
