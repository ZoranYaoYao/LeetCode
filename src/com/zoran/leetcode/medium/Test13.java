package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 * https://leetcode-cn.com/submissions/detail/6119187/
 * 
 * [Solution]
 * https://leetcode-cn.com/problems/generate-parentheses/solution/
 * 
 * 递归生成选择的字符串数组 (类似二叉树的递归调用)
 */
public class Test13 {

	/**
	 * 暴力解决法 
	 */
	public List<String> Nice_generateParenthesis(int n) {
		List<String> combinations = new ArrayList<>();
		generateAll(new char[2*n], 0, combinations);
		return combinations;
	}

	private void generateAll(char[] current, int pos, List<String> result) {
		if(pos == current.length) {
			if(valid(current))
				result.add(new String(current));
		} else {
			current[pos] = '(';
			generateAll(current, pos+1, result); //Core. 类似左右子树遍历一样
			current[pos] = ')'; //Core. 当前pos+1的位置,可以是2种选择, 所以进行置换!
			generateAll(current, pos+1, result); 
		}
	}

	private boolean valid(char[] current) {
		int banlance = 0;
		for(char c: current) {
			if (c == '(') banlance++;
			else banlance--;
			if(banlance<0) return false;
		}
		
		return banlance==0;
	}
}
