package com.zoran.leetcode;

/**
 * ��������������
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
	 * ˼·: �����ı���, ���ı������Ƕ�������, ���������зֿ�����.
	 * �ݹ�: �����������ĸ߶�, ���Կ���ʹ�õݹ�.
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
    
    //����������
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
