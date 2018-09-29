package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 对链表进行插入排序
 * https://leetcode-cn.com/submissions/detail/7701899/
 * 
 * ListNode dummy = new ListNode(-1);的好处
 * 永远指向头指针, 不与头指针引用同一个对象,.
 * eg:
 * 	 ListNode item = head; 不好, 对item,操作同时会对头指针操作
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
      //用一个游标一直指向头结点, 用一个游标进行遍历
        if (head == null) return null;
        dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cusor = head.next;
        head.next = null; //CCore. 将head截断之后, 在进行插入操作
        
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
