package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoran.leetcode.simple2.Test46.ListNode;

/**
 * ��ת����
 * https://leetcode-cn.com/submissions/detail/3209005/
 * 
 * ������������ñ���, û������ֵ.
 */
public class Test49 {
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode item1 = new ListNode(2); root.next = item1;
		ListNode item2 = new ListNode(3); item1.next = item2;
		ListNode item3 = new ListNode(4); item2.next = item3;
		ListNode item4 = new ListNode(5); item3.next = item4;
		//		ListNode item5 = new ListNode(6); item4.next = item5;
		//		ListNode item6 = new ListNode(6); item5.next = item6;
		ListNode item = LeetCode_reverseList(root);
		while( item !=null) {
			System.out.println(item.val);
			item = item.next;
		}
	}

	/**
	 *  �������е��б�, ������һ���µĵ�������
	 *  ÿ�δ���һ���µ���һ���ڵ�ʱ ����ö���,�����´�ѭ���ҵ���һ������
	 */
	public static ListNode reverseList(ListNode head) {
		ListNode first  = head;
		ListNode tmp = null;
		Map<Integer,ListNode> map = new HashMap<>();
		while(head != null) {
			tmp = map.get(head.val); //Core 
			if(tmp == null) {
				tmp = new ListNode(head.val);
			}

			head = head.next;
			if(head !=null) {
				ListNode  item = new ListNode(head.val);
				item.next = tmp;
				map.put(head.val, item);
				first = item;
			} 
		}

		return first;
	}

	/**
	 * ��������: 3������(pre, cur, head),�ı�����ڵ����һ��Ԫ��
	 * �ռ临�Ӷ� O(1) 
	 */
	public static ListNode LeetCode_reverseList(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			pre.next = cur.next;  //Nice_Core pre.next ��Ϊһ����ʱ�洢�ı���, ���ָ�����ĩβ5 �����null
			cur.next = head;  //��ǰ�ڵ����һ���ڵ��� �ϴε�ͷλ��
			//cur.next = pre;
			head = cur;  //ͷλ�� ������ǰ�ڵ�
			cur = pre.next; //��ǰ�ڵ�������
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
