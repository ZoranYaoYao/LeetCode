package com.zoran.leetcode.simple5;

/**
 * ��֤�����ַ��� ��
 * https://leetcode-cn.com/submissions/detail/4982739/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80291760
 * https://blog.csdn.net/regemc/article/details/80601579
 * 
 * ɾ��һ���ַ�֮��(��������ߵ�,Ҳ�������ұߵ�), Ȼ���ڽ��л����ж�
 */
public class Test151 {
	
	public static void main(String[] args) {
		Test151 test151 = new Test151();
		boolean flag = test151.validPalindrome("abca");
		System.out.println(flag);
	}
	
	//�㷨����, ���ı������ɾ����ߵ��ַ�, Ҳ������ɾ���ұߵ��ַ�
    public boolean validPalindrome(String s) {
        String revers = new StringBuilder(s).reverse().toString();
        
        int count =1;;
        for(int i=0,index = 0; i< s.length()/2; i++,index++) {
            while(s.charAt(i) != revers.charAt(index)) {
                index++;
                count--;
                if(count <0) return false;
            }
        }
        return true;
    }

    public boolean Nice_validPalindrome(String s) {
    	int i=-1;int j = s.length();
    	while (++i < --j) {
    		if(s.charAt(i) != s.charAt(j)) {
    			return isPalindrome(s, i, j-1) || isPalindrome(s, i+1, j);
    		}
    	}
    	
    	return true;
    }
    
    public boolean isPalindrome(String s, int i, int j) {
    	while (i < j) {
    		if(s.charAt(i++) != s.charAt(j--)) return false;
    	}
    	return true;
    }
}
