package com.zoran.leetcode.simple2;

import org.w3c.dom.css.ElementCSSInlineStyle;

/**
 * 两个链表是否相交 : 指两个链表相交后,后面的节点都相同
 * https://leetcode-cn.com/submissions/detail/2943563/
 * 
 * [Solution]
 * https://blog.csdn.net/yangmm2048/article/details/44924997
 */
public class Test35 {

	/**
	 * 时间复杂度 O(m*n) 不达标
	 * 超出时间限制  Intersected at '20000': [1,3,5,7,9.....
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//base headA
		while(headB != null) {
			boolean in = contains(headA, headB);
			if(in) {
				return headB;
			} else {
				headB = headB.next;
			}
		}

		return null;
	}

	public boolean contains(ListNode base, ListNode item) {
		if(item == null) return false;

		while (base != null ) {
			if (item.val == base.val) {
				return true;
			}
			base = base.next;
		}

		return false;
	}

	public ListNode Nice_getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) {
			return null;
		}
		
		ListNode p = headA; ListNode q = headB;
		int length1 = 0; int length2 = 0; int diff = 0;
		while (p != null) {
			length1++;
			p = p.next;
		}
		
		while (q != null) {
			length2++;
			q = q.next;
		}
		
		if (length1 > length2) {
			p = headA;
			q = headB;
			diff = length1 - length2;
		} else {
			p = headB;
			q = headA;
			diff = length2 - length1;
		}
		
		for(int i = 0; i < diff; i++) {
			p = p.next;
		}
		
		while (p != null && q != null) {  //core: 将2个单链表同时遍历,减小遍历次数
			if(p.val == q.val) {
				return p;
			}
			
			p = p.next;
			q = q.next;
		}
		
		return null;
	}
	
	//    Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
