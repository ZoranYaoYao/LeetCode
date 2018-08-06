package com.zoran.leetcode.simple5;

/**
 * 交替位二进制数
 * https://leetcode-cn.com/submissions/detail/5164540/
 * 
 * 真正的一次提交
 */
public class Test156 {
	
    public boolean hasAlternatingBits(int n) {
        String str = Integer.toBinaryString(n);
        char[] chr = str.toCharArray();
        for(int i =1; i<chr.length; i++) {
            if(chr[i] == chr[i-1]) return false;
        }
        return true;
    }
}
