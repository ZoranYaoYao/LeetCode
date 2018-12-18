package com.zoran.leetcode.medium4;

/**
 * 扁平化多级双向链表
 * https://leetcode-cn.com/submissions/detail/10584896/
 *
 * OT
 */
public class Test175 {

    public Node flatten(Node head) {
        //dfs算法
        if(head == null) return null;

        dfs(head);
        return head;
    }

    /**
     * dfs 带有返回值 -> 返回最后一个node！！
     * */
    public Node dfs(Node cur) {
        if(cur == null) return null;

        Node node = cur;
        Node end = cur;
        while(node != null) {
            Node lastNext = node.next;
            if(node.child != null) {
                Node returnNode = dfs(node.child);

                node.next = node.child;
                node.child.prev = node;

                if(lastNext != null) {
                    lastNext.prev = returnNode;
                    returnNode.next = lastNext;
                }

                node.child = null; //Core. 将child节点进行置空， 不用了
            }

            end = node;
            node = lastNext;
        }

        return end;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };
}
