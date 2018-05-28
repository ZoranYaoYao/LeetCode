package com.zoran.leetcode;


/**
 * �Գƶ�����
 * https://leetcode-cn.com/submissions/detail/2684051/
 */
public class Test20 {

	public static void main(String[] args) {
		/*����������� [1,2,2,null,3,null,3] ���Ǿ���ԳƵ�:

			1
			/ \
			2   2
			\   \
			3    3*/
		
		System.out.println(isSymmetric(null));
		
	}

	public static boolean isSymmetric(TreeNode root) {
		if(null == root) return true;
		if(root.left ==null && root.right != null) return false;
		if(root.left !=null && root.right ==null) return false;
		if(root.left ==null && root.right ==null) return true;
		return isSymmetric(root.left, root.right);
	}
	
	public static boolean isSymmetric(TreeNode t1,TreeNode t2) {
		if(t1 !=null && t2 ==null) return false;
		if(t1 ==null && t2 !=null) return false;
		if(t1 ==null && t2 ==null) return true;
		
		// core : ��ͬ����: �жϸ��ڵ�, Ȼ��ݹ��жϸ��ڵ���������� �Ƿ�Գ�
		if(isEqual(t1,t2)) {
			return isSymmetric(t1.left,t2.right) && isSymmetric(t1.right, t2.left); 
		}else {
			return false;
		}
	}
	
	public static boolean isEqual(TreeNode t1, TreeNode t2) {
		return t1.val == t2.val ? true : false;
	}

	//Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
