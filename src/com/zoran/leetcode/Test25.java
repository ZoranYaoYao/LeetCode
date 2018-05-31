package com.zoran.leetcode;

/**
 * 二叉树的最小深度 
 * https://leetcode-cn.com/submissions/detail/2772023/
 */
public class Test25 {
//		给定二叉树 [3,9,20,null,null,15,7],
//		
//		    3
//		   / \
//		  9  20
//		    /  \
//		   15   7
//		返回它的最小深度  2.
//	最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
	
	/**
	 * 代码很冗余 
	 */
    public int minDepth(TreeNode root) {
        if(root ==null) return 0;
        int minLeftHeight = -1;int minRighteight = -1;
        if(root.left != null) {
            minLeftHeight = minDepth(root.left) + 1;
        }

        if(root.right != null) {
            minRighteight = minDepth(root.right) +1;
        }
        
        if(minLeftHeight == -1 && minRighteight == -1) {
        	return 1;
        } else if(minLeftHeight != -1 && minRighteight == -1) {
        	return minLeftHeight;
        } else if(minLeftHeight == -1 && minRighteight != -1) {
        	return minRighteight;
        } else {
            return minLeftHeight > minRighteight ? minRighteight : minLeftHeight;
        }
    }
    
    /**
     * 代码简洁 
     */
    public int Nice_minDepth(TreeNode root) {
        if (root == null)	return 0;
        if (root.left == null)	return minDepth(root.right) + 1;  //nice_code
        if (root.right == null) return minDepth(root.left) + 1;
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
    
//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
