package com.zoran.leetcode.medium4;

import java.util.Random;

/**
 * ��Բ��������ɵ�
 * https://leetcode-cn.com/submissions/detail/10919667/
 *
 * [Solution]
 * https://www.cnblogs.com/liaohuiqiang/p/9858394.html
 */
public class Test196 {

    class Solution {
        double radius;
        double x_center;
        double y_center;
        public Solution(double radius, double x_center, double y_center) {
            this.radius = radius;
            this.x_center = x_center;
            this.y_center = y_center;
        }

        public double[] randPoint() {
            while (true) {
                //Nice_Core. �������[-1, 1]�µķ�Χ  -> -r + 2*random*r �ͻ�����[-r,r]�ķ�Χ�� ��-1+2*random��*r
                double x = x_center - radius + new Random().nextDouble()*radius*2;
                double y = y_center - radius + new Random().nextDouble()*radius*2;
                double d = Math.pow(x-x_center,2) + Math.pow(y-y_center,2);
                if (d <= radius*radius) return new double[]{x,y};
            }
        }
    }
}
