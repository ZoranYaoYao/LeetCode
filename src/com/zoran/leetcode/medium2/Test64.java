package com.zoran.leetcode.medium2;

import java.util.LinkedList;

import com.zoran.leetcode.util.NodeTest.TreeLinkNode;

/**
 * 填充同一层的兄弟节点
 * https://leetcode-cn.com/submissions/detail/7384030/
 */
public class Test64 {
	
	public static void main(String[] args) {
		Test64 test64 = new Test64();
		TreeLinkNode root = new TreeLinkNode(0);
		test64.connect(root);
	}

    public void connect(TreeLinkNode root) {
        //层级遍历, 2个节点做next链接
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
                if(i+1 <size) {
                    queue.get(i).next = queue.get(i+1);
                } 
            }
            
            for(int i=0; i<size; i++) {
                TreeLinkNode temp = queue.poll();
                if(temp != null) {
                    if(temp.left != null) queue.add(temp.left);
                    if(temp.right != null)  queue.add(temp.right);
                }
            }

        }
    }
}
