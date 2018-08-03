package com.zoran.leetcode.simple5;

import java.util.Stack;

/**
 * �������
 * https://leetcode-cn.com/submissions/detail/5029671/
 * 
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/79998926
 * 
 * 'C''D''+' ��������������һ�ε÷ֲ����Ĺ�ϵ����, ������ֱ�ӶԵ÷��������д���. 
 * ���Կ�����ջ��������һ�β����ĺ�������
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
					int secondNumber = stack.pop(); //Nice: �ȵ���,��¼����,���ƽ�stack��
					int firstNumber = stack.peek();
					stack.push(secondNumber);
					stack.push(firstNumber+secondNumber);
					break;
				}
			} else {
				stack.push(Integer.valueOf(str)); //Nice: �ַ�ת����
			}
		}
		
		int sum = 0;
		while (!stack.empty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
