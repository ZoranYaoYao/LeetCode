package com.zoran.leetcode.medium3;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 奇偶链表
 * https://leetcode-cn.com/submissions/detail/8909538/
 * 
 * [Solution]
 * https://blog.csdn.net/NoMasp/article/details/50535947
 *
 * 以后针对原地算法, 暂不考虑, 先实现在说
 */
public class Test131 {
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(2); root.next = node1;
		ListNode node2= new ListNode(3);  node1.next = node2;
		ListNode node3 = new ListNode(4); node2.next = node3;
		ListNode node4 = new ListNode(5); node3.next = node4;
		

		Test131 test131 = new Test131();
		test131.oddEvenList(root);
	}

	//1,2,3,4,5
	//指针之间要脱离链接,在添加!!
    public ListNode oddEvenList(ListNode head) {
        //直接遍历,区分奇,偶节点
        ListNode iterator = head;
        boolean isDoubleTimes = false;
        ListNode pre = null;
        while (iterator != null) {
            ListNode second = iterator.next;
            if (!isDoubleTimes) {
                if (pre == null) pre = iterator;
                iterator = second;
                isDoubleTimes = true;
            } else {
                if (second != null) { //偶数次
                	ListNode temp2 = pre.next; //纪录上一次节点next值
                    ListNode third = second.next;
                    pre.next = second;
                    second.next = temp2;
                    pre = second;
                    
                    ListNode temp = third;
                    second.next = iterator;
                    iterator.next = temp;
                    iterator = third;
                } else {
                	ListNode temp2 = pre.next; //纪录上一次节点next值
                	pre.next = iterator;
                	iterator.next = temp2;
                	pre = iterator;
                	iterator = iterator.next;
                }
                isDoubleTimes = false;
            }
        }
        
        return head;
    }
}


class Nice_Test131 {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) return head;
		ListNode odd = head;
		ListNode even = head.next;
		ListNode evenHead = even;
		while (odd.next != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
		return head;
	}
}
