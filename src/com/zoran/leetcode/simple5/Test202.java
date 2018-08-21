package com.zoran.leetcode.simple5;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ������м���
 * https://leetcode-cn.com/submissions/detail/5841651/
 */
public class Test202 {

    public ListNode middleNode(ListNode head) {
        //û������ֵ
        int size = 0;
        ListNode temp = head;
        while(temp != null) {
            size++;
            temp = temp.next;
        }
        
        int middle = size/2 +1;
        while (head != null) {
            middle--;
            if(middle == 0) return head;
            head = head.next;
        }
        
        return head;
    }
}
