package com.zoran.leetcode.simple5;

import com.zoran.leetcode.util.NodeTest.TreeNode;


/**
 * 最长同值路径
 * https://leetcode-cn.com/submissions/detail/5071288/
 * 
 * [Solultion]
 * https://blog.csdn.net/xiezongsheng1990/article/details/79631547
 * 
 * 二叉树的路径: 指2个节点之间的线条的条数
 */
public class Test154 {

	public int Nice_longestUnivaluePath(TreeNode root) {
		int[] res = new int[1];
		if(root != null) dfs(root, res);
		return res[0];
	}
	
	private int dfs(TreeNode node, int[] res) {
		int l = node.left != null ? dfs(node.left, res) : 0; //Core: 根据子节点的值相同进行返回
		int r = node.right != null ? dfs(node.right, res) : 0;
		int resl = node.left != null && node.left.val == node.val ? l+1 : 0;
		int resr = node.right != null && node.right.val == node.val ? r+1 : 0;
		res[0] = Math.max(res[0], resl +resr);
		return Math.max(resl, resr); //Core. 返回子节点路径最大的值
	}
}
