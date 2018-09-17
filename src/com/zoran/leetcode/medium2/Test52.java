package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 * https://leetcode-cn.com/submissions/detail/7195920/
 */
public class Test52 {
	
	public static void main(String[] args) {
		Test52 test52 = new Test52();
		List<String> res = test52.restoreIpAddresses("0000");
		System.out.println(res);
	}

    public List<String> restoreIpAddresses(String s) {
        //回溯算法, 每次取的范围为1-3个字符, 遍历选出合适的结果值
        List<String> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        
        char[] chrs = s.toCharArray();
        backTrace(res, chrs, new StringBuilder(), 0, 0);
        
        return res;
    }
    
    //count为4退出
    public void backTrace(List<String> res, char[] chrs, StringBuilder sb, int startIndex, int count) {
        if(count >= 4) {
//            System.out.println(sb);
            if (startIndex < chrs.length) return; //Core. startIndex是下一个元素的开始位置, 如果等于了chrs的长度, 则所有元素都已经取出,然后退出
            String string = sb.toString();
            res.add(string.substring(0, string.length()-1));
        } else {
            for(int i=1; i<=3; i++) {
            	if(startIndex + i > chrs.length) continue;//255 255 111 35 ,处理大于字符数组的边界
                String str = new String(chrs, startIndex, i); 
                if(str.startsWith("0") && str.length()>1)  continue; //["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10","0.10.01.0",  0的问题
                if(Integer.parseInt(str) >= 0 && Integer.parseInt(str) <= 255) {
                    sb.append(str).append(".");
//                    System.out.println(sb);
                    backTrace(res, chrs, sb, startIndex+i, ++count);
                    sb.delete(sb.lastIndexOf(str), sb.length());   //删除错误索引, delete(int start, int end) , 保证回退得到原来的位置
//                    System.out.println("delete: " +sb); //delete: 2.525.
                    count--;
                }
            }
        }
    }
}
