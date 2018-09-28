package com.zoran.leetcode.medium2;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/7666313/
 * 
 * OT!!!
 * ���ݽ�� �ҳ���Ҫ����Ĵ����Ѿ�λ��
 */
public class Test77 {

    int size;
    public void reorderList(ListNode head) {
        //������ĩ�����в���
        //��������
        // nΪ���� n/2
        // nΪż�� (n-1)/2

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
        
        //��β���ǰһ����
        
        ListNode temp = curNode.next;
        curNode.next = endNode;
        endNode.next = temp;
        pre.next = null;
    }
}
