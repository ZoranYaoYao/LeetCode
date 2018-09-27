package com.zoran.leetcode.medium2;

import java.util.HashMap;

import com.zoran.leetcode.util.NodeTest.RandomListNode;

/**
 * 复制带随机指针的链表
 * https://leetcode-cn.com/submissions/detail/7613659/
 * 
 * [Solution] 
 * https://blog.csdn.net/tmylzq187/article/details/50913211
 * https://blog.csdn.net/zxzxzx0119/article/details/81088775
 * 
 * 通过HashMap 保存对应创建点.
 */
public class Test74 {

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        
        RandomListNode root = new RandomListNode(head.label);
        RandomListNode res = root;
        root.random = head.random;
        root.next = head.next;
        head = head.next;
        while (head != null) {
            RandomListNode node = new RandomListNode(head.label);
            node.random = head.random;  //问题: 要指向新设置的点
            node.next = head.next;
            head = head.next;
            root.next = node;
            root = node;
        }
        
        return res;
    }
}

class Nice_Test74 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode,RandomListNode>map = new HashMap<>();
        RandomListNode copyHead = makeMp(head,map);

        RandomListNode p = head,q = copyHead;
        while(p != null){
            q.random = map.get(p.random);
            p = p.next;
            q = q.next;
        }

        return copyHead;
    }
    
    private RandomListNode makeMp(RandomListNode head, HashMap<RandomListNode, RandomListNode> map) {
        if(head == null) return null;
        RandomListNode copy = new RandomListNode(head.label);
        map.put(head,copy);
        copy.next = makeMp(head.next,map);
        return copy;
    }
}
