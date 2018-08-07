package com.zoran.leetcode.simple5;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 二叉搜索树中的搜索
 * https://leetcode-cn.com/submissions/detail/5212153/
 */
public class Test160 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        
        TreeNode result  = null;
        if(root.val == val) {
            result = root;
        } else {
            if(root.left != null){
                result = searchBST(root.left, val);
                if(result != null) return result;
            } 
            if(root.right != null) result = searchBST(root.right, val);
        }
        return result;
    }
    
    public TreeNode Nice_searchBST(TreeNode root, int val) {
    	if (root == null) return null;
    
    	if (root.val == val) return root;
    	else if (root.val > val) return Nice_searchBST(root.left, val); //Nice. 运用了BST排序的特性
    	else return Nice_searchBST(root.right, val);
    }
}
