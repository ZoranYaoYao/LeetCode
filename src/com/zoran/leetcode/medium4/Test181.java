package com.zoran.leetcode.medium4;

import com.zoran.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉搜索树
 * https://leetcode-cn.com/submissions/detail/10664224/
 *
 * [Solution]
 * https://blog.csdn.net/nancyhelloworld/article/details/79529638
 *
 * 先序遍历， 先序解析
 */
public class Test181 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpSerialize(root,sb);
        return sb.toString();

    }
    public void helpSerialize(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        sb.append(root.val).append(" ");
        helpSerialize(root.left,sb);
        helpSerialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] strs = data.split(" ");
        Queue<Integer> queue = new LinkedList<>();
        //queue.addAll(Arrays.asList(data.split(" ")));
        for(String str:strs){
            queue.offer(Integer.parseInt(str));
        }
        return help(queue);
    }
    public TreeNode help(Queue<Integer> q) {
        if(q.isEmpty()) return null;
        int cur = q.poll();
        TreeNode root = new TreeNode(cur);
        Queue<Integer> sq = new LinkedList<>();
        while(!q.isEmpty() && q.peek()<cur){
            sq.offer(q.poll());
        }
        root.left = help(sq);
        root.right = help(q);
        return root;
    }
}
