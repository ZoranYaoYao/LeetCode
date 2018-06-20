package com.zoran.leetcode.simple2;

/**
 * 2的幂
 * https://leetcode-cn.com/submissions/detail/3330581/
 */
public class Test54 {

	/**
	 * 2的幂次方 转换为二进制数表示,代表二进制数中只会存在一个1
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
