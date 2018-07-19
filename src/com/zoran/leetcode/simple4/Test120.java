package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树的直径
 * https://leetcode-cn.com/submissions/detail/4357487/
 * 
 * [Solution]
 * https://blog.csdn.net/Yangtong157/article/details/70171859
 */
public class Test120 {
	int maxNum = 0;
	
	/**
	 * 没有想到点到另一点的长度 ,可以转化为高度之间的关系
	 * 等同于1.遍历这个树,
	 * 		 2.求每个节点的左右高度差的最大值
	 */
	public int Nice_diameterOfBinaryTree(TreeNode root) {
		int n = 0;
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}
		
		getHeight(root);
		return maxNum;
		
	}
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left + right > maxNum) {
			maxNum = left + right;
		}
		return left > right ? left + 1: right + 1;
	}
}
