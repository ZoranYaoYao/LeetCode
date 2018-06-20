package com.zoran.leetcode.simple2;

import java.util.LinkedList;

/**
 * 用栈实现队列
 * https://leetcode-cn.com/submissions/detail/3331011/
 */
public class Test55 {
	class MyQueue {

	    private LinkedList<Integer> list;
	    
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        list = new LinkedList<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        list.addLast(x);
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	       return list.pop();
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        return list.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return list.isEmpty();
	    }
	}
}
