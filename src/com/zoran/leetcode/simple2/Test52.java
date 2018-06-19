package com.zoran.leetcode.simple2;

import java.util.LinkedList;

/**
 * 用队列实现栈
 * https://leetcode-cn.com/submissions/detail/3295224/
 */
public class Test52 {

}

class MyStack {
    private LinkedList<Integer> list;
    
    /** Initialize your data structure here. */
    public MyStack() {
        list = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        list.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return list.pollLast();
    }
    
    /** Get the top element. */
    public int top() {
        return list.peekLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return list.size() == 0 ? true : false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */