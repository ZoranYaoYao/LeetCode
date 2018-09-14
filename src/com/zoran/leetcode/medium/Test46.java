package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 82. ɾ�����������е��ظ�Ԫ�� II
 * https://leetcode-cn.com/submissions/detail/7075614/
 * 
 * �����: nextԪ�ػ��в���Ҫ��Ԫ��,
 * soloution: �����µ��ӽڵ�
 */
public class Test46 {

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(1); root.next = node1;
		ListNode node2= new ListNode(3);  node1.next = node2;
		ListNode node3 = new ListNode(3); node2.next = node3;
		ListNode node4 = new ListNode(4); node3.next = node4;
		ListNode node5 = new ListNode(4); node4.next = node5;
		ListNode node6 = new ListNode(5); node5.next = node6;

		Test46 test46 = new Test46();
		test46.deleteDuplicates(root);
	}

	//�����: nextԪ�ػ��в���Ҫ��Ԫ��,
	//soloution: �����µ��ӽڵ�
	public ListNode deleteDuplicates(ListNode head) {
		//��¼��һ���ڵ�, �����ж��Ƿ�����
		if (head == null || head.next == null) return head;

		ListNode res = null;
		ListNode curRes = null;
		ListNode cusor = head;
		ListNode precusor = null;
		while (cusor != null) {
			if(precusor != null && precusor.val == cusor.val) {
				cusor = cusor.next;
				continue;
			}

			if((cusor.next != null && cusor.next.val != cusor.val) || cusor.next == null) {
				if(curRes == null) {
					curRes = new ListNode(cusor.val);  //Core. �����ͷ�ڵ�����
					res = curRes;
				} else if(curRes.val != cusor.val){
					curRes.next = new ListNode(cusor.val);
					curRes = curRes.next;
				}

			} 
			precusor = cusor;
			cusor = cusor.next;
		}

		return res;
	}
}
