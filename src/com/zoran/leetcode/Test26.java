package com.zoran.leetcode;

import java.util.Stack;


/**
 * 路径总和
 * https://leetcode-cn.com/submissions/detail/2806036/
 * 
 * [Solution]
 * http://www.mamicode.com/info-detail-2274544.html
 */
public class Test26 {
	//	给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
	//
	//	说明: 叶子节点是指没有子节点的节点。
	//
	//	示例: 
	//	给定如下二叉树，以及目标和 sum = 22，
	//
	//	              5
	//	             / \
	//	            4   8
	//	           /   / \
	//	          11  13  4
	//	         /  \      \
	//	        7    2      1
	//	返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。


	public static void main(String[] args) {
		//[5,4,8,11,null,13,4,7,2,null,null,null,1]
		//		TreeNode root = new TreeNode(5);
		//		TreeNode item1 = new TreeNode(4);
		//		TreeNode item2 = new TreeNode(8);
		//		TreeNode item3 = new TreeNode(11); item1.left = item3;
		//
		//		TreeNode item4 = new TreeNode(13); item2.left = item4;
		//		TreeNode item5 = new TreeNode(4); item2.right = item5;
		//
		//		TreeNode item6 = new TreeNode(7); item3.left = item6;
		//		TreeNode item7 = new TreeNode(2); item3.right = item7;
		//
		//		TreeNode item8 = new TreeNode(1); item5.right = item8;
		//		root.left = item1; root.right = item2;

		TreeNode root = new TreeNode(-2);
		TreeNode item1 = new TreeNode(-3);root.right = item1;
		System.out.println(hasPathSum(root, -2));
	}

	/**
	 *  1.Error: 超出时间限制  
	 *  	[Solution] 出现死循环
	 *  2. 不要使用Stack 数据结构, (1) 线程同步 (2) pop, peek 为空时, 会直接抛出异常
	 *  3. 节点有负数 -2 ,null, -3
	 */
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null && sum >= 0) return false;

		int tmp = 0; TreeNode iterator = root;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) { //先左后右
			iterator = stack.peek();
			tmp += iterator.val;

			if(sum < 0) {
				if(tmp == sum && iterator.left == null && iterator.right == null) return true;
			} else {
				if ( tmp >= sum ) {
					if(tmp == sum && iterator.left == null && iterator.right == null) return true;
					tmp -= iterator.val;
					stack.pop();
					if(!stack.isEmpty() && stack.peek().left == iterator) {
						stack.peek().left = null;
					} else if(!stack.isEmpty() && stack.peek().right == iterator) {
						stack.peek().right = null; //不等,则移出二叉树
					}

					if(!stack.isEmpty()) {
						tmp -= stack.peek().val;// 减父节点值
						continue;
					} 

					continue;
				}
			}



			if(iterator.left != null) {
				iterator = iterator.left;
				stack.push(iterator);
				continue;
			}

			if(iterator.right != null) {
				iterator = iterator.right;
				stack.push(iterator);
				continue;
			}

			if(!stack.isEmpty() && (stack.peek().left == null|| stack.peek().right == null)) {
				stack.pop();  // 都没执行的话将自己弹出
			}

		}

		return false;
	}


	/**
	 * 二叉树的递归 : 左右子树递归!!!!!!!!
	 */
	public boolean Nice_hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		if(root.val == sum && root.left == null && root.right == null) return true;
		return hasPathSum(root.right, sum-root.val) || hasPathSum(root.left, sum-root.val);
	}


	//     Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
