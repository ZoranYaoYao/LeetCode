package com.zoran.leetcode.simple3;

/**
 * 第一个错误的版本
 * https://leetcode-cn.com/submissions/detail/3431073/
 * 
 * [Solution]
 * https://blog.csdn.net/CriminalCode/article/details/68957310 {Note: 博客的二分查找法不是标准的格式}
 */
public class Test64 {
	public static void main(String[] args) {
		System.out.println(firstBadVersion(5));
	}

	/**
	 * 超时: 2126753390 1702766719
	 */
	public static int firstBadVersion(int n) {
		//折半
		int left = 1, right = n;
		boolean preVersionisBad = isBadVersion(n);
		int preNum = n;
		int middle = 0;
		while(left <= right) {
			middle = (left + right) /2 ;
			if(preVersionisBad && isBadVersion(middle)) {
				right = middle -1;
				preVersionisBad = true;
				preNum = middle;
			} else if(!preVersionisBad && !isBadVersion(middle)){
				left = middle +1;
				preVersionisBad = false;
				preNum = middle;
			} else if (preVersionisBad && !isBadVersion(middle)) {
				//找到区间
				preNum = middle;
				break;
			}
		}

		for(int i = preNum; i <= n; i++) {
			if(isBadVersion(i)) return i;
		}

		return middle;
	}

	/**
	 * Core: 无限二分查找, 最后那个数的零界点, 就是 结构一定是false...false,true,true,...true.
	 * 必须要无线遍历: 因为要找到中间那个true值的办法就是, 无限遍历找中间的那个数
	 * 
	 * 没有用到转折点的概念
	 */
	public static int Nice_firstBadVersion(int n) {
		int left = 1, right = n, middle = 0;
		while(left <= right) {
			middle = left + (right - left) /2;  //core
			if (isBadVersion(middle)) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		
		return left;
	}
	
	private static boolean isBadVersion(int n) {
		switch (n) {
		case 1:
			return false;
		case 2:
			return false;
		case 3:
			return false;
		case 4:
			return true;
		case 5:
			return true;
		}
		return false;
	}
}
