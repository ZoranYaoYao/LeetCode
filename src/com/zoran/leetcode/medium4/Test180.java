package com.zoran.leetcode.medium4;

import com.zoran.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 两数相加 II
 * https://leetcode-cn.com/submissions/detail/10625618/
 *
 * [Solution]
 * https://blog.csdn.net/u010002184/article/details/76775409
 */
public class Test180 {

    /**
     * 算法正确，但是leetCode执行结果错误？
     * [3,9,9,9,9,9,9,9,9,9]
     * [7]
     */
    public static void main(String[] args) {
        ListNode root = new ListNode(3);
        ListNode node1 = new ListNode(9); root.next = node1;
        ListNode node2= new ListNode(9);  node1.next = node2;
        ListNode node3 = new ListNode(9); node2.next = node3;
        ListNode node4 = new ListNode(9); node3.next = node4;
        ListNode node5 = new ListNode(9); node4.next = node5;
        ListNode node6 = new ListNode(9); node5.next = node6;
        ListNode node7 = new ListNode(9); node6.next = node7;
        ListNode node8 = new ListNode(9); node7.next = node8;

        ListNode root2 = new ListNode(7);
        Test180 test180 = new Test180();
        test180.addTwoNumbers(root, root2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先转换成数字， 然后在相加
        int num1 = 0;
        int num2 = 0;

        while(l1 != null) {
            num1 = num1*10 + l1.val;
            l1 = l1.next;
        }
        while(l2 != null) {
            num2 = num2*10 + l2.val;
            l2 = l2.next;
        }
        int count = num1 + num2;
        List<Integer> list = new ArrayList<>();
        while(count != 0) {
            int temp = count % 10;
            list.add(0, temp);
            count = count / 10;
        }
        if (list.size() == 0) return new ListNode(0);

        ListNode res = new ListNode(list.get(0));
        ListNode cur = res;
        for (int i=1; i<list.size(); i++) {
            ListNode node = new ListNode(list.get(i));
            cur.next = node;
            cur = node;
        }

        return res;
    }
}

class Nice_Test180 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>(); //Core. 用栈弹出的方式计算
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        ListNode cur = new ListNode(0);
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            cur.val = sum % 10;
            ListNode head = new ListNode(sum/10);
            head.next = cur;
            cur = head;
            sum /= 10; //Nice_Core 复用sum，用来进位
        }
        return cur.val == 0 ? cur.next : cur;
    }
}






























