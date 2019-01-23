package com.zoran.leetcode.medium5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 有效的正方形
 * https://leetcode-cn.com/submissions/detail/11979602/
 *
 * 数学
 */
public class Test233 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //计算边长是否相等
        if (Arrays.equals(p1,p2) || Arrays.equals(p1,p3) || Arrays.equals(p1,p4) || Arrays.equals(p2,p3) ||
                Arrays.equals(p2,p4) || Arrays.equals(p3,p4)) return false;

        Map<Integer, Integer> map = new HashMap<>();
        int p12 = (int) (Math.pow(p2[0]-p1[0],2) + Math.pow(p2[1]-p1[1],2)); map.put(p12,map.getOrDefault(p12,0)+1);
        int p13 = (int) (Math.pow(p3[0]-p1[0],2) + Math.pow(p3[1]-p1[1],2)); map.put(p13,map.getOrDefault(p13,0)+1);
        int p14 = (int) (Math.pow(p4[0]-p1[0],2) + Math.pow(p4[1]-p1[1],2)); map.put(p14,map.getOrDefault(p14,0)+1);
        int p23 = (int) (Math.pow(p3[0]-p2[0],2) + Math.pow(p3[1]-p2[1],2)); map.put(p23,map.getOrDefault(p23,0)+1);
        int p24 = (int) (Math.pow(p4[0]-p2[0],2) + Math.pow(p4[1]-p2[1],2)); map.put(p24,map.getOrDefault(p24,0)+1);
        int p34 = (int) (Math.pow(p4[0]-p3[0],2) + Math.pow(p4[1]-p3[1],2)); map.put(p34,map.getOrDefault(p34,0)+1);

//        System.out.println(map.size());
        return map.size() == 2;
    }
}
