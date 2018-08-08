package com.zoran.leetcode.simple5;

import java.util.LinkedList;

/**
 * 设计链表
 * https://leetcode-cn.com/submissions/detail/5265582/
 */
public class Test165 {

}

class MyLinkedList {
    // ArrayDeque<Integer> queue; 没有get()方法
    LinkedList<Integer> list = new LinkedList<>();
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        // queue = new ArrayDeque<>();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
       return index >= list.size() ? -1 : list.get(index); //注意索引值的有效性
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        list.offerFirst(val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        list.offer(val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < list.size()) { //注意索引值的有效性
            list.add(index, val); 
        } else if (index == list.size()) {
            list.offer(val);
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < list.size()) { //注意索引值的有效性
            list.remove(index);
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
