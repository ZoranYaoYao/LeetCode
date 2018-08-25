package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * 电话号码的字母组合
 * https://leetcode-cn.com/submissions/detail/6044997/
 * 
 * [组合操作的算法]
 * 以前的旧集合作为参数 + 递归操作形成新集合
 * 
 * 组合操作的意义 就是在老的集合添加新的选项形成 新的集合
 */
public class Test10 {

	public static void main(String[] args) {
		Test10 test10 = new Test10();
		List<String> list = test10.letterCombinations("234");
		System.out.println(list);
		System.out.println(list.size());
	}

	String[] strCompent = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	String origin;
	List<StringBuilder> listSB = new ArrayList<>();
	public List<String> letterCombinations(String digits) {
		//组合所有可能性
		List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0) return result;
		origin = digits;
		int cur = 0;
		selectACharacter(listSB, Integer.parseInt(digits.charAt(cur)+""), cur);
		for(StringBuilder item: listSB) result.add(item.toString());
		return result;
	}

	//问题点: 字符如何递归组合
	public void selectACharacter(List<StringBuilder> old,int number,int next) {
		String str = strCompent[number];
		List<StringBuilder> list = new ArrayList<>();
		if(old.size() == 0) {
			for(int i=0; i<str.length(); i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(str.charAt(i));
				list.add(sb); //问题: sb不在最终字符串时,添加进来
			}
		} else {
			for(int i=0; i<str.length(); i++) {
				for(StringBuilder item: old) {
					StringBuilder sb = new StringBuilder(item.toString());
					sb.append(str.charAt(i));
					list.add(sb); //问题: sb不在最终字符串时,添加进来
				}
			}
		}

		next++;
		if(next <= origin.length()-1) {
			selectACharacter(list, Integer.parseInt(origin.charAt(next)+""), next);
		} else {
			listSB = list;
		}

	}
}
