package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 旋转链表
 * https://leetcode-cn.com/submissions/detail/6625477/
 * 
 * OT :  注意对链表,链接过程的上下节点改变
 */
public class Test33 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        //循环k次, 将头往前面移动
        ListNode node = head; int count = 1;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        
        //core. 解决超时问题
        int times = k % count;
        
        for (int i=1; i<=times; i++) {
            ListNode temp = head;
            ListNode iterator = head;
            ListNode pre = head;
            while(iterator.next != null) {
                pre = iterator;
                iterator = iterator.next;
            }
            iterator.next = head;
            pre.next = null;
            head = iterator;
        }
        
        return head;
    }
}
