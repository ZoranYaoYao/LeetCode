package com.zoran.leetcode.medium5;

/**
 * 设计循环双端队列
 * https://leetcode-cn.com/submissions/detail/12067722/
 *
 * [Solution]
 * https://unclegem.cn/2018/08/21/Leetcode%E5%AD%A6%E4%B9%A0%E7%AC%94%E8%AE%B0-641-%E8%AE%BE%E8%AE%A1%E5%BE%AA%E7%8E%AF%E5%8F%8C%E7%AB%AF%E9%98%9F%E5%88%97/
 *
 * 循环队列： 满足先进先出的原则
 * 循环双端队列：前后端都可以操作
 *
 * 链表一定要注意头尾节点一起赋值！!
 */
public class Test242 {


    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.deleteLast();                    // 返回 true
        circularDeque.deleteFront();
        circularDeque.insertFront(3);// 返回 true
        circularDeque.insertLast(2);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true
        circularDeque.insertFront(3);                    // 返回 true

    }

    static class MyCircularDeque {

        class Node{
            int value;
            Node next;
            Node pre;
            Node(int value) {
                this.value = value;
                next=null;
                pre=null;
            }
        }
        private int maxCap;
        private int numNode;
        private Node front;
        private Node rear;
        //元素存储在lo-hi中，初始化设置hi=lo-1
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            maxCap=k;
            numNode=0;
            front=null;
            rear=null;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (numNode<maxCap){
                Node node=new Node(value);
                if (front==null){
                    front=node;
                    rear=node;
                }
                else {
                    node.next=front;
                    front.pre=node;
                    front=node;
                }
                numNode++;
                return true;
            }
            return false;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (numNode<maxCap){
                Node node=new Node(value);
                if (rear==null){
                    rear=node;
                    front=node;
                }else {
                    rear.next=node;
                    node.pre=rear;
                    rear=node;
                }
                numNode++;
                return true;
            }
            return false;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (numNode==0){
                return false;
            }
            if (front==rear){
                front=null;
                rear=null;
            }else {
                front=front.next;
                front.pre=null;
            }
            numNode--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (numNode==0){
                return false;
            }
            if (front==rear){
                front=null;
                rear=null;
            }else {
                rear=rear.pre;
                rear.next=null;
            }
            numNode--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (numNode==0){
                return -1;
            }
            return front.value;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (numNode==0){
                return -1;
            }
            return rear.value;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return numNode==0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return numNode==maxCap;
        }
    }
}

class Nice_MyCircularDeque {
    class MyCircularDeque {

        int[] queue;
        int front, rear, count;
        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            queue = new int[k];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = front == 0 ? queue.length-1 : front-1;
            queue[front] = value;
            count++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) return false;
            queue[rear] = value;
            rear = (rear+1) % queue.length;
            count++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front+1)%queue.length;
            count--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = rear == 0 ? queue.length-1 : rear-1;
            count--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) return -1;
            return queue[front];
        }

        /** Get the last item from the deque. */
        public int getRear() {
            if (isEmpty()) return -1;
            return rear ==0 ? queue[queue.length-1] : queue[rear-1];
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return count == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return count == queue.length;
        }
    }
}

