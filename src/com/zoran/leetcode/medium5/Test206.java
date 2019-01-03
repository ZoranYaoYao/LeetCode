package com.zoran.leetcode.medium5;

import com.zoran.leetcode.util.TreeNode;

import java.util.LinkedList;

/**
 * 找树左下角的值
 * https://leetcode-cn.com/submissions/detail/11162113/
 *
 * 还是用的DFS的方式 去记录层级关系
 */
public class Test206 {

    public static void main(String[] args) {
        Test206 test206 = new Test206();

        TreeNode root = new TreeNode(1);
        TreeNode item1 = new TreeNode(2); root.left = item1;
        TreeNode item2 = new TreeNode(3); root.right = item2;

        TreeNode item3 = new TreeNode(4); item1.left = item3;

        TreeNode item4 = new TreeNode(5); item2.left = item4;
        TreeNode item5 = new TreeNode(6); item2.right = item5;

        TreeNode item6 = new TreeNode(7); item4.left = item6;
        int res = test206.findBottomLeftValue(root);
        System.out.println(res);
    }


    int res = 0;
    public int findBottomLeftValue(TreeNode root) {
        //bfs遍历，记录没层的最左端值
        res = root.val;
        bfs(root);
        return res;
    }

    public void bfs(TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        boolean isFirst = true;
        LinkedList<TreeNode> nextList = new LinkedList<>();
        boolean isNextFirst = true;

        linkedList.add(root);
        int orientation = 0;
        while (linkedList.size() != 0 || nextList.size() != 0) {
            if (orientation == 0) {
                isNextFirst =true;
                TreeNode item = linkedList.removeFirst();
//                System.out.println(item.val);
                if (isFirst) {
                    res = item.val;
                    isFirst = false;
                }
                if (item.left != null) {
                    nextList.add(item.left);
                }
                if (item.right != null) {
                    nextList.add(item.right);
                }
                if(linkedList.size() == 0) orientation = 1;
            } else if (orientation == 1) {
                isFirst = true;
                TreeNode item = nextList.removeFirst();
//                System.out.println(item.val);
                if (isNextFirst) {
                    res = item.val;
                    isNextFirst = false;
                }
                if (item.left != null) {
                    linkedList.add(item.left);
                }
                if (item.right != null) {
                    linkedList.add(item.right);
                }
                if (nextList.size() == 0) orientation = 0;
            }
        }
    }
}

class LeetCode_Test206 {
    int res = 0;
    int level = 0;
    public int findBottomLeftValue(TreeNode root) {
        findLastLevel(root, 1);
        return res;
    }

    private void findLastLevel(TreeNode root, int depth) {
        if (root == null) return;
        findLastLevel(root.left, depth+1);
        findLastLevel(root.right, depth+1);
        if (level < depth) {
            level = depth;
            res = root.val;
        }
    }
}
