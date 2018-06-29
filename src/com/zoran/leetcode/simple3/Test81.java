package com.zoran.leetcode.simple3;

import java.util.LinkedList;

/**
 * 第N个数字
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
	 * 算法不对 
	 */
	public static int findNthDigit(int n) {        
		int i = 1; int startIndex = 1;  //Core. i代表数的位数
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

		int delta = n - startIndex; //开始位置10 也要数数1
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
    	while (n > digitNum*digitType) { //Core. 找准n的位置
    		n -= digitNum*digitType;
    		digitType++;
    		digitNum *= 10;
    	}
    	
    	int indexInsubRange = (n -1) / digitType; //Core. n-1 结合Math.pow(10, digitType -1).表示把10也算进去,使其获得正确的索引值.如果11 则2
    	int indexInNum = (n -1) % digitType; //Core. n-1 
    	int num = (int) (Math.pow(10, digitType -1) +indexInsubRange);
    	int result = Integer.parseInt((""+num).charAt(indexInNum)+"");
    	return result;
    }
}
