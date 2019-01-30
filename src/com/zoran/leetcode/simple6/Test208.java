package com.zoran.leetcode.simple6;

import com.zoran.leetcode.util.TreeNode;

/**
 * µ¥Öµ¶þ²æÊ÷
 * https://leetcode-cn.com/submissions/detail/12255134/
 */
public class Test208 {

    int res;
    public boolean isUnivalTree(TreeNode root) {
        res = root.val;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        if (root.val != res)  return false;

        return dfs(root.left) && dfs(root.right);
    }
}
