package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/submissions/detail/6121217/
 */
public class Test14 {
	
	public static void main(String[] args) {
		Test14 test14 = new Test14();
		ListNode root = new ListNode(1);
		test14.swapPairs(root);
	}

	/**
	 * 思路:
	 * 1. 传递上一个交换之后的前一个节点
	 * 2. 记录交换之后的第一节点, 第二几点, 游标节点
	 */
    public ListNode swapPairs(ListNode head) {
        //遍历交换位置, 把上一个节点 传给下一组
    	if(head == null || head.next == null) return head;
    	
        ListNode root = head; boolean isFirst = true;
        ListNode cursor = head;
        ListNode preNode = head;
        
        while(cursor != null) {
            ListNode third = null;
            
            if(cursor.next != null)
                third = cursor.next.next;
            ListNode first = cursor.next;
            ListNode second = cursor;
            
            if(first == null) {
                preNode.next = second;
                break;
            } else {
                preNode.next = first;
            }
            
            first.next = second;
            second.next = third;
            cursor = third;
            preNode = second;
            if(isFirst) {
                root = first;
                isFirst = false;
            }
        }
        
        return root;
    }
}
