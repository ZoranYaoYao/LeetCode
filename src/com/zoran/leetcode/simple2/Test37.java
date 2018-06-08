package com.zoran.leetcode.simple2;

/**
 * 168. Excel表列名称
 * https://leetcode-cn.com/problems/excel-sheet-column-title/description/
 * 
 * [Solution]
 * https://blog.csdn.net/u010183658/article/details/50947405
 */
public class Test37 {

	/**
	 * 问题: 26进行,偶次幂的时候的显示
	 */
//    public String convertToTitle(int n) {
//        int tmp = 0; //除数
//        List<Integer> list = new LinkedList<>();
//        while (tmp = (n / 26) > 0) {
//            int mod = n % 26; //余数
//            list.add(mod);
//            n = tmp;
//        }
//        
//        while(list.peekLast() != null) {
//            
//        }
//    }
    
    public String Nie_convertToTitle(int n) {
    	String str = new String();
    	while(n > 0) {
    		int mod = (n-1) % 26;
    		str = (char) ('A' +mod) + str;
    		n = (n-1) / 26;
    	}
    	
    	return str;
    }
    
    /**
     * 26进制数的 正确求余逻辑
     */
    public String LeetCode_convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int mod = n % 26;
            char c = mod == 0 ? 'Z' : (char)('A' + mod - 1); // 数字 转换对应的char值
            sb.append(c);
            n -= (mod == 0 ? 26 : mod); //core!!!: 除数 - 余数 =  26的整数倍 比如: 27 * 26;方便(下一位!!)的计算
            n /= 26;
        }
        return sb.reverse().toString(); //Sring 反序
    }
}
