package com.zoran.leetcode.medium3;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * �������������������
 * https://leetcode-cn.com/submissions/detail/8569795/
 * 
 * [Solution]
 * https://blog.csdn.net/xuchonghao/article/details/80688166
 * 
 * ��С�Ĺ������� �����:1. ��2��, 2. ��ͬ��
 */
public class Test107 {

}


class Nice_Test107 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root ==null || root.val == p.val || root.val == q.val) //Nice_Core. ʲôʱ����ǹ������� 
			return root;
		
		TreeNode leftN = lowestCommonAncestor(root.left, p, q);
		TreeNode rightN = lowestCommonAncestor(root.right, p, q);
		
		if (leftN != null && rightN != null) return root;
		if (leftN == null) return rightN;
		return leftN;
	}
}