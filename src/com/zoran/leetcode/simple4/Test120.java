package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * ��������ֱ��
 * https://leetcode-cn.com/submissions/detail/4357487/
 * 
 * [Solution]
 * https://blog.csdn.net/Yangtong157/article/details/70171859
 */
public class Test120 {
	int maxNum = 0;
	
	/**
	 * û���뵽�㵽��һ��ĳ��� ,����ת��Ϊ�߶�֮��Ĺ�ϵ
	 * ��ͬ��1.���������,
	 * 		 2.��ÿ���ڵ�����Ҹ߶Ȳ�����ֵ
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
