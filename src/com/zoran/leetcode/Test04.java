package com.zoran.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/description/
 * [问题]
 * 	 对字符匹配不熟悉, 对stack的运用不熟悉
 * [Solution]
 * https://segmentfault.com/a/1190000003481208 
 * @author Zoran
 */
public class Test04 {

	public static void main(String[] args) {
		System.out.println(isValid("([])("));
	}
	
	static Map<Character, Character> map = new HashMap<>();
	static {
		map.put('(', ')');map.put('{', '}');map.put('[', ']');
	}
	
	/**
	 * 问题: 堆栈没有进行pop操作
	 * @return
	 */
    public static boolean isValid(String s) {
    	if (s ==null) {
			return false;
		}
        boolean reslut = true;
    	if (s.isEmpty()) {
			return true;
		} else if(s.length()%2 != 0) {
			return false;
		}
    	
    	//栈效果
    	//LinkedList<Character> stack = new LinkedList<>();
    	Stack<Character> stack = new Stack<>(); 
    	char[] src = s.toCharArray();
    	
    	for(int i = 0; i < src.length; i++) {
    		char currentChar = src[i];
    		if(currentChar == '(' || currentChar == '{' || currentChar == '[') {
    			stack.add(currentChar);
    		}else {
    			if(stack.isEmpty() || currentChar != map.get(stack.pop())) {
    				return false;
    			}
    		}
    	}
    	
    	if(stack.isEmpty()) return true;
    	
    	return false;
    }

    
}
