package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zoran.leetcode.simple2.Test46.ListNode;

/**
 * 反转链表
 * https://leetcode-cn.com/submissions/detail/3209005/
 * 
 * 单链表遍历不好遍历, 没有索引值.
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
	 *  遍历已有单列表, 并创建一个新的倒序链表
	 *  每次创建一个新的下一个节点时 保存该对象,便于下次循环找到上一个对象
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
	 * 迭代遍历: 3个对象(pre, cur, head),改变各个节点的下一个元素
	 * 空间复杂度 O(1) 
	 */
	public static ListNode LeetCode_reverseList(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		
		ListNode pre = head;
		ListNode cur = head.next;
		while (cur != null) {
			pre.next = cur.next;  //Nice_Core pre.next 作为一个零时存储的变量, 最后指向的是末尾5 后面的null
			cur.next = head;  //当前节点的下一个节点是 上次的头位置
			//cur.next = pre;
			head = cur;  //头位置 移至当前节点
			cur = pre.next; //当前节点向后遍历
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
