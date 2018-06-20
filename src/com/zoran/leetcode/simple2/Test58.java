package com.zoran.leetcode.simple2;

/**
 * 删除链表中的节点
 * https://leetcode-cn.com/submissions/detail/3353691/
 * 
 * 错误题
 */
public class Test58 {
	
    public void deleteNode(ListNode node) {
        node.val = node.next.val;  
        node.next = node.next.next;  
    }
    
//     Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
