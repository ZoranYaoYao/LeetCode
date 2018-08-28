package com.zoran.leetcode.medium;

/**
 * БЅКэПаіэ
 * https://leetcode-cn.com/submissions/detail/6151882/
 */
public class Test15 {

    public int divide(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        return dividend / divisor;
    }
}
