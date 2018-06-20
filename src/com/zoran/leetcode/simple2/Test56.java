package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/3333947/
 * 
 * [Solution]
 * https://blog.csdn.net/u012249528/article/details/47124771
 */
public class Test56 {
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode item1 = new ListNode(2); root.next = item1;
		ListNode item2 = new ListNode(2); item1.next = item2;
		ListNode item3 = new ListNode(1); item2.next = item3;
//		ListNode item4 = new ListNode(1); item3.next = item4;
//		ListNode item5 = new ListNode(2); item4.next = item5;
//		ListNode item6 = new ListNode(1); item5.next = item6;
		boolean flag = NNice_isPalindrome(root);
		System.out.println(flag);
	}
	
	/**
	 * �����߼�����
	 * LeetCodeͨ��, ����  Error: 121 33333 121 case����ͨ��
	 */
    public static boolean isPalindrome(ListNode head) {
    	if(head == null) return true;
    	if(head.next == null) return true;
    	
        LinkedList<Integer> stack = new LinkedList<>();
        boolean middle = false;
        while(head != null) {
        	if(stack.peek() == null || head.val != stack.peek()) {
        		if(!stack.contains(head.val)) {
                    stack.addFirst(head.val);
        		} else {
        			int currentVal = stack.peek();int lastVal = stack.peek();
            		while(stack.peek() != head.val) {   //core: ����1,3,4,4,1��case, �ҵ��м�444..n�� �����ж�
            			lastVal = stack.peek();
            			stack.pop();
            			currentVal = stack.peek();
            			if (currentVal != lastVal && currentVal != head.val) {
            				return false;
            			}
            		}
            		stack.pop();
        		}
            } else if(head.val == stack.peek()) {
            	if(stack.contains(head.val) && head.next != null) {  //core: head.next != null ��ʾ�����ݲ�������ĩβ. �������м䴦��������
            		stack.addFirst(head.val);
            	} else {
                    stack.pop();
            	}

            }
        	
        	head = head.next;
        }
        
        return stack.size() == 0 ? true: false;
    }

    /**
     * ������ṹ ת���������б�ṹ, �ڽ���ǰ���α��ж� 
     */
    public static boolean Nice_isPalindrome(ListNode head) {
        ArrayList<ListNode> arr = new ArrayList();
        while (head!=null){
            arr.add(head);
            head = head.next;
        }
        int i = 0 , j = arr.size() -1;
        while (i < j){
            ListNode iNode = arr.get(i++);
            ListNode jNode = arr.get(j--); //Core
            if (iNode.val != jNode.val)
                return false;
        }
        return true;
    }

    /**
     * Core:����ָ��, �����ҵ��м�Ľڵ� 
     */
    public static boolean NNice_isPalindrome(ListNode head) {
        Stack<ListNode> stack=new Stack<>();  
        ListNode slow=head;  
        ListNode fast=head; 
        
        if (fast == null || fast.next == null) return true; //0���ڵ����1���ڵ�  
        
        stack.push(slow);
        while (fast.next != null && fast.next.next != null) {
        	fast = fast.next.next;
        	slow = slow.next;
        	stack.push(slow);
        }
        
        if (fast.next != null) { //������Ϊż��
			slow = slow.next;
		}
        ListNode cur = slow;
        while (cur != null) {
        	if (cur.val != stack.pop().val) return false;
        	cur = cur.next;
        }
        
        return true;
    }
    
//    Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
