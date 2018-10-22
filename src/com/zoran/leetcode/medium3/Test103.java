package com.zoran.leetcode.medium3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 基本计算器 II
 * https://leetcode-cn.com/submissions/detail/8528151/
 * 
 * [Nice_code]
 * LeetCode
 */
public class Test103 {

	public static void main(String[] args) {
		Test103 test103 = new Test103();
		int res = test103.calculate("0-2147483647");
		System.out.println(res);
	}

	int curIndex =0;
	public int calculate(String s) {
		//找规律, 只存在一级运算 和二级运算符
		if (s == null || s.length() == 0) return 0;

		s = s.replace(" ","");
		LinkedList<String> stack = new LinkedList<>();
		while(curIndex != s.length()) {
			String res = getNumberOrOperator(s);
			if (res.equals("*") ) {
				int number = Integer.valueOf(stack.pop());
				int number2 = Integer.valueOf(getNumberOrOperator(s));
				stack.push("" + (number * number2)); 
				continue;
			} else if (res.equals("/")) {
				int number = Integer.valueOf(stack.pop());
				int number2 = Integer.valueOf(getNumberOrOperator(s));
				stack.push("" + (number / number2)); 
				continue;
			}

			stack.push(res);
		}

		int res = 0;
		res += Integer.valueOf(stack.pollLast());
		while(!stack.isEmpty()) {
			String operator = stack.pollLast();
			int temp = Integer.valueOf(stack.pollLast());
			if (operator.equals("+")) res += temp;
			if (operator.equals("-")) res -= temp;
		}

		return res;

	}

	private String getNumberOrOperator(String s) {
		StringBuilder res = new StringBuilder();
		if (s.charAt(curIndex) < '0' || s.charAt(curIndex) > '9') return res.append(s.charAt(curIndex++)).toString();

		while(curIndex<s.length() && s.charAt(curIndex) >= '0' && s.charAt(curIndex)<= '9') {
			res.append(s.charAt(curIndex++));
		}

		return res.toString();
	}
}

class LeetCode_Test103 {
	public int calculate(String s)
	{
		int len;
		if(s==null || (len = s.length())==0) 
			return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for(int i=0;i<len;i++)
		{
			if(Character.isDigit(s.charAt(i)))
				num = num*10+s.charAt(i)-'0';  //Nice.Core 通过循环去获取每个char的值,并且将上一个num的值 等于 num*10 + s.charAt(i) - '0';

			if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1)
			{
				if(sign=='-')
					stack.push(-num); //Core. 负数字符, 放负数

				if(sign=='+')
					stack.push(num);

				if(sign=='*')
					stack.push(stack.pop()*num);

				if(sign=='/')
					stack.push(stack.pop()/num);

				sign = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for(int i:stack)
			re += i;

		return re;
	}


}

