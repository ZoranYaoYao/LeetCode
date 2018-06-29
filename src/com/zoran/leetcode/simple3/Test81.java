package com.zoran.leetcode.simple3;

import java.util.LinkedList;

/**
 * ��N������
 * https://leetcode-cn.com/submissions/detail/3612519/
 * 
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/52575028
 */
public class Test81 {
	public static void main(String[] args) {
		System.out.println(Nice_findNthDigit(10));
	}

	/**
	 * �㷨���� 
	 */
	public static int findNthDigit(int n) {        
		int i = 1; int startIndex = 1;  //Core. i��������λ��
		while(true) {
			int item = (int) (i * (Math.pow(10,i) - Math.pow(10,i-1)));
			startIndex += item;
			i++;
			if(n<startIndex) {
				startIndex -= item;
				i--;
				break;
			}
		}

		int delta = n - startIndex; //��ʼλ��10 ҲҪ����1
		int number = startIndex + delta / i;
		LinkedList<Integer> stack = new LinkedList<>();                           
		while (number > 0) {
			int yu = number % 10;
			stack.push(yu);
			number = number /10;
		}                      
		int location = delta % i; //Core.
		return stack.get(location);
	}


    public static int Nice_findNthDigit(int n) {
    	int digitType = 1;
    	long digitNum = 9;
    	while (n > digitNum*digitType) { //Core. ��׼n��λ��
    		n -= digitNum*digitType;
    		digitType++;
    		digitNum *= 10;
    	}
    	
    	int indexInsubRange = (n -1) / digitType; //Core. n-1 ���Math.pow(10, digitType -1).��ʾ��10Ҳ���ȥ,ʹ������ȷ������ֵ.���11 ��2
    	int indexInNum = (n -1) % digitType; //Core. n-1 
    	int num = (int) (Math.pow(10, digitType -1) +indexInsubRange);
    	int result = Integer.parseInt((""+num).charAt(indexInNum)+"");
    	return result;
    }
}
