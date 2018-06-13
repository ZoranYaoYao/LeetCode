package com.zoran.leetcode.simple2;

/**
 * ɾ�������еĽڵ�
 * https://leetcode-cn.com/submissions/detail/3167267/
 */
public class Test46 {

	//	����: 1->2->6->3->4->5->6, val = 6
	//	���: 1->2->3->4->5

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode item1 = new ListNode(2); root.next = item1;
		ListNode item2 = new ListNode(6); item1.next = item2;
		ListNode item3 = new ListNode(3); item2.next = item3;
		ListNode item4 = new ListNode(4); item3.next = item4;
		ListNode item5 = new ListNode(6); item4.next = item5;
		ListNode item6 = new ListNode(6); item5.next = item6;
		ListNode item = removeElements(root, 6);
		while( item !=null) {
			System.out.println(item.val);
			item = item.next;
		}

	}

	/**
	 * �жϵ�ǰֵ ���ֵ���,������һ���ڵ��next ��ֵ����һ��Ԫ�صĽڵ�
	 * �����: ������λ��������
	 * one time success
	 */
	public static ListNode removeElements(ListNode head, int val) {
		if(head == null) return null;

		ListNode pre = null;
		ListNode iterator = head;
		while(iterator != null) {
			if(iterator.val == val) {
				if(pre == null) {
					head = head.next;
				} else {
					pre.next = iterator.next;
				}
			} else {
				pre = iterator;
			}
			iterator = iterator.next;
		}
		
		return head;
	}

	//     Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
