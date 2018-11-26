package com.zoran.leetcode.medium4;

import com.zoran.leetcode.util.NodeTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 链表随机节点
 * https://leetcode-cn.com/submissions/detail/9763079/
 */
public class Test151 {

    class Solution {
        //使用Arraylist 进行随机访问
        List<Integer> list = new ArrayList<>();

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(NodeTest.ListNode head) {
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
        }

        /** Returns a random node's value. */
        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }
}
