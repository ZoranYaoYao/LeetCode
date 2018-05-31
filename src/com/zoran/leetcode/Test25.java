package com.zoran.leetcode;

/**
 * ����������С��� 
 * https://leetcode-cn.com/submissions/detail/2772023/
 */
public class Test25 {
//		���������� [3,9,20,null,null,15,7],
//		
//		    3
//		   / \
//		  9  20
//		    /  \
//		   15   7
//		����������С���  2.
//	��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�������
	
	/**
	 * ��������� 
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
     * ������ 
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
