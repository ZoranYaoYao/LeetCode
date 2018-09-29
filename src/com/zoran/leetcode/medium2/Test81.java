package com.zoran.leetcode.medium2;

import java.util.LinkedList;

/**
 * �沨��ʽ: ���ź�׺���ʽ
 * https://leetcode-cn.com/submissions/detail/7703909/
 * 
 * LinkedList ջ���÷�
 * push() pop()
 */
public class Test81 {

	public int evalRPN(String[] tokens) {
		//�沨��ʽ: ���ź�׺���ʽ
		//��ջ��������, ջ�����������ȼ���
		//����Ƿ���ʱ, �������ֽ��м���

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
