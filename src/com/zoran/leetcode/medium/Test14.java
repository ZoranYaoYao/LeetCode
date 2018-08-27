package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * �������������еĽڵ�
 * https://leetcode-cn.com/submissions/detail/6121217/
 */
public class Test14 {
	
	public static void main(String[] args) {
		Test14 test14 = new Test14();
		ListNode root = new ListNode(1);
		test14.swapPairs(root);
	}

	/**
	 * ˼·:
	 * 1. ������һ������֮���ǰһ���ڵ�
	 * 2. ��¼����֮��ĵ�һ�ڵ�, �ڶ�����, �α�ڵ�
	 */
    public ListNode swapPairs(ListNode head) {
        //��������λ��, ����һ���ڵ� ������һ��
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
