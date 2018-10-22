package com.zoran.leetcode.medium3;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ���������� II
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
		//�ҹ���, ֻ����һ������ �Ͷ��������
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
				num = num*10+s.charAt(i)-'0';  //Nice.Core ͨ��ѭ��ȥ��ȡÿ��char��ֵ,���ҽ���һ��num��ֵ ���� num*10 + s.charAt(i) - '0';

			if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1)
			{
				if(sign=='-')
					stack.push(-num); //Core. �����ַ�, �Ÿ���

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

