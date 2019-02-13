package com.zoran.leetcode.medium6;

import com.zoran.leetcode.util.TreeNode;

/**
 * 二叉搜索树中的插入操作
 * https://leetcode-cn.com/submissions/detail/12651911/
 *
 * 将递归的对象赋值给右节点！
 */
public class Test265 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //直接插入就行，没有红黑树进行旋转
        if (root == null) return new TreeNode(val);
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root.val >= val) {
            if (root.left != null) {
                insert(root.left, val);
            }else {
                root.left = new TreeNode(val);
            }
        } else {
            if (root.right != null) {
                insert(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        }
    }
}

class LeetCode_Test265 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);

        if (val > root.val) {
            root.right = insertIntoBST(root.right, val); //Nice. 将递归的对象赋值给右节点！
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}