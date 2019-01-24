package com.zoran.leetcode.medium5;

import java.util.Arrays;

/**
 * 设计循环队列
 * https://leetcode-cn.com/submissions/detail/12024293/
 *
 * 循环队列，header，tail 进行位移
 */
public class Test237 {
    class MyCircularQueue {

        //ArrayQueue 循环列表的设计
        int[] arr;
        int total;
        int size;
        int header, tail=-1;

        /** Initialize your data structure here. Set the size of the queue to be k. */
        public MyCircularQueue(int k) {
            arr = new int[k];
            Arrays.fill(arr, -1);
            total = arr.length;
        }

        /** Insert an element into the circular queue. Return true if the operation is successful. */
        public boolean enQueue(int value) {
            if ((size + 1) > total) return false;

            int next = (tail+1) % total;
            arr[tail=next] = value;
            size++;
            return true;
        }

        /** Delete an element from the circular queue. Return true if the operation is successful. */
        public boolean deQueue() {
            if (size-1 < 0) return false;

            arr[header++] = -1;
            size--;
            return true;
        }

        /** Get the front item from the queue. */
        public int Front() {
            return arr[header];
        }

        /** Get the last item from the queue. */
        public int Rear() {
            return arr[tail];
        }

        /** Checks whether the circular queue is empty or not. */
        public boolean isEmpty() {
            return size == 0;
        }

        /** Checks whether the circular queue is full or not. */
        public boolean isFull() {
            return size == total;
        }
    }
}
