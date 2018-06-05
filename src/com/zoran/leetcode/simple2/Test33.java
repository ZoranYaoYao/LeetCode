package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/2919617/
 */
public class Test33 {
	
	public static void main(String[] args) {
		ListNode root =new ListNode(1);
		ListNode left =new ListNode(2);
		root.next = left;
		System.out.println(hasCycle(root));
	}

	// �л�����:���һ��Ԫ��һ��ָ��ǰ�������Ԫ��
	// ��ʱ
	public static boolean hasCycle(ListNode head) {
        if(head == null) return false;
        if(head !=null && head.next == null) return true;
            
		List<Integer> list = new ArrayList<>();  //����ռ� O(n)
		while (head != null) {
			list.add(head.val);
			if(head.next != null) {
				head = head.next;
			}else {
				break;
			}

		}
		list.remove((Object)head.val);
		int lastVal = head.val;
		if(list.contains(lastVal)) return true;

		return false;
	}
	
	//core : ����ָ�� , �ܻ�����
	public boolean Nice_hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;
		
		ListNode fast = head, slow = head;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}

	//     Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
