package com.zoran.leetcode.simple2;

/**
 * ��ת������
 * https://leetcode-cn.com/submissions/detail/3319127/
 */
public class Test53 {

	/**
	 * �ֱ����������������, ���Եݹ��ֳ�����������ת
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
