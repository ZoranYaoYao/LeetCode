package com.zoran.leetcode.medium2;

import java.util.LinkedList;

/**
 * 逆波兰式: 符号后缀表达式
 * https://leetcode-cn.com/submissions/detail/7703909/
 * 
 * LinkedList 栈的用法
 * push() pop()
 */
public class Test81 {

	public int evalRPN(String[] tokens) {
		//逆波兰式: 符号后缀表达式
		//用栈保存数字, 栈顶的数字最先计算
		//如果是符号时, 弹出数字进行计算

		if (tokens == null || tokens.length == 0) return 0;
		LinkedList<Integer> list = new LinkedList<>();
		for (String item : tokens) {
			boolean isSymbol = item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/");
			if (isSymbol) {
				int num2 = list.pop();
				int num1 = list.pop();
				switch (item) {
				case "+":
					list.push(num1+num2);
					break;
				case "-":
					list.push(num1-num2);
					break;
				case "*":
					list.push(num1*num2);
					break;
				case "/":
					list.push(num1/num2);
					break;
				}
			} else {
				list.push(Integer.parseInt(item));
			}
		}
		return list.pop();
	}
}
