package com.zoran.leetcode.medium4;

import java.util.*;

/**
 * 无重叠区间
 * https://leetcode-cn.com/submissions/detail/10621876/
 *
 * [Solution]
 * https://blog.csdn.net/qq_36946274/article/details/81591172
 *
 * 数学归纳法
 */
public class Test177 {
    /**
     * [[1,100],[11,22],[1,11],[2,12]]
     * 不能从最大开始删除，算法有问题。
     */
    public int eraseOverlapIntervals(Interval[] intervals) {
        //排序区间，每次都删除最大区间
        List<Interval> list = new ArrayList<>();
        for (Interval item : intervals)
            list.add(item);
        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                int i1 = o1.end - o1.start;
                int i2 = o2.end - o2.start;
                return i2 - i1;
            }
        });
        int res = 0;
        boolean[] mark = new boolean[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (isOverLap(mark, i, list)) {
                res++;
                mark[i] = true;
            }
        }

        return res;
    }

    public boolean isOverLap(boolean[] mark, int index, List<Interval> list) {
        Interval cur = list.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (i == index) continue;
            if (list.get(i).start < cur.end && list.get(i).end > cur.start) return true;
        }
        return false;
    }

    //      Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}

class Nice_Test177 {
    public int eraseOverlapIntervals(Test177.Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<Test177.Interval>() {
            @Override
            public int compare(Test177.Interval o1, Test177.Interval o2) {
                return o1.end - o2.end; //Nice_Core 按end位置进行升序排列
            }
        });
        int length = intervals.length;
        int count =1;
        int last = 0;
        for (int i=1; i<length; i++) {
            if (intervals[last].end <= intervals[i].start) {
                count++;
                last = i;
            }
        }
        return length - count;
    }
}























