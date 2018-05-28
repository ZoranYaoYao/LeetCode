package com.zoran.leetcode;

/**
 * 相同的树
 * https://leetcode-cn.com/submissions/detail/2678387/
 */
public class Test19 {
	public static void main(String[] args) {
		System.out.println(isSameTree(null, null));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if((p == null && q != null) || (p != null && q == null)) return false;
		if(p ==null && q ==null) return true;

		if(p != null && q != null) { //无效判断
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

		return false; //无效返回
	}

	/**
	 * 根据题目知道是一个,3个值的判断
	 * 左右节点判断可以合并到一起返回!
	 * 合理利用 && 等价于 if(){if(){return true;}}
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
