package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 重复的DNA序列
 * https://leetcode-cn.com/submissions/detail/8019561/
 * 
 * [Solution]
 * https://blog.csdn.net/ConnieWu/article/details/80244634
 * 
 * 题意不明确
 */
public class Test90 {
	public static void main(String[] args) {
		Test90 test90 = new Test90();
		List<String> list = test90.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		System.out.println(list);
	}

    public List<String> findRepeatedDnaSequences(String s) {
        //穷举查找
        List<String> res = new ArrayList<>();
        if(s == null || s.length() <20) return res;
        Set<String> set = new HashSet<>();
        for(int i=0; i+10<=s.length(); i++) {
            String temp = s.substring(i,i+10);
            if(s.lastIndexOf(temp) >= i+10) set.add(temp);
        }
        for (String item : set) res.add(item);
        return res;
    }
}
