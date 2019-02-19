package com.zoran.leetcode.medium6;

import java.util.*;

/**
 * 我的日程安排表 II
 * https://leetcode-cn.com/submissions/detail/12957872/
 *
 * [Solution]
 * https://blog.csdn.net/qq_35923749/article/details/85811634
 *
 * 如何判定区间否有交集？
 * Math.max(start, over[0]) < Math.min(end, over[1])
 *
 * 如何获取2个区间的交集？
 * int newStart = Math.max(start, booked[0]);
 * int newEnd = Math.min(end, booked[1]);
 */
public class Test274 {

    public static void main(String[] args) {
//        ["MyCalendarTwo","book","book","book","book","book","book"]
//[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20);
        myCalendarTwo.book(50, 60);
        myCalendarTwo.book(10, 40);
        myCalendarTwo.book(5, 15);
        myCalendarTwo.book(5, 10);
        boolean res = myCalendarTwo.book(25, 55);
        System.out.println(res);
    }

    static class MyCalendarTwo {
        //区别，可以多一次交集
        //选择合适的数据结构
        List<int[]> list;

        public MyCalendarTwo() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            int count = 0;
            Map<int[], Integer> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                int[] temp = list.get(i);
                /**如何找出2个区间的交集？？？*/
                if (end > temp[0] && start < temp[1]) {
                    if (map.size() == 0) {
                        map.put(temp, 1);
                        continue;
                    }

                    for (Map.Entry<int[], Integer> item : map.entrySet()) {
                        int[] inner = item.getKey();
                        if (end > inner[0] && start < inner[1]) {
                            int k = 0;
                            if ((k = map.get(inner)) > 1)
                                return false;
                            else {
                                map.put(inner, k + 1);
                            }
                        }
                    }
                }
            }
            list.add(new int[]{start, end});
            return true;
        }
    }
}

class Nice_Test274 {
    public class MyCalendarTwo {
        //NIce_core. 保存第一次相交的区间范围！！
        private List<Integer[]> overList;
        private List<Integer[]> bookedList;

        public MyCalendarTwo() {
            overList = new LinkedList<>();
            bookedList = new LinkedList<>();
        }

        public boolean book(int start, int end) {
            if (start >= end) return false;

            for (Integer[] over : overList) {
                if (Math.max(start, over[0]) < Math.min(end, over[1])) {
                    return false;
                }
            }

            Integer[] temp;
            /**求出与放入bookedList的相交区域的集合！！*/
            for (Integer[] booked : bookedList) {
                int newStart = Math.max(start, booked[0]);
                int newEnd = Math.min(end, booked[1]);
                if (newStart < newEnd) {
                    temp = new Integer[]{newStart, newEnd};
                    overList.add(temp);
                }
            }
            bookedList.add(new Integer[]{start, end});
            return true;
        }
    }


}
