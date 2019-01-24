package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * 在二叉树中增加一行
 * https://leetcode-cn.com/submissions/detail/12026194/
 *
 * 二叉树层级遍历
 */
public class Test238 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode item1 = new TreeNode(2); root.left = item1;
        TreeNode item2 = new TreeNode(3); root.right = item2;

        TreeNode item3 = new TreeNode(4); item1.left = item3;
        Test238 test238 = new Test238();
        test238.addOneRow(root,5,4);
    }

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        //遍历到d-1层插入节点，然后将原节点赋值给新节点的左右子树
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }

        //按层级遍历
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()) {
            int count = queue.size();
            boolean insert = false;
            for (int i=0; i<count; i++) { //Core count记录该层的遍历边界
                TreeNode item = queue.poll();
                if (level == (d-1)) {
                    insert = true;
                    TreeNode left = item.left;
                    TreeNode right = item.right;
                    TreeNode newLeft = new TreeNode(v);
                    TreeNode newRight = new TreeNode(v);
                    item.left = newLeft;  newLeft.left = left;
                    item.right = newRight; newRight.right = right;
                } else {
                    if (item.left != null) queue.add(item.left);
                    if (item.right != null) queue.add(item.right);
                }
                if (i == count-1) level++;
            }
            if (insert) return root;
        }

        return root;
    }
}
