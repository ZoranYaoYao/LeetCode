package com.zoran.leetcode.medium2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/7702380/
 */
public class Test80 {

    public ListNode sortList(ListNode head) {
        //ת�����б�����, Ȼ�����ɶ�Ӧ�Ľ��  
        if (head == null) return null;
        List<Integer> list = new ArrayList<>();
        ListNode cusor = head;
        while (cusor != null) {
            list.add(cusor.val);
            cusor = cusor.next;
        }
        
        Collections.sort(list);
        
        ListNode pre = null;
        ListNode res = null;
        for (int i=0; i<list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            if(pre == null) {
              pre = node;  
              res = node; 
            } else {
                pre.next = node;
                pre = node;
            }
        }
        
        return res;
    }
}
