package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * �ָ�����
 * https://leetcode-cn.com/submissions/detail/7079696/
 * 
 * ����:
 * �����б�����next��ֵ������!
 */
public class Test47 {
	
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode node1 = new ListNode(4); root.next = node1;
		ListNode node2= new ListNode(3);  node1.next = node2;
		ListNode node3 = new ListNode(2); node2.next = node3;
		ListNode node4 = new ListNode(5); node3.next = node4;
		ListNode node5 = new ListNode(2); node4.next = node5;

		LeetCode_Test47 test47 = new LeetCode_Test47();
		test47.partition(root, 3);
	}

    public ListNode partition(ListNode head, int x) {
        //Ѱ��x�ڵ�, Ȼ����к������
        if (head == null) return head;
        
        ListNode cusor = head;
        ListNode first = head;
        ListNode second = head;
        
        while (cusor != null) {
            if(cusor.val == x) {
                second = cusor.next;
                //�����: first�б��ǰ�����seconde�Ľڵ�, ���ȥ��??
                break;
            }
            cusor = cusor.next;
        }
        
        ListNode pre = second;
        ListNode secondCusor = second;
        while(secondCusor != null) {
            if(secondCusor.val < x) {
                insert(first, secondCusor);
                pre.next = secondCusor.next; //ɾ��
                pre = secondCusor.next;
            }
            secondCusor = secondCusor.next;
        }
        
        return first;
    }
    
    public void insert(ListNode first, ListNode node) {
        ListNode pre = first;
        ListNode cusor = first;
        
        if(first.val >= node.val) {
            node.next = first;
            first = node;
            return;
        }
        
        boolean insert = false;
        while(cusor != null) {
            if(cusor.val >= node.val) {
                pre.next = node;
                node.next = cusor;
                insert = true;
                break;
            }
            
            pre = cusor;
            cusor = cusor.next;
        }
        
        if(!insert) pre.next = node;
    }
}

class LeetCode_Test47 {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode lessEnd = less;
        ListNode moreEnd = more;
        //1,4,3,2,5,2
        //1->2->2->4->3->5
        for (ListNode n = head; n != null; n = n.next) {
            if (n.val < x) {
                lessEnd.next = new ListNode(n.val); //Core ������һ���ڵ�!!
                lessEnd = lessEnd.next;
            }
            else {
            	//Nice. ����4,3��λ��,ֻҪ��x=3֮ǰ�Ĵ��ڵ�ֵ,Ҳ���ȼ��뵽moreEnd�����е�!!
                moreEnd.next = new ListNode(n.val); //Core ������һ���ڵ�!!
                moreEnd = moreEnd.next;
            }
        }

        lessEnd.next = more.next;
        return less.next;
    }
}
