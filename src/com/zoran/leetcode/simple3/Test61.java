package com.zoran.leetcode.simple3;

/**
 * 各位相加
 * https://leetcode-cn.com/submissions/detail/3404402/
 */
public class Test61 {

	public static void main(String[] args) {
		System.out.println(addDigits(8));
	}
	
    public static int addDigits(int num) {
        int count = num;
         while(count > 10) {
        	 count = 0;  //core: 每次count都初始化
             while(num > 0){
                 count += num % 10;
                 num = num / 10;
             }
             num = count; //core num的结果进行初始化
         }
         
         return count;
     }
}
