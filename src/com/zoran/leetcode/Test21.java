package com.zoran.leetcode;

/**
 * 二叉树的最大深度
 * https://leetcode-cn.com/submissions/detail/2697437/
 */
public class Test21 {

	public static void main(String[] args) {
//			3
//		   / \
//		  9  20
//		    /  \
//		   15   7
	}
	
	/**
	 * 思路: 对树的遍历, 树的遍历都是对左子树, 右子树进行分开遍历.
	 * 递归: 根依赖子树的高度, 所以可以使用递归.
	 */
    public int maxDepth(TreeNode root) {
    	if(root == null) return 0;
    	
        int max = 1;
        if(root.left !=null) {
        	int tmp = maxDepth(root.left) + 1;
        	if(tmp > max) max = tmp;
        }
        
        if(root.right != null) {
        	int tmp2 = maxDepth(root.right) + 1;
        	if(tmp2 > max) max =tmp2;
        }
        
        return max;
    }
    
    //代码缩减版
    public int Nice_maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1: rightDepth + 1;
    }
	
//	  Definition for a binary tree node.
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
}
