package com.zoran.leetcode.simple5;

/**
 * 1������2�����ַ�
 * https://leetcode-cn.com/submissions/detail/5310014/
 * 
 * �����ж����һ��������һ������, ����2������
 */
public class Test167 {

	   public boolean isOneBitCharacter(int[] bits) {
	        for(int i=0; i<bits.length; i++) {
	            if(bits[i] == 1) {
	                if(i == bits.length -2) return false; //Core. ���2������, ���ҳ����ڵ����ڶ�λ, ��ض���һ�����
	                i++;
	            } else if(bits[i] == 0){
	                //�������ֱ�� i++
	            }
	        }
	        
	        return true;
	    }
}
