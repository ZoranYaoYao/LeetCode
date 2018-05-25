package com.zoran.leetcode;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import jdk.nashorn.internal.ir.WhileNode;

/**
 * ɾ�����������е��ظ�Ԫ��
 * https://leetcode-cn.com/submissions/detail/2608353/
 */
public class Test17 {

	public static void main(String[] args) {
			ListNode item = new ListNode(1);
			ListNode item2 = new ListNode(1);
			ListNode item3 = new ListNode(1);
			ListNode item4 = new ListNode(1);
			ListNode item5 = new ListNode(1);
			item.next = item2; item2.next = item3;
			item3.next =item4;item4.next =item5;
			
			ListNode node = deleteDuplicates(item);
			
			do {
				System.out.println(node.val);
				node = node.next;
			} while(node != null);
	}

	/**
	 * �������� ,�ظ�ȥ��
	 */
	public static ListNode deleteDuplicates(ListNode head) {
        if(head ==null) return null;
        if(head.next ==null) return head;
        
        ListNode newList = new ListNode(-1);
		newList.next = head;
		while(head != null && head.next != null) {
			if(head.val == head.next.val) {
				head.next = head.next.next;
				continue; //core ,����һ��Ԫ���뵱ǰԪ�����ʱ,ֱ���߳���ǰԪ�ص���һ��Ԫ��, continue.
			}
			head = head.next;
		}
		
		return newList.next;
	}

	static public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
