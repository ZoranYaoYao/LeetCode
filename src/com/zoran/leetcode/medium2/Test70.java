package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * �ָ���Ĵ�
 *https://leetcode-cn.com/submissions/detail/7569048/
 */
public class Test70 {
	public static void main(String[] args) {
		Test70 test70 = new Test70();
		List<List<String>> aa = test70.partition("aab");
		System.out.println(aa);
	}
	
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        //���ݷָ�ÿ�ֿ��ܳ��ȵĿ������
        res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        
        backTrace(s,new ArrayList<String>(), 0);
        return res;
    }
    
    public void backTrace(String s, List<String> list, int startIndex) {
        if (startIndex == s.length()) {
            res.add(new ArrayList<String>(list));
        } else {
           for(int i=startIndex; i<=s.length()-1; i++) {
               String temp = s.substring(startIndex, i+1);
               if(isPalindrome(temp)) {
                   list.add(temp);
                   backTrace(s, list, i+1);
                   list.remove(list.size()-1);  //CCore. ����д��list.remove(temp) , ��ΪҪд���Ƴ���ӵ��Ǹ�Ԫ��
               }
           } 
        }
    }
    
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return s.equals(sb.reverse().toString());
    }
}
