package com.zoran.leetcode.simple2;

import java.util.function.IntConsumer;

/**
 * 位1的个数
 * https://leetcode-cn.com/submissions/detail/3117090/
 *  
 * >> << >>> 
 * https://www.cnblogs.com/hongten/p/hongten_java_yiweiyunsuangfu.html
 * [Solution]
 * https://blog.csdn.net/peiyao456/article/details/51724099
 */
public class Test43 {

	public static void main(String[] args) {
		//long num = Long.parseLong("2147483648");
		System.out.println(Nice_hammingWeight(-2));  //无符号位 溢出	
	}

	/**
	 * LeetCode 执行不过
	 */
	public static int hammingWeight(int n) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.append(n%2);
			n = n/2;
		}

		char[] charArray = sb.reverse().toString().toCharArray();
		int count = 0;
		for (char c : charArray) {
			if (c == '1') {
				count++;
			}
		}

		return count;
	}

	public static int hammingWeightOne(int n) {
		if (n == 0) return 0;  
		int result = 0;  
		while (n > 2) {  
			result += n % 2;  
			n =n / 2;  
		}  
		return result;  
	}

	public static int Error_hammingWeight(int n) {
		int count = 0;
		while (n != 0) {
			if((n & 1) == 1) {
				count++;
			}
			n = n >> 1; // -1 右移移位 还是等于 -1 , 死循环
		}
		return count;    //不能处理负数
	}

	public static int Nice_hammingWeight(int n) {
		int count = 0;  
		int i = 0;  
		for (i = 0;i < 32;i++){  
			if (((n >> i) & 1) == 1) {    //core n >> i, 直接移动多少位, 得到对应的值
				count++;  
			}  
		}  
		return count; 
	}

	public static int NNice_hammingWeight(int n) {
		int count = 0;  
		while (n != 0){  
			count++;  
			n = n & (n-1);   //core , 获取有1的位数,不用遍历循环
		}  
		return count;  
	}


}
