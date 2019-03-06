package com.zoran.algorithm.classic_problem;


import com.zoran.leetcode.util.ListNode;

import java.util.List;

public class ��ת���� {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2); root.next = node1;
        ListNode node2= new ListNode(3);  node1.next = node2;
        ListNode node3 = new ListNode(4); node2.next = node3;

        ListNode head = reverse(root);
        System.out.println(head);
    }

    /**
     * ��ת������ͨ��cusor��temp2����ʱ�������е���ת����
     */
    public static ListNode reverse(ListNode root) {
        ListNode cusor = root.next;
        root.next = null;
        while (cusor != null) {
            ListNode temp = cusor.next;
            cusor.next = root;
            root = cusor;
            cusor = temp;
        }
        return root;
    }
}
