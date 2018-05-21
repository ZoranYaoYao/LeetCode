package com.zoran.leetcode;

import sun.security.util.Length;

/**
 * ��һ
 * https://leetcode-cn.com/submissions/detail/2468356/
 * 
 * https://www.cnblogs.com/beliveli/p/9016614.html
 */
public class Test13 {

	public static void main(String[] args) {
//		����: [1,2,3]
//		���: [1,2,4]
//		����: ���������ʾ���� 123��
		int[] arr = new int[] {9,8,7,6,5,4,3,2,1,0};
		//int[] arr = new int[] {9,9};
		for(int item: Nice_plusOne(arr)) {
			System.out.println(item);
		}
	}
	
	//������ʱ, ��Χ���
    public static int[] plusOne(int[] digits) {
    	int num = 0;
    	for(int i = 0; i< digits.length; i++) {
    		num += digits[i] * Math.pow(10, digits.length - i -1);
    	}
    	num = num + 1;
    	String string = String.valueOf(num);
    	int[] result = new int[string.length()];
    	
    	//[9,8,7,6,5,4,3,2,1,0] ͨ����
    	for(int j = 0; j < string.length(); j ++) {
    		result[j] = Integer.valueOf(string.substring(j, j+1));
    	}
    	return result;
    }
    
    /**
     * 1.�����ʼ��1
     * 2.������λ,������Ƚ��Ƿ��λ
     */
    public static int[] Nice_plusOne(int[] digits) {
        int carry = 1;
        for(int i=digits.length-1; i>=0; i--) {
            if(carry==0) { 
                return digits;
            }
            int tmp = digits[i] + carry; //�Ӹ�λ����ʼ +1
            carry = tmp / 10;  //��λ 1 , ����λ0 (ֻ��10/10 �Ż��λ, ���඼����0)
            digits[i] = tmp % 10;
        }
        if(carry!=0) { //���carry ��λ����Ϊ0, ���ʾҪ��λ
            int[] res = new int[digits.length+1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
