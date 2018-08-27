package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 删除链表的倒数第N个节点
 * https://leetcode-cn.com/submissions/detail/6116528/
 * 
 * [Nice_Solution]
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/
 */
public class Test12 {
	
	public static void main(String[] args) {
		Test12 test12 = new Test12();
		ListNode root = new ListNode(1);
		ListNode root1 = new ListNode(2); root.next =root1;
		ListNode root2 = new ListNode(3); root1.next = root2;
		ListNode root3 = new ListNode(4); root2.next = root3;
		ListNode root4 = new ListNode(5); root3.next = root4;
		
		test12.removeNthFromEnd(root, 2);
	}

    public ListNode removeNthFromEnd(ListNode head, int n) {
    	//1次遍历找到链表大小, 1次遍历删除固定位置值
        int size = 0;
        ListNode cusor = head;
        while(cusor != null) {
            size++;
            cusor = cusor.next;
        }
        
        if(size < n) return head;
        if(size == n) return head.next;
        
        int number = size-n;
        ListNode cusor1 = head;
        while (number>0) {
          if(number != 1) {
        	  cusor1 = cusor1.next;
          } else {
              cusor1.next = cusor1.next.next;
          }
          number--;
        }
        
        return head;
    }

    /**
     * 用双指正保持2个指正中间间隔有n个元素!
     */
    public ListNode Nice_removeNthFromEnd(ListNode head, int n) {
    	ListNode dummy = new ListNode(0); //Core. 解决头节点删除问题
    	dummy.next = head;
    	ListNode first = dummy;
    	ListNode second = dummy;
    	// Advance first pointer so that the gap between first and second is n nodes apart
    	for (int i=1; i<=n+1; i++) {
    		first = first.next;
    	}
    	
    	//Move first to the end, maintaining the gap
    	while(first != null) {
    		first = first.next;
    		second = second.next;
    	}
    	second.next = second.next.next;
    	return dummy.next;
    }
}
