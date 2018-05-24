package com.zoran.leetcode;
/**
 * x 的平方根
 * https://leetcode-cn.com/submissions/detail/2564411/
 */
public class Test15 {
	public static void main(String[] args) {
		//实现 int sqrt(int x) 函数。
		//System.out.println(mySqrt2(2147395600));
		System.out.println(mySqrt3(8)); //超时
	}
	
	
	public static int mySqrt3(int x) {
		if (x ==1) {
			return 1;
		} else if(x == 0) {
			return 0;
		}
		
		int left = 0; int right =x;
		int middle = 0;
		//从0开始对比
		while(left <= right) {  //折半查找,遍历已有的数组, 所以当到达数组边界时,也要进行对比 ,所以要有等号,即 left <= right
			middle = (left + right)/2;
			if(x/middle > middle) {   //core, int整形相乘会出现溢出. , 用除法形式对比
				left = middle + 1;
			} else if(x/middle < middle) {
				right = middle -1;
			}else {
				return middle;
			}
		}
		
		//没有查找到相等的数
		if(middle * middle > x) {
			return middle = middle -1;
		} 
		
		return middle;
		
	}

	//fail  折半个数
	public static int mySqrt2(int x) {
		if (x ==1) {
			return 1;
		}

		//折半元素个数, 
		int lenght = String.valueOf(x).length();
		int startNum = (int) Math.pow(10, (lenght/2-1));
		int resultSqr = startNum * startNum;

		while(resultSqr > x) {
			startNum--;
			resultSqr = startNum * startNum;
		}
		
		//穷举
		for(startNum = startNum +1; startNum*startNum < x; startNum++) {
			if (startNum*startNum > x) {
				break;
			}
		}
		
		//差一处理
		if (startNum*startNum == x) {
			return startNum;
		}else {
			return startNum -1;
		}


	}

	//fail  折半数字,middle*middle 越界问题 -> 用除法 !
	public static int mySqrt(int x) {
		if (x ==1) {
			return 1;
		}

		//折半元素个数, 
		int middle = x/2;

		/***/
		//int middleSqr = middle*middle;  //zqs. int,long越界
		while (middle*middle < 0) {
			middle = middle/2;
		}
		int middleSqr = middle*middle;
		/***/

		while(middleSqr > x) {
			middle = middle/2;
			middleSqr =middle*middle;
		}

		//折半之后,在穷举
		for(int i = middle +1; middle < x; i++) {
			if (i*i <= x) {
				middle = i;
			} else {
				break;
			}
		}

		return middle;
	}
}
