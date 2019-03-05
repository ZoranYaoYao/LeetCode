package com.zoran.leetcode.simple6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 最接近原点的 K 个点
 * https://leetcode-cn.com/submissions/detail/13920268/
 */
public class Test233 {

    public int[][] kClosest(int[][] points, int K) {
        //针对集合排序
        Arrays.sort(points, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                //o1在后
                int diff1 = (int) (Math.pow(o1[0],2) + Math.pow(o1[1],2));
                int diff2 = (int) (Math.pow(o2[0],2) + Math.pow(o2[1],2));
                return diff1 - diff2;
            }
        });

        int[][] res = new int[K][2];
        for (int i=0; i<K; i++) {
            for (int j=0; j<2; j++) {
                res[i][j] = points[i][j];
            }
        }

        return res;
    }
}
