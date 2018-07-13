package com.zoran.leetcode.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zoran.leetcode.simple3.Test90.TreeNode;

public class NodeTest {

	public static void main(String[] args) {
		//[10,5,-3,3,2,null,11,3,-2,null,1]
		TreeNode root = new TreeNode(10);
		TreeNode item1 = new TreeNode(5); root.left = item1;
		TreeNode item2 = new TreeNode(-3); root.right = item2;
		
		TreeNode item3 = new TreeNode(3); item1.left = item3;
		TreeNode item4 = new TreeNode(2); item1.right = item4;
		
		TreeNode item5 = new TreeNode(11); item2.right = item5;
		
		TreeNode item6 = new TreeNode(3); item3.left = item6;
		TreeNode item7 = new TreeNode(-2); item3.right = item7;
		
		TreeNode item8 = new TreeNode(1); item4.right = item8;
//		System.out.println(pathSum(root, 8));
		
		/**字符转 列表*/
        List<Character> list1 = new ArrayList<Character>( Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        
        /**数组快速转换成字符串格式*/
		String[] items = {"Hello","Alaska","Dad","Peace"};
		System.out.println(Arrays.toString(items));
	}
	
	//     Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
