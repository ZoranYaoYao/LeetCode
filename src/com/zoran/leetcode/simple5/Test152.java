package com.zoran.leetcode.simple5;

import java.util.Stack;

/**
 * 棒球比赛
 * https://leetcode-cn.com/submissions/detail/5029671/
 * 
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/79998926
 * 
 * 'C''D''+' 操作都是依赖上一次得分操作的关系处理, 并不对直接对得分总数进行处理. 
 * 所以可以用栈来处理上一次操作的后续操作
 */
public class Test152 {

	public int Nice_calPoint(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		for (String str: ops) {
			char c = str.charAt(0);
			if(c == 'C' || c == 'D' || c == '+') {
				switch (c) {
				case 'C':
					stack.pop();
					break;
				case 'D':
					stack.push(stack.peek()*2);
					break;
				case '+':
					int secondNumber = stack.pop(); //Nice: 先弹出,记录本地,在推进stack中
					int firstNumber = stack.peek();
					stack.push(secondNumber);
					stack.push(firstNumber+secondNumber);
					break;
				}
			} else {
				stack.push(Integer.valueOf(str)); //Nice: 字符转整形
			}
		}
		
		int sum = 0;
		while (!stack.empty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
