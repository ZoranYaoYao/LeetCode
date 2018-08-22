package com.zoran.leetcode.medium;

import com.zoran.leetcode.util.NodeTest.ListNode;

/**
 * 两数相加
 * https://leetcode-cn.com/submissions/detail/5891070/
 */
public class Test01 {

	//弊端: 第一次root 需要创建>
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //处理进位问题
        int carry = 0;
        int num = l1.val+l2.val;
        if(num >= 10) {
            carry = 1;
            num = num %10;
        }
        ListNode root = new ListNode(num);
        addTwoNumbers0(l1 == null ? null : l1.next, l2 == null? null: l2.next, root, carry);
        
        return root;
    }
    
    public void addTwoNumbers0(ListNode l1, ListNode l2, ListNode root, int carry) {
        if(l1 == null && l2 == null && carry == 0) return;
        int num1 =0; int num2 =0; int acount = 0;
        if(l1 != null) num1 = l1.val;
        if(l2 != null) num2 =l2.val;
        int jinwei = 0; acount = num1+num2+carry;
        if(acount >= 10) {
            jinwei = 1;
            acount = acount %10;
        }
        ListNode sub = new ListNode(acount);
        root.next = sub;
        addTwoNumbers0(l1==null? null: l1.next, l2==null?null:l2.next, sub, jinwei);
    }
}
