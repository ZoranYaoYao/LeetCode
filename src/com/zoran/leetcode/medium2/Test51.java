package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 反转链表 II
 * https://leetcode-cn.com/submissions/detail/7189160/
 * 
 * [Solution]
 * https://blog.csdn.net/xygy8860/article/details/47074087
 * 
 * 单列表 需要用一些变量来标记位置
 */
public class Test51 {

}

class Nice_Test51 {
	//利用链表旋转 实现反转
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode first = new ListNode(0);
		//头结点,方便统一处理
		first.next = head;
		
		ListNode temp = null;
		ListNode p = null;
		ListNode pHead = first; //不需要反转的最后一个节点  //Core. 纪录位置
		ListNode pLast = null; //需要反转节点的第一个节点, 将反转到最后 //Core. 纪录位置
		
		int len =0;
		while (head != null) {
			if (++len < m) {
				pHead = head; //纪录未变动的节点末位值, 例如题中1
				head = head.next;
			} else if (len == m) {
				//纪录开始位置
				p = pLast = head;
				head = head.next;
				pLast.next = null; // 此句很重要, 斩断之后的链接
			} else if (len>=m && len<=n) {
				//新插入节点
				temp = head;
				head = head.next;
				temp.next = p;
				pHead.next = p;
			} else if (len>n) {
				pLast.next = head;
				break;
			}
		}
		
		return first.next;
	}
}
