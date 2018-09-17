package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ԭIP��ַ
 * https://leetcode-cn.com/submissions/detail/7195920/
 */
public class Test52 {
	
	public static void main(String[] args) {
		Test52 test52 = new Test52();
		List<String> res = test52.restoreIpAddresses("0000");
		System.out.println(res);
	}

    public List<String> restoreIpAddresses(String s) {
        //�����㷨, ÿ��ȡ�ķ�ΧΪ1-3���ַ�, ����ѡ�����ʵĽ��ֵ
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        
        char[] chrs = s.toCharArray();
        backTrace(res, chrs, new StringBuilder(), 0, 0);
        
        return res;
    }
    
    //countΪ4�˳�
    public void backTrace(List<String> res, char[] chrs, StringBuilder sb, int startIndex, int count) {
        if(count >= 4) {
//            System.out.println(sb);
            if (startIndex < chrs.length) return; //Core. startIndex����һ��Ԫ�صĿ�ʼλ��, ���������chrs�ĳ���, ������Ԫ�ض��Ѿ�ȡ��,Ȼ���˳�
            String string = sb.toString();
            res.add(string.substring(0, string.length()-1));
        } else {
            for(int i=1; i<=3; i++) {
            	if(startIndex + i > chrs.length) continue;//255 255 111 35 ,��������ַ�����ı߽�
                String str = new String(chrs, startIndex, i); 
                if(str.startsWith("0") && str.length()>1)  continue; //["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0",  0������
                if(Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255) {
                    sb.append(str).append(".");
//                    System.out.println(sb);
                    backTrace(res, chrs, sb, startIndex+i, ++count);
                    sb.delete(sb.lastIndexOf(str), sb.length());   //ɾ����������, delete(int start, int end) , ��֤���˵õ�ԭ����λ��
//                    System.out.println("delete: " +sb); //delete: 2.525.
                    count--;
                }
            }
        }
    }
}
