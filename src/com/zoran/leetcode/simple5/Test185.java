package com.zoran.leetcode.simple5;

/**
 * 最大三角形面积
 * https://leetcode-cn.com/submissions/detail/5618412/
 * 
 * [Solution]
 * http://www.sohu.com/a/147750295_654760
 * https://blog.csdn.net/zhangzhetaojj/article/details/80724866
 */
public class Test185 {

    public double largestTriangleArea(int[][] points) {
        double area = 0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points) {
                    area = Math.max(area, 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]));
                }
            }
        }
        return area;
    }
}
