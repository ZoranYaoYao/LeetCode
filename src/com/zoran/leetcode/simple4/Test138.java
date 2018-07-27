package com.zoran.leetcode.simple4;

/**
 * 622. 设计循环队列
 * https://leetcode-cn.com/problems/design-circular-queue/description/
 * 
 * 未解决
 */
public class Test138 {

	
}

class MyCircularQueue {
    private int DEFAULT_SIZE = 10;
 
    private int capacity;// 保存数组的长度
 
    private Integer[] elementData;// 定义一个数组用于保存循环队列的元素
 
    private int front = 0;// 队头
 
    private int rear = 0;// 队尾
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        DEFAULT_SIZE = k;
        capacity = DEFAULT_SIZE;
        elementData = new Integer[capacity];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (rear == front && elementData[front] != null) {
            throw new IndexOutOfBoundsException("队列已满的异常");
        }
        elementData[rear++] = value;
        // 如果rear已经到头，那就转头
        rear = rear == capacity ? 0 : rear; //Nice
		return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        // 保留队列的rear端的元素的值
        int oldValue = elementData[front];
        // 释放队列的rear端的元素
        elementData[front++] = null;
        // 如果front已经到头，那就转头
        front = front == capacity ? 0 : front; //Nice
		return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("空队列异常");
        }
        return elementData[front];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        return elementData[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return rear == front && elementData[rear] == null;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        //有问题
    	return false;
    }
}
