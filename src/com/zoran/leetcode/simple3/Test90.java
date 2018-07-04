package com.zoran.leetcode.simple3;

/**
 * 路径总和 III
 * https://leetcode-cn.com/submissions/detail/3728464/
 * 
 *  Nice_zqs
 */
public class Test90 {
	static int count = 0;

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
		System.out.println(pathSum(root, 8));
	}

	static boolean isRoot = true;
	public static int pathSum(TreeNode root, int sum) {
		if(root == null) return 0;

		if(isRoot) {
			iteratNode(root, sum);
			isRoot = false;
		}
		
		if(root.left != null) {
			pathSum(root.left, sum);
			iteratNode(root.left, sum);
		}

		if(root.right != null) {
			pathSum(root.right, sum);
			iteratNode(root.right, sum);
		}

		return count;
	}

	/**
	 * 迭代每一个Node开始的情况 
	 */
	public static void iteratNode(TreeNode root, int sum) {
		if(root == null) return;

		if(root.val == sum) {
			count++;
		}
		sum -= root.val;
		iteratNode(root.left, sum);
		iteratNode(root.right, sum);
	}

	//     Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
