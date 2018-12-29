package com.zoran.leetcode.medium5;

import java.util.Random;

/**
 * 非重叠矩形中的随机点
 * https://leetcode-cn.com/submissions/detail/10978475/
 *
 * [Solution]
 * https://www.cnblogs.com/jasminemzy/p/9741842.html
 *
 * 概率数学，了解即可
 */
public class Test202 {
    class Solution {

        private int[][] rects;
        private Random rd;
        private int[] sum;
        private int total;

        public Solution(int[][] rects) {
            this.rects = rects;
            this.rd = new Random();
            int[] weight = new int[rects.length];
            for (int i = 0; i < rects.length; i++) {
                weight[i] = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
            }
            this.sum = new int[weight.length];
            this.total = 0;
            for (int i = 0; i < sum.length; i++) {
                total += weight[i];
                sum[i] = total;
            }
        }

        public int[] pick() {
            int[] rect = rects[pickRect()];
            int x = rect[0] + rd.nextInt(rect[2] - rect[0] + 1);
            int y = rect[1] + rd.nextInt(rect[3] - rect[1] + 1);
            return new int[] {x, y};
        }

        private int pickRect() {
            int target = rd.nextInt(total);
            int i = 0, j = sum.length - 1;
            while (i < j) {
                int mid = (i + j) / 2;
                if (sum[mid] > target) {
                    j = mid;
                } else {
                    i = mid + 1;
                }
            }
            return i;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
}
