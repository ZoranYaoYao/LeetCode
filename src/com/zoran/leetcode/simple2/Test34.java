package com.zoran.leetcode.simple2;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * ��Сջ
 * https://leetcode-cn.com/submissions/detail/2931700/ 
 */
public class Test34 {

	public static void main(String[] args) {
		//		["MinStack","push","push","push","getMin","pop","top","getMin"]
		//				[[],[-2],[0],[-3],[],[],[],[]]
		//		MinStack stack = new MinStack();
		//		stack.push(-2);
		//		stack.push(0);
		//		stack.push(-3);
		//		stack.getMin();
		//		stack.pop();
		//		stack.top();
		//		System.out.println(stack.getMin());

		//		["MinStack","push","push","top","getMin","pop","getMin","top"]
		//				[[],[1],[2],[],[],[],[],[]]
	}

	/**
	 * ÿ�ε���ʵ��ʱ, ��ȥ��������
	 * ִ��Ч�ʺܵ� : ʱ��452ms
	 */
	static class MinStack {
		int minNum = Integer.MAX_VALUE;
		LinkedList<Integer> list;
		/** initialize your data structure here. */
		public MinStack() {
			list = new LinkedList<>();
		}

		public void push(int x) {
			list.add(x);
			for(int item: list) {
				if(x <= minNum) minNum = x;
			}
		}

		public void pop() {
			int tmp = list.pollLast();
			if(tmp == minNum) {
				minNum = Integer.MAX_VALUE;
				for(int item: list) {
					if(item <= minNum) minNum = item;
				}
			}
		}

		public int top() {
			return list.peekLast();
		}

		public int getMin() {
			return minNum;
		}
	}


	static class Nice_MinStack{
		private Stack<Integer> s1 = new Stack<>();
		private Stack<Integer> s2 = new Stack<>();

		/** initialize your data structure here. */
		public Nice_MinStack() {}

		public void push(int x) {
			s1.push(x);
			if (s2.isEmpty() || s2.peek() >= x) s2.push(x);
		}

		public void pop() {
			// Cannot write like the following:
			// if (s2.peek() == s1.peek()) s2.pop();
			// s1.pop();
			int x = s1.pop();
			if (s2.peek() == x) s2.pop(); //�����ظ�ʱ,stack��Ŷ������,����Ҫ���ݵ�˳��
		}

		public int top() {
			return s1.peek();
		}

		public int getMin() {
			return s2.peek(); //core ��һ��stack��ջ ������Сֵ, ���ñ������ж�ջ
		}
	}
}
