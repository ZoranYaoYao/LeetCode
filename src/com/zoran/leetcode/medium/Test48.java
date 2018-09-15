package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码
 * https://leetcode-cn.com/submissions/detail/7115538/
 * 
 * [Solution]
 * https://www.cnblogs.com/acbingo/p/9427661.html
 * https://blog.csdn.net/wutingyehe/article/details/51155231
 * 
 * 题意没有理解对 什么是格雷编码
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 */
public class Test48 {

    public List<Integer> grayCode(int n) {
        //1. 0最开始
        //2. 满足二进制位数为n 的十进制数
        
        int count = (int) Math.pow(2, n);
        int end = 1 << n;
        
        List<Integer> res = new ArrayList<>();
        res.add(0); //Core. 0开头
        for(int i=1; i<count; i++) {
            int temp = end-i;
            res.add(temp);
        }
        
        return res;
    }
}


class LeetCode_Test48 {
	
	public static void main(String[] args) {
		LeetCode_Test48 test48 = new LeetCode_Test48();
		List<Integer> res = test48.grayCode(3);
		System.out.println(res);
	}
	
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
       int len = 1 << n;
       for (int i = 0; i < len; i++) {
           list.add(i ^ (i >> 1)); //Nice. 异或
       }
       return list;
   }
}