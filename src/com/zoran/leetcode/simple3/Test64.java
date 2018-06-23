package com.zoran.leetcode.simple3;

/**
 * ��һ������İ汾
 * https://leetcode-cn.com/submissions/detail/3431073/
 * 
 * [Solution]
 * https://blog.csdn.net/CriminalCode/article/details/68957310 {Note: ���͵Ķ��ֲ��ҷ����Ǳ�׼�ĸ�ʽ}
 */
public class Test64 {
	public static void main(String[] args) {
		System.out.println(firstBadVersion(5));
	}

	/**
	 * ��ʱ: 2126753390 1702766719
	 */
	public static int firstBadVersion(int n) {
		//�۰�
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
				//�ҵ�����
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
	 * Core: ���޶��ֲ���, ����Ǹ���������, ���� �ṹһ����false...false,true,true,...true.
	 * ����Ҫ���߱���: ��ΪҪ�ҵ��м��Ǹ�trueֵ�İ취����, ���ޱ������м���Ǹ���
	 * 
	 * û���õ�ת�۵�ĸ���
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
