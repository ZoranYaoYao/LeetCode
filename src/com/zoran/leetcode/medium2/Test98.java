package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和 III
 * https://leetcode-cn.com/submissions/detail/8154334/
 * 
 * 回溯的遍历索引值, 注意一下
 */
public class Test98 {
	
	public static void main(String[] args) {
		Test98 test98 = new Test98();
		List<List<Integer>> res = test98.combinationSum3(3, 7);
		System.out.println(res);
	}

    public List<List<Integer>> combinationSum3(int k, int n) {
        //回溯法: 尝试每一种可能, 长度为k
        List<List<Integer>> res = new ArrayList<>();
        backTrace(res, new ArrayList<Integer>(), k, n, 0, 0, 1);
        return res;
    }
    
    public void backTrace(List<List<Integer>> res, List<Integer> list, int len, int count, int curLen, int curCount, int index) {
        if (curLen == len && curCount != count) return;
        if (curLen != len && curCount == count) return;
        if (curLen == len && curCount == count) {
            res.add(new ArrayList<Integer>(list)); 
            return;
        }        
        
        for(int i = index; i<=9; i++) {
            list.add(i);
            curCount+= i;
            backTrace(res, list, len, count, ++curLen, curCount, i+1); //Core. 错误index+1, 改正:i+1, index只是一个初始值, i+1才是下一个真正的起始索引值
            //restore variable
            list.remove((Integer) i);
            curLen--;
            curCount -= i;
        }
    }
}
