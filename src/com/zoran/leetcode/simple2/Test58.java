package com.zoran.leetcode.simple2;

/**
 * ɾ�������еĽڵ�
 * https://leetcode-cn.com/submissions/detail/3353691/
 * 
 * ������
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
