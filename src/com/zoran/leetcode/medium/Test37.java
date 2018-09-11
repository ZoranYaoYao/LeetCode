package com.zoran.leetcode.medium;

import java.util.Stack;

/**
 * 简化路径
 * https://leetcode-cn.com/submissions/detail/6879361/
 * 
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/51399770
 */
public class Test37 {

}

class Nice_Test37 {
	public String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		while (path.length() > 0) {
			int start = path.indexOf("/");//第一个斜杠
			path = path.substring(start+1);//Path一进被截取
			int end =path.indexOf("/"); //第二个斜杠
			if (end ==-1) end = path.length();
			
			String part = path.substring(0, end);
			path = path.substring(end);
			
			if(part.equals(".") || part.equals("")) continue;
			if(part.equals("..")) {
				if (stack.isEmpty()) {
					stack.pop();
				}
			}else {
				stack.push("/" + part);
			}
		}
		
		String result = "";
		while (!stack.isEmpty()) result = stack.pop() + result;
		
		if (result.length() == 0) {
			result = "/";
		}
		return result;
	}
}
