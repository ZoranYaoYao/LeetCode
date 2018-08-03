package com.zoran.leetcode.simple5;

/**
 * �ظ������ַ���ƥ��
 * https://leetcode-cn.com/submissions/detail/5033082/
 * 
 * [Solution]
 * https://blog.csdn.net/Miss_yuki/article/details/80943684
 * 
 * ��֤��:
 * A��B�ĳ��� <= A.length() *(num�� +1)
 */
public class Test153 {
	public static void main(String[] args) {
		Test153 test153 = new Test153();
		System.out.println(test153.repeatedStringMatch_U1("aaac", "aac"));
	}
	/**
		"aaac"
		"aac"
	 */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder(A);
        int count = 1;
        while(sb.length() < B.length()) { //�ó���������
            sb.append(A);
            count++;
        }

        int startIndex = A.indexOf(B.substring(0,1));
        if(sb.length() - startIndex < B.length()) {
        	sb.append(A);
            count++;
        }
        
        String str = sb.toString();

        
        return str.contains(B) ? count : -1;
    }

    /**
		"abcabcabcabc"
		"abac"
		��ʱ 
		�㷨����, 
     */
    public int repeatedStringMatch_U1(String A, String B) {
    	if(A.contains(B)) return 1;
    	
        int indexB = 0; int count =1;
        while (A.length() *count < B.length()) {
            for(int i =0; i < A.length(); i++) {
                if(A.charAt(i) == B.charAt(indexB)) {
                    indexB++;
                } else if(!A.contains(B.charAt(indexB)+"")){
                    return -1;
                } else {
                    indexB = 0;
                }
                
                if(indexB == B.length()) {
                    return count;
                }
            }
            count++;
        }
        
        return -1; 
    }

    public int Nice_repetedStringMath(String A, String B) {
    	int count =0;
    	StringBuilder sb = new StringBuilder();
    	while (sb.length() < B.length()) {
    		sb.append(A);
    		count++;
    	}
    	
    	if(sb.toString().contains(B)) {
    		return count;
    	} else if (sb.append(A).toString().contains(B)) {  //Nice: �����һ�ε����������
    		return count + 1;
    	} else {
    		return -1;
    	}
    }
    
}
