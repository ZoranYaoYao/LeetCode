package com.zoran.leetcode.simple5;

/**
 * 旋转字符串
 * https://leetcode-cn.com/submissions/detail/5568145/
 */
public class Test181 {

    public boolean rotateString(String A, String B) {
        if(A.equals(B)) return true;
        
        String temp = A;
        int startIndex=0;
        while (startIndex < temp.length()) {
            if (temp.equals(B)) return true;
            
            temp = temp.substring(1, temp.length()) + temp.substring(0,1); //问题:产生多个字符串
            startIndex++;
        }
        
        return false;
    }
    
    public boolean Nice_rotateString(String A, String B) {
    	StringBuilder sb = new StringBuilder(A);
    	if(sb.length() ==0 &&  B.length()==0) return true;
    	
    	if(sb.length() == B.length()) {
    		for (int i=0; i<sb.length(); i++) {
    			if(sb.toString().equals(B)) return true;
    			
    			sb.append(sb.charAt(0)); //Core. 添加
    			sb.deleteCharAt(0); //Core.  删除方法
    		}
    	}
    	
    	return false;
    }
}
