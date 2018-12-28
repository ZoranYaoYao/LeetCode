package com.zoran.leetcode.medium5;

/**
 * 提莫攻击
 * https://leetcode-cn.com/submissions/detail/10976986/
 */
public class Test201 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11,13,15}; //20 17
        Test201 test201 = new Test201();
        int res = test201.findPoisonedDuration(nums, 3);
        System.out.println(res);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //时间的重叠计算，如果重叠，直接重新0开始计算
        int res = 0;
        int endTime = 0;
        for (int i=0; i<timeSeries.length; i++) {
            if (endTime == 0) endTime = timeSeries[i] + duration;
            int nextStart = Integer.MAX_VALUE; //Core 下一次开始的时间，默认取最大值，保证最后一个元素可行
            if (i+1 < timeSeries.length) nextStart = timeSeries[i+1];

            if (endTime <= nextStart) {
                res +=duration;
            } else {
                res += nextStart - timeSeries[i];
            }
            endTime = nextStart + duration; //Nice_Core!! 无论重叠与否，都是下一个节点开始时间+间隔时间
            System.out.println("res = " + res); //这个会出现耗时操作
        }

        return res;
    }
}
