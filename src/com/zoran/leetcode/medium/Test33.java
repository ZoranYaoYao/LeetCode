package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ��ת����
 * https://leetcode-cn.com/submissions/detail/6625477/
 * 
 * OT :  ע�������,���ӹ��̵����½ڵ�ı�
 */
public class Test33 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        //ѭ��k��, ��ͷ��ǰ���ƶ�
        ListNode node = head; int count = 1;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        
        //core. �����ʱ����
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
