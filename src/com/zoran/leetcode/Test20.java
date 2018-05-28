package com.zoran.leetcode;


/**
 * 对称二叉树
 * https://leetcode-cn.com/submissions/detail/2684051/
 */
public class Test20 {

	public static void main(String[] args) {
		/*但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

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
		
		// core : 共同规律: 判断根节点, 然后递归判断根节点的左右子树 是否对称
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
