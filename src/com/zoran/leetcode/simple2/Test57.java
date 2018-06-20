package com.zoran.leetcode.simple2;

/**
 * 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/submissions/detail/3347708/
 * 
 * [Solution]
 * https://blog.csdn.net/xuchonghao/article/details/80687687
 */
public class Test57 {
	
	public TreeNode Nice_lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		
		if((root.val >= p.val && root.val <= q.val) || (root.val >=q.val && root.val <=p.val)) {
			return root;
		}
		
		if (root.val < p.val && root.val < q.val) {
			return Nice_lowestCommonAncestor(root.right, p, q);
		}
		
		if(root.val > p.val && root.val > q.val) {
			return Nice_lowestCommonAncestor(root.left, p, q);
		}
		
		return null;
	}
	
//	  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
