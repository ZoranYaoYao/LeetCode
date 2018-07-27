package com.zoran.leetcode.simple4;

/**
 * 622. ���ѭ������
 * https://leetcode-cn.com/problems/design-circular-queue/description/
 * 
 * δ���
 */
public class Test138 {

	
}

class MyCircularQueue {
    private int DEFAULT_SIZE = 10;
 
    private int capacity;// ��������ĳ���
 
    private Integer[] elementData;// ����һ���������ڱ���ѭ�����е�Ԫ��
 
    private int front = 0;// ��ͷ
 
    private int rear = 0;// ��β
    
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        DEFAULT_SIZE = k;
        capacity = DEFAULT_SIZE;
        elementData = new Integer[capacity];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (rear == front && elementData[front] != null) {
            throw new IndexOutOfBoundsException("�����������쳣");
        }
        elementData[rear++] = value;
        // ���rear�Ѿ���ͷ���Ǿ�תͷ
        rear = rear == capacity ? 0 : rear; //Nice
		return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("�ն����쳣");
        }
        // �������е�rear�˵�Ԫ�ص�ֵ
        int oldValue = elementData[front];
        // �ͷŶ��е�rear�˵�Ԫ��
        elementData[front++] = null;
        // ���front�Ѿ���ͷ���Ǿ�תͷ
        front = front == capacity ? 0 : front; //Nice
		return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("�ն����쳣");
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
        //������
    	return false;
    }
}
