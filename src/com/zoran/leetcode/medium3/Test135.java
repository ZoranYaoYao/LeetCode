package com.zoran.leetcode.medium3;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 打家劫舍 III
 * https://leetcode-cn.com/submissions/detail/9074302/
 * 
 * [Solution]
 * https://blog.csdn.net/xuchonghao/article/details/80700753
 * 
 * 按层级遍历, 并递归思想
 */
public class Test135 {

	
}

class Nice_Test135 {
	public int rob(TreeNode root) {
		if (root == null) return 0;
		int s0 =0;
		int s1 = root.val;
		
		s0 = rob(root.left) + rob(root.right);
		
		if (root.left != null) s1 += rob(root.left.left) + rob(root.left.right);
		if (root.right != null) s1 += rob(root.right.left) + rob(root.right.right);
		
		return Math.max(s0, s1);
	}
}
