package com.zoran.leetcode.simple3;

/**
 * ��λ���
 * https://leetcode-cn.com/submissions/detail/3404402/
 */
public class Test61 {

	public static void main(String[] args) {
		System.out.println(addDigits(8));
	}
	
    public static int addDigits(int num) {
        int count = num;
         while(count > 10) {
        	 count = 0;  //core: ÿ��count����ʼ��
             while(num > 0){
                 count += num % 10;
                 num = num / 10;
             }
             num = count; //core num�Ľ�����г�ʼ��
         }
         
         return count;
     }
}
