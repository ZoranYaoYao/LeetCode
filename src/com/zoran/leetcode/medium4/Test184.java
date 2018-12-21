package com.zoran.leetcode.medium4;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 用最少数量的箭引爆气球
 * https://leetcode-cn.com/submissions/detail/10712130/
 *
 * [Solution]
 * https://blog.csdn.net/conniewu/article/details/80041067
 *
 * 1. 左端排序
 * 2. 求每一次的左端交集区间，进行比较，如果不在区间里，则需要多加一个弓箭手
 */
public class Test184 {

    public static void main(String[] args) {
        int[][] nums = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        Test184 test184 = new Test184();
        int res = test184.findMinArrowShots(nums);
        System.out.println(res);
    }

    /**
     * [[9,12],[1,10],[4,11],[8,12],[3,9],[6,9],[6,7]]
     * 测不过，算法有问题
     */
    public int findMinArrowShots(int[][] points) {
        //起始点进行排序，如果重合则去除，直到末尾
        if(points == null || points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1]; //Core 开始点升序,结束点也是升序！
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int res = 0;
        int[] cur = points[0];
        for(int i=0; i<points.length; i++) {
            if (points[i][0] > cur[1]) { //起始点>当前结束点
                res++;  //射出以前的气球
                cur = points[i];
            }

//            if (cur == points[points.length-1])
        }
        return ++res;
    }
}

class Nice_Test184 {
    /**
     * 1. 左端排序
     * 2. 求每一次的左端交集区间，进行比较，如果不在区间里，则需要多加一个弓箭手
     */
    public int findMinArrowShots(int[][] points) {
        int len1 = points.length;
        if (len1 <1) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int arr_num = 0;
        int[] shoot = new int[points[0].length];
        shoot[0] = points[0][0];
        shoot[1] = points[0][1]; //Nice_Core 那一个一维数组存储每一次的交集区间！！
        for (int i =1; i<len1; i++) {
            //起始点<交集右端，由于左排序，所以一定相交！！
            if (points[i][0] <= shoot[1]) {
                shoot[0] = points[i][0];
                //Core 缩小交集范围
                if (shoot[1] > points[i][1]) {
                    shoot[1] = points[i][1];
                }
            } else {
                arr_num++;
                shoot[0] = points[i][0];
                shoot[1] = points[i][1];
            }
        }
        return ++arr_num;
    }
}



























