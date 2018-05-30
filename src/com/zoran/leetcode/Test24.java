package com.zoran.leetcode;

/**
 * 平衡二叉树
 * https://leetcode-cn.com/submissions/detail/2760427/
 */
public class Test24 {
	//	给定二叉树 [1,2,2,3,3,null,null,4,4]
	//
	//		       1
	//		        \
	//		         2
	//		          \
	//                 3
	//一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
	//		返回 false 。

	public boolean isBalanced(TreeNode root) {
		if(root ==null) return true;

		int leftHeight = getTreeHeigh(root.left) + 1;
		int righHeight = getTreeHeigh(root.right) + 1;
		if(Math.abs(leftHeight - righHeight) > 1) {
			return false;
		}
		
		return isBalanced(root.left) && isBalanced(root.right); //core 递归遍历, 依赖自己的左右子树的高度
	}

	private int getTreeHeigh(TreeNode node) {
		if(node == null) return 0;

		int Leftheight = 1; int rightHeight = 1;  // 一个node 就代表有一个高度
		if(node.left != null) {
			Leftheight = getTreeHeigh(node.left) + 1;
		}

		if(node.right != null) {
			rightHeight = getTreeHeigh(node.right) + 1;
		}
		return Leftheight > rightHeight ? Leftheight : rightHeight;
	}

	//     Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
