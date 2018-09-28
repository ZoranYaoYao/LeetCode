package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 重排链表
 * https://leetcode-cn.com/submissions/detail/7666313/
 * 
 * OT!!!
 * 根据结点 找出需要插入的次数已经位置
 */
public class Test77 {

    int size;
    public void reorderList(ListNode head) {
        //遍历到末结点进行插入
        //遍历次数
        // n为奇数 n/2
        // n为偶数 (n-1)/2

        ListNode cusor = head;
        while(cusor != null) {
            size++;
            cusor = cusor.next;
        }
        
        //insert
        int count = size %2 == 0 ? (size-1)/2 : size/2;
        ListNode curNode = head;
        for (int i =1; i<= count; i++) {
            insert(curNode);
            curNode = curNode.next.next;
        }
        
    }
    
    public void insert(ListNode curNode) {
        ListNode endNode = curNode;
        while(endNode!=null && endNode.next != null && endNode.next.next != null) {
            endNode = endNode.next;
        }
        ListNode pre = endNode;
        endNode = endNode.next;
        
        //找尾结点前一个数
        
        ListNode temp = curNode.next;
        curNode.next = endNode;
        endNode.next = temp;
        pre.next = null;
    }
}
