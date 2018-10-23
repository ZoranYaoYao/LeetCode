package com.zoran.leetcode.medium3;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/submissions/detail/8569795/
 * 
 * [Solution]
 * https://blog.csdn.net/xuchonghao/article/details/80688166
 * 
 * 最小的公共子树 分情况:1. 在2侧, 2. 在同侧
 */
public class Test107 {

}


class Nice_Test107 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root ==null || root.val == p.val || root.val == q.val) //Nice_Core. 什么时候才是公共子树 
			return root;
		
		TreeNode leftN = lowestCommonAncestor(root.left, p, q);
		TreeNode rightN = lowestCommonAncestor(root.right, p, q);
		
		if (leftN != null && rightN != null) return root;
		if (leftN == null) return rightN;
		return leftN;
	}
}