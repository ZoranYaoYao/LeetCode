package com.zoran.leetcode.simple2;

/**
 * 2����
 * https://leetcode-cn.com/submissions/detail/3330581/
 */
public class Test54 {

	/**
	 * 2���ݴη� ת��Ϊ����������ʾ,�������������ֻ�����һ��1
	 * one time
	 */
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            if (n%2 == 1) count++;
            n = n /2;
        }
        return count == 1 ? true: false;
    }
}
