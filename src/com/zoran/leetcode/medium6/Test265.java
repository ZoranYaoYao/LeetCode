package com.zoran.leetcode.medium6;

import com.zoran.leetcode.util.TreeNode;

/**
 * �����������еĲ������
 * https://leetcode-cn.com/submissions/detail/12651911/
 *
 * ���ݹ�Ķ���ֵ���ҽڵ㣡
 */
public class Test265 {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        //ֱ�Ӳ�����У�û�к����������ת
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
            root.right = insertIntoBST(root.right, val); //Nice. ���ݹ�Ķ���ֵ���ҽڵ㣡
        } else {
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }
}