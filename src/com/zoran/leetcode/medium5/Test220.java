package com.zoran.leetcode.medium5;

import java.util.Collections;
import java.util.List;

/**
 * 最小时间差
 * https://leetcode-cn.com/submissions/detail/11741473/
 *
 * 真正的FT
 */
public class Test220 {
    public int findMinDifference(List<String> timePoints) {
        //排序 +穷举遍历
        if (timePoints == null || timePoints.size() <= 1) return 0;

        Collections.sort(timePoints);
        int res = Integer.MAX_VALUE;
        for (int i=1; i<timePoints.size(); i++) {
            int value = diff(timePoints.get(i), timePoints.get(i-1));
            res = Math.min(res, value);
        }

        int zero = diff(timePoints.get(timePoints.size()-1), timePoints.get(0));
        zero = 24*60 - zero;
        res = Math.min(res, zero);

        return res;
    }

    private int diff(String next, String cur) {
        String[] nextTime = next.split(":");
        int big = Integer.valueOf(nextTime[0]) * 60 + Integer.valueOf(nextTime[1]);
        String[] curTime = cur.split(":");
        int small = Integer.valueOf(curTime[0]) * 60 + Integer.valueOf(curTime[1]);
        return big - small;
    }
}
