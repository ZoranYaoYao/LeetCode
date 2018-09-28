package com.zoran.leetcode.medium2;

import java.util.HashSet;
import java.util.Set;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * �������� II
 * https://leetcode-cn.com/submissions/detail/7663746/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_26410101/article/details/80430411
 * 
 * 2(x+y)=x+y+z+y ��ʽ�ƶϵó�����
 */
public class Test76 {

	//ͨ��
    public ListNode detectCycle(ListNode head) {
        //����HashSet�������,����Ѿ�����, ˵����ʼ�ظ�
        if (head == null) return null;
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if(!set.add(head)) return head;
            head = head.next;
        }
        
        return null;
    }
}

class LeetCode_Test76 {
	//
	public ListNode detectCycle(ListNode head) {
		if (head == null) return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			while (slow == fast) {
				slow =head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
			
		}
		
		return null;
	}
}
