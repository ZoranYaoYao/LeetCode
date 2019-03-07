package com.zoran.leetcode.simple6;

import com.zoran.leetcode.util.TreeNode;

/**
 * 二叉树的堂兄弟节点
 * https://leetcode-cn.com/submissions/detail/14096432/
 */
public class Test239 {

    int depthX = 0;
    int depthY = 0;
    public boolean isCousins(TreeNode root, int x, int y) {
        //记录x,y的父节点和深度
        TreeNode parentX = dfs(root, x, 0, 1);
        TreeNode parentY = dfs(root, y, 0, 2);
        if (parentX != parentY && depthX == depthY)
            return true;
        return false;
    }

    public TreeNode dfs(TreeNode root, int x, int depth, int type) {
        if (root == null) return null;

        if ((root.left != null && root.left.val == x)
                || (root.right != null && root.right.val == x)) {
            if (type == 1)
                depthX = depth+1;
            else
                depthY = depth+1;
            return root;
        }

        TreeNode res = dfs(root.left, x, depth+1, type);
        if(res == null) {
            return dfs(root.right, x, depth+1, type);
        }
        return res;
    }
}
