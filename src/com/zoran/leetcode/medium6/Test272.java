package com.zoran.leetcode.medium6;

import com.zoran.leetcode.util.ListNode;

/**
 * 分隔链表
 * https://leetcode-cn.com/submissions/detail/12760753/
 */
public class Test272 {

    public static void main(String[] args) {
        Test272 test272 = new Test272();
        ListNode root = new ListNode(1);
        ListNode node1 = new ListNode(2); root.next = node1;
        ListNode node2 = new ListNode(3); node1.next = node2;
        ListNode node3 = new ListNode(4); node2.next = node3;
        ListNode node4 = new ListNode(5); node3.next = node4;
        ListNode node5 = new ListNode(6); node4.next = node5;
        ListNode node6 = new ListNode(7); node5.next = node6;
        ListNode[] res = test272.splitListToParts(root, 3);
        System.out.println(res);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        //除法之后，余下又分配到其他位置
        int len = 0;
        ListNode cursor = root;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }

        int everyLen = len / k;
        int extra = len % k;

        ListNode[] res = new ListNode[k];
        int cur = 0;
        while (root != null) {
            int temp = everyLen;
            if (extra > 0) {
                extra--;
                temp += 1;
            }

            ListNode item = new ListNode(root.val);
            ListNode head = item;
            root = root.next;
            temp--;
            while (temp > 0) {
                ListNode next = new ListNode(root.val);
                root = root.next;
                item.next = next;
                item = next;
                temp--;
            }
            res[cur++] = head;
            k--;
        }

        return res;
    }
}
