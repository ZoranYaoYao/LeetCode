package com.zoran.leetcode.simple3;

/**
 * ��Ҷ��֮��
 * https://leetcode-cn.com/submissions/detail/3631434/
 */
public class Test84 {
    int count = 0;
    enum Leaf {
        LEFT, RIGHT;
    }
    
    /**
     * ��¼��Ҷ�ӵı�ʶ�� enum Leaf
     * One Time
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left != null) {
            sumOfLeftLeaves(root.left,Leaf.LEFT);
        }
        
        if(root.right != null) {
            sumOfLeftLeaves(root.right,Leaf.RIGHT);
        }
        
        return count;
    }
    
    public void sumOfLeftLeaves(TreeNode root,Leaf flag) {
        if(root.left != null) {
            sumOfLeftLeaves(root.left,Leaf.LEFT);
        }
        
        if(root.right != null) {
            sumOfLeftLeaves(root.right,Leaf.RIGHT);
        }
        
        if(root.left == null && root.right == null && flag== Leaf.LEFT) {
            count += root.val;
        }
    }
    
    int sum = 0;
    public int LeetCode_sumOfLeftLeaves(TreeNode root) {
    	if(root == null) return sum;
    	
    	if(root.left != null) { //һ�α�����ѯ3�����
    		if(root.left.left == null && root.left.right == null) {
    			sum += root.left.val;
    		}
    	}
    	
    	LeetCode_sumOfLeftLeaves(root.left);
    	LeetCode_sumOfLeftLeaves(root.right);
    	return sum;
    }
    
//     Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
