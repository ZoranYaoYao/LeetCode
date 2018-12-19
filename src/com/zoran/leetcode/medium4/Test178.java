package com.zoran.leetcode.medium4;

import java.util.Arrays;

/**
 * 寻找右区间
 * https://leetcode-cn.com/submissions/detail/10622628/
 *
 * OT
 */
public class Test178 {
    public int[] findRightInterval(Interval[] intervals) {
        //穷举遍历，筛选满足值，并找最大值
        int length = intervals.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                if (intervals[i].end <= intervals[j].start) {
                    if (res[i] == -1)
                        res[i] = j;
                    else {
                        if (intervals[res[i]].start > intervals[j].start) {
                            res[i] = j;
                        }
                    }
                }
            }
        }
        return res;
    }

    //     Definition for an interval.
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
