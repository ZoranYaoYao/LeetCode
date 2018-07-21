package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 572. 另一个树的子树
 * https://leetcode-cn.com/problems/subtree-of-another-tree/description/
 * 
 * [Solution] 
 * https://www.cnblogs.com/jimmycheng/p/7101024.html
 */
public class Test127 {

	public static void main(String[] args) {
		//		[3,4,5,1,2]
		//		[4,1,2]
		TreeNode root = new TreeNode(3);
		TreeNode item1 = new TreeNode(4); root.left = item1;
		TreeNode item2 = new TreeNode(5); root.right = item2;
		//		
		TreeNode item3 = new TreeNode(1); item1.left = item3;
		TreeNode item4 = new TreeNode(2); item2.left = item4;
		//		TreeNode item5 = new TreeNode(0); item3.left = item5;

		TreeNode item6 = new TreeNode(3); 
		TreeNode item7 = new TreeNode(1); item6.left = item7;
		TreeNode item8 = new TreeNode(2); item6.right = item8;

		Test127 test127 = new Test127();
		System.out.println(test127.isSubtree(root,item6));
	}

	/**
	 * 把自己递归死了 
	 * 问题点: 一个递归,解决不了组合情况多种的时候!
	 * 需要分多个方法,进行处理
	 */
	boolean lastEqual = false;
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s != null && t == null) return false;
		if (s == null && t != null) return false;
		boolean result = false;

		if (s.val != t.val) {
			if(lastEqual) {
				lastEqual = false;
				return false; 
			}
			result = isSubtree(s.left, t);
			if(result) return true;
			result = isSubtree(s.right, t);
		}

		if(s.val == t.val) {
			lastEqual = true;
			result = isSubtree(s.left, t.left);
			if(result) {
				result = isSubtree(s.right, t.right);
			} else {
				result = isSubtree(s.left, t);
			}
		}

		return result;
	}

	public boolean Nice_isSubtree(TreeNode s, TreeNode t) {
		if (s == null) return false;
		if(Nice_isSame(s,t)) return true;
		
		return isSubtree(s.left, t) || isSubtree(s.right, t);
		
	}

	private boolean Nice_isSame(TreeNode s, TreeNode t) {
		if(s == null && t== null) return true;
		if (s == null || t == null) return false;
		if (s.val != t.val) return false;
		
		return Nice_isSame(s.left, t.left) && Nice_isSame(s.right, t.right);
	}
	
}
