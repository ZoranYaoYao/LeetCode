package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.List;

/**
 * �ҵ��ճ̰��ű� I
 * https://leetcode-cn.com/submissions/detail/12951793/
 *
 * �����ཻ�жϣ���
 * end > temp[0] && start < temp[1]
 */
public class Test273 {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
//["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
        myCalendar.book(47, 50);
        myCalendar.book(33, 41);
        myCalendar.book(39, 45);
    }


    static class MyCalendar {
        //ѡ����ʵ����ݽṹ
        List<int[]> list;

        public MyCalendar() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            if (list.size() == 0) {
                int[] temp = {start, end};
                list.add(temp);
                return true;
            } else {
                int count = 0;
                for (int i = 0; i < list.size(); i++) {
                    int[] temp = list.get(i);
                    /**����ҳ�2������Ľ���������*/
                    /***/
//                    if (end > temp[0] && start < temp[1]) {
//                        return false;
//                    }
                    if (Math.max(start, temp[0]) > Math.min(end, temp[1])) {
                        return false;
                    }
                }
                list.add(new int[]{start, end});
                return true;
            }
        }
    }
}
