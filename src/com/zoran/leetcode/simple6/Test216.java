package com.zoran.leetcode.simple6;

import com.zoran.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 递增顺序查找树
 * https://leetcode-cn.com/submissions/detail/13078853/
 *
 * [Solution]
 * https://blog.csdn.net/Tomwildboar/article/details/85926145
 *
 * 全部都是新生成的节点
 */
public class Test216 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode item1 = new TreeNode(3); root.left = item1;
        TreeNode item2 = new TreeNode(6); root.right = item2;

        Test216 test216 = new Test216();
        test216.increasingBST(root);
    }

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;

        //中序遍历
        return dfs(root);
    }

    /**
     * 死循环 超时
     */
    private TreeNode dfs(TreeNode root) {
        TreeNode left = null;
        if (root.left != null) {
            left = dfs(root.left);
            left.right = root;
        }
        if (root.right != null) {
            TreeNode right = dfs(root.right);
            root.right = right;
        }

        return left == null ? root : left;
    }
}

class Nice_Test216 {
    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return root;

        dfs(root);

        TreeNode head = new TreeNode(list.get(0));
        list.remove(0);
        TreeNode head1 = head;
        for (Integer i : list) {
            head.left = null;
            TreeNode item = new TreeNode(i);
            head.right = item;
            head = item;
        }

        return head1;
    }

    void dfs (TreeNode root) {
        if (root.left != null)
            dfs(root.left);
        list.add(root.val);
        if (root.right != null)
            dfs(root.right);
    }
}
