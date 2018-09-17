package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 中序遍历（LDR）是二叉树遍历的一种，也叫做中根遍历、中序周游。在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
 *
 */
public class Test53 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        iteratorTree(res, root);
        return res;
    }
    
    public void iteratorTree(List<Integer> res, TreeNode node) {
        if(node == null) return;
        
        iteratorTree(res, node.left); //左
        if(node != null) res.add(node.val); //中
        iteratorTree(res, node.right);  //右
    }
}
