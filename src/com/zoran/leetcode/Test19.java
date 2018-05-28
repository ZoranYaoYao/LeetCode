package com.zoran.leetcode;

/**
 * ��ͬ����
 * https://leetcode-cn.com/submissions/detail/2678387/
 */
public class Test19 {
	public static void main(String[] args) {
		System.out.println(isSameTree(null, null));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if((p == null && q != null) || (p != null && q == null)) return false;
		if(p ==null && q ==null) return true;

		if(p != null && q != null) { //��Ч�ж�
			if(p.val == q.val) {
				if(isSameTree(p.left,q.left)){
					if(isSameTree(p.right, q.right)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		return false; //��Ч����
	}

	/**
	 * ������Ŀ֪����һ��,3��ֵ���ж�
	 * ���ҽڵ��жϿ��Ժϲ���һ�𷵻�!
	 * �������� && �ȼ��� if(){if(){return true;}}
	 */
	public boolean Nice_isSameTree(TreeNode p, TreeNode q) {
		if(p==q&&p==null) return true;
		else if(p==null || q == null) return false;
		
		if(p.val==q.val) {
			return Nice_isSameTree(p.left, q.left) && Nice_isSameTree(p.right, q.right);  // nice code
		}else
			return false;
	}

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
