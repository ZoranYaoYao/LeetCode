package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ��������в�������
 * https://leetcode-cn.com/submissions/detail/7701899/
 * 
 * ListNode dummy = new ListNode(-1);�ĺô�
 * ��Զָ��ͷָ��, ����ͷָ������ͬһ������,.
 * eg:
 * 	 ListNode item = head; ����, ��item,����ͬʱ���ͷָ�����
 */
public class Test79 {
	
	public static void main(String[] args) {
		Test79 test79 = new Test79();
		ListNode root = new ListNode(4);
		ListNode node1 = new ListNode(3); root.next = node1;
		ListNode node2= new ListNode(2);  node1.next = node2;
		ListNode node3 = new ListNode(1); node2.next = node3;
//		ListNode node4 = new ListNode(4); node3.next = node4;
		ListNode res = test79.insertionSortList(root);
		System.out.println(res);
	}

    public ListNode dummy;
    public ListNode insertionSortList(ListNode head) {
      //��һ���α�һֱָ��ͷ���, ��һ���α���б���
        if (head == null) return null;
        dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cusor = head.next;
        head.next = null; //CCore. ��head�ض�֮��, �ڽ��в������
        
        while(cusor != null) {
            ListNode temp = cusor;
            cusor = cusor.next;
            temp.next = null;
            insert(dummy.next, temp);
        }
        
        return dummy.next;
    }
    
    public void insert(ListNode head, ListNode item) {
        ListNode pre = head;
        if(item.val <= head.val) {
            item.next = head;
            head = item; 
            dummy.next = head;
            return;
        }
        
        boolean inserted = false;
        while (head != null) {
            if(item.val >= head.val) {
                pre = head;
                head = head.next;
            } else {
                pre.next = item;
                item.next = head;
                inserted = true;
                break;
            }
        }
        
        if(!inserted) {
            pre.next = item;
        }
    }
}
