package com.zoran.leetcode.medium2;

import java.util.LinkedList;

import com.zoran.leetcode.util.NodeTest.TreeLinkNode;

/**
 * 填充同一层的兄弟节点 II
 * https://leetcode-cn.com/submissions/detail/7384597/
 * 
 * OT
 */
public class Test65 {

    public void connect(TreeLinkNode root) {
        //广度优先遍历 + LinkedList存储, 并对next赋值
        if (root == null) return;
        bfs(root);
    }
    
    //breadth first search
    public void bfs(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                if (i+1<size) queue.get(i).next = queue.get(i+1);
            }
            
            for(int i=0; i<size; i++) {
                TreeLinkNode temp = queue.poll();
                if (temp != null && temp.left != null) queue.add(temp.left);
                if (temp != null && temp.right != null) queue.add(temp.right);
            }
        }
    }
}

/**
 * 将2个for循环 进行合并
 */
class LeetCode_Test65 {
    public void connect(TreeLinkNode root) {
        //广度优先遍历 + LinkedList存储, 并对next赋值
        if (root == null) return;
        bfs(root);
    }
    
    //breadth first search
    public void bfs(TreeLinkNode root) {
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                if (i+1<size) queue.get(i).next = queue.get(i+1);
                
                TreeLinkNode temp = queue.poll();
                if (temp != null && temp.left != null) queue.add(temp.left);
                if (temp != null && temp.right != null) queue.add(temp.right);
            }
        }
    }
}