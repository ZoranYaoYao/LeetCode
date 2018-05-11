package com.zoran.leetcode;

import com.sun.corba.se.spi.ior.TaggedProfileTemplate;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
 * 思路:
 *  第二个链表插入到第一个链表 (base 第一条)
 * @author Zoran
 *
 */
public class Test05 {
	
	public static void main(String[] args) {
		ListNode aListNode = new ListNode(1);
		ListNode bListNode = new ListNode(2);aListNode.next = bListNode;
		ListNode cListNode = new ListNode(4);bListNode.next = cListNode;
		
		ListNode zListNode = new ListNode(1);
		ListNode xListNode = new ListNode(3);zListNode.next = xListNode;
		ListNode vListNode = new ListNode(4);xListNode.next = vListNode;
		
		ListNode listNode = mergeTwoLists(aListNode,zListNode);
		
		StringBuilder str = new StringBuilder();
		ListNode tmp = listNode;
		do {
			str.append(tmp.val).append("->"); 
			tmp = listNode.next;
			listNode = listNode.next;
		} while (tmp != null);
		
		System.out.println(str.substring(0, str.length() - 2));
	}
	
	/**
	 *  问题: 2数选最小的, while 的判断条件有问题!
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoListsError(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode indexl1 = l1;
		ListNode indexl2 = l2;
		ListNode nextpoint = new ListNode(-1);
		
		while(indexl1 != null) { //-->wrong
			while (indexl2 != null) {
				if(indexl1.val <= indexl2.val) {
					nextpoint.next = indexl1;
					indexl1 = indexl1.next;
					nextpoint = nextpoint.next;
					break;
				} else {
					nextpoint.next = indexl2;
					indexl2 = indexl2.next;
					nextpoint = nextpoint.next;
				}
			}
		}
		
		return nextpoint.next;
    }
	
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode indexl1 = l1;
		ListNode indexl2 = l2;
		ListNode point = head;
		
		int val1; int val2;
		while (indexl1 != null || indexl2 != null) {
			//判断null值
			val1 = Integer.MAX_VALUE;
			val2 = Integer.MAX_VALUE;
			if(indexl1 != null) {
				val1 = indexl1.val;
			}
			if (indexl2 != null) {
				val2 = indexl2.val;
			}
			
			if(val1 <= val2) {
				point.next = indexl1;
				indexl1 = indexl1.next;
			} else {
				point.next = indexl2;
				indexl2 = indexl2.next;
			}
			point = point.next;
		}
		
		//nice code , piont,head 开始指向一个地址
		// point -> 指向下一个 next的地址 , head保持不变, point点在遍历!
		return head.next;  
    }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}