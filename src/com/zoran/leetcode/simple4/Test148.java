package com.zoran.leetcode.simple4;

import com.zoran.leetcode.util.NodeTest.TreeNode;


/**
 * �޼�����������
 * https://leetcode-cn.com/submissions/detail/4978989/
 * 
 * [Solution]
 * https://blog.csdn.net/shauna_wu/article/details/78690364
 */
public class Test148 {

	public TreeNode Nice_trimBST(TreeNode root, int L, int R) {
		if(root == null) return root;

		if (root.val < L) {
			return Nice_trimBST(root.right, L, R);
		}else if (root.val > R) {
			return Nice_trimBST(root.left, L, R);
		} else {
			root.left = Nice_trimBST(root.left, L, R); //Nice: ͨ�������ӽڵ�����ڵ㸳ֵ��˼��;
			root.right = Nice_trimBST(root.right, L, R);
			return root;
		}
	}
}
