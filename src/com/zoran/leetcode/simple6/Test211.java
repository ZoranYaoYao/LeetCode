package com.zoran.leetcode.simple6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 数据流中的第K大元素
 * https://leetcode-cn.com/submissions/detail/13015810/
 *
 * [Solution]
 * https://blog.csdn.net/qq_38765867/article/details/84146811
 */
public class Test211 {

    public static void main(String[] args) {
//        ["KthLargest","add","add","add","add","add"]
//[[1,[]],[-3],[-2],[-4],[0],[4]]
        int k = 1;
        int[] arr = new int[2];
        KthLargest kthLargest = new KthLargest(k, arr);
        kthLargest.add(-3);   // returns 4
        kthLargest.add(-2);   // returns 5
        kthLargest.add(-4);  // returns 5
        kthLargest.add(0);   // returns 8
        kthLargest.add(4);   // returns 8
    }

    /**
     * 8 / 10 个通过测试用例
     * 状态：超出时间限制
     * 大批量添加时，会超时
     *
     * LinkedList get(index) 产生了耗时
     * 换成ArrayList就不会超时了！
     */
    static class KthLargest {

        //数值排序插入， 利用LinkedList
        int k;
        LinkedList<Integer> list = new LinkedList<>();
        public KthLargest(int k, int[] nums) {
            this.k = k;
            Arrays.sort(nums);
            for (int item : nums) {
                list.add(0, item);
            }
        }

        public int add(int val) {
            for (int i=0; i<list.size(); i++) {
                if (val>list.get(i)) {
                    list.add(i,val);
                    break;
                }

                if (i == list.size()-1) {
                    list.add(val);
                    break;
                }

            }

            return list.get(k);
        }
    }
}

class Nice_Test211 {
    class KthLargest {
        PriorityQueue<Integer> pq;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>(k);
            for (int i : nums) {
                add(i);
            }
        }

        private int add(int val) {
            if (pq.size() < k) {
                pq.offer(val);
            } else {
                //Nice_Core 通过构建一个只有k个元素的极小堆！！
                if (pq.peek() < val) {
                    pq.poll();
                    pq.offer(val);
                }
            }

            return pq.peek();
        }
    }



}
