package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.TreeNode;

/**
 * 求根到叶子节点数字之和
 * https://leetcode-cn.com/submissions/detail/7525831/
 * 
 * DFS,深度搜索优先
 */
public class Test68 {

    int res = 0;
    public int sumNumbers(TreeNode root) {
        //DFS + 回溯
        if (root == null) return 0;
        StringBuilder sb = new StringBuilder();
        iteratorTree(root, sb);
        
        return res;
    }
    
    public void iteratorTree(TreeNode root, StringBuilder sb) {
        if(root == null) return;
        sb.append(""+root.val);
        if(root.left==null && root.right==null) {
            res += Integer.parseInt(sb.toString());
        }
        
        if(root.left!=null) iteratorTree(root.left, sb);
        if(root.right!=null) iteratorTree(root.right, sb);
        sb.deleteCharAt(sb.length()-1); //Core.
    }
}
