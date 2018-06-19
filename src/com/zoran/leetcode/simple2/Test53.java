package com.zoran.leetcode.simple2;

/**
 * 翻转二叉树
 * https://leetcode-cn.com/submissions/detail/3319127/
 */
public class Test53 {

	/**
	 * 分别遍历左右子树对象, 可以递归拆分成子树进行旋转
	 * one time
	 */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        
        return root;
    }
    
//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
