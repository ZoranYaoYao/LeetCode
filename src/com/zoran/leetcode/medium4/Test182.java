package com.zoran.leetcode.medium4;

import com.zoran.leetcode.util.TreeNode;

/**
 * 删除二叉搜索树中的节点
 * https://leetcode-cn.com/submissions/detail/10671130/
 *
 * [Solution]
 * https://blog.csdn.net/diu_man/article/details/81203522
 */
public class Test182 {

    /**
     * [5,3,6,2,4,null,7]
     * 3
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode item1 = new TreeNode(1);
        root.left = item1;
//        TreeNode item2 = new TreeNode(2);
//        root.right = item2;

//        TreeNode item3 = new TreeNode(2);
//        item1.left = item3;
//        TreeNode item4 = new TreeNode(4);
//        item1.right = item4;
//
//
//        TreeNode item7 = new TreeNode(7);
//        item2.right = item7;
        Test182 test182 = new Test182();
        test182.deleteNode(root, 2);
    }

    TreeNode parent;
    int orientation = -1; //0-left, 1-right

    /**
     * 找出该节点 最接近的节点替换
     * 问题： 只能跑过48个case
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //叶子节点，直接删，
        //先变左侧，左侧没有则变化右侧
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            if (root.val == key) return null;
            return root;
        }

        TreeNode cur = dfs(null, root, key, orientation);
        if (cur == null) return root;

        if (cur.left == null && cur.right == null) {
            if (parent != null) {
                if (orientation == 0) parent.left = null;
                if (orientation == 1) parent.right = null;
            }
        } else if (cur.left != null) {
            TreeNode origon = cur;
            TreeNode curParent = null;
            while (cur != null && cur.right != null) {
                curParent = cur;
                cur = cur.right;
            }
            if (parent != null) {
                parent.left = cur;
            } else {
                /**
                 * 问题点：如何删除根节点？
                 */
                parent = cur;
                parent.right = cur.right;
            }
            if (curParent != null) curParent.right = null;
            cur.left = origon.left;
            if (parent == null) return cur; //删除根节点位置

        } else if (cur.right != null) {
            TreeNode origon = cur;
            TreeNode curParent = null;
            while (cur != null && cur.left != null) {
                curParent = cur;
                cur = cur.left;
            }
            if (parent != null) {
                parent.right = cur;
            } else {
                root = cur.right; //删除根结点
                return root;
            }
            if (curParent != null) curParent.left = null;
            cur.right = origon.right;

        }

        return root;
    }

    public TreeNode dfs(TreeNode parent, TreeNode root, int key, int orientation) {
        if (root == null) return null;
        TreeNode res = null;

        if (root.val == key) {
            this.parent = parent;
            this.orientation = orientation;
            res = root;
        } else {
            res = dfs(root, root.left, key, 0);
            if (res != null) return res;

            res = dfs(root, root.right, key, 1);
        }

        return res;
    }
}

class Nice_Test182 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode node = root;
        if (key < node.val) { //Nice_Core 二分搜索树的遍历查找方式
            root.left = deleteNode(root.left, key); //NNice_core 将删除之后的结点 赋值给该结点的父节点
        } else if (key > node.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                root = root.left == null ? root.right : root.left;
            } else {
                //左右子树都存在的情况下
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                root.val = cur.val;
                root.right = deleteNode(root.right, cur.val); //NNNcie 删除被赋值的节点！！
            }
        }

        return root;
    }
}

























