package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母大小写全排列
 * https://leetcode-cn.com/submissions/detail/5523286/
 * 
 * [Solution]
 * https://blog.csdn.net/w8253497062015/article/details/80003706
 * 
 * 组合操作 -> 递归
 * 太nb
 */
public class Test179 {

	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		if(S.length() == 0) {
			result.add(""); return result;
		}
		
		helper(result, S.toCharArray(), 0);
	}

	//递归处理问题
	private void helper(List<String> result, char[] S, int i) {
		if (i >= S.length) {
			result.add(String.valueOf(S));
			return;
		}
		
		if(S[i] >= 'A' && S[i] <= 'Z') {
			S[i] += 32;  //Core. 先转换字母  , 后续转换回来之后, 在继续操作
			helper(result, S, i+1); 
			S[i] -= 32;
		} else if (S[i] >= 'a' && S[i] <= 'z') {
			S[i] -= 32;
			helper(result, S, i+1);
			S[i] += 32;
		}
		helper(result, S, i+1);
	}
}
