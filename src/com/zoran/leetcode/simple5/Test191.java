package com.zoran.leetcode.simple5;

/**
 * ¾ØÐÎÖØµþ
 * https://leetcode-cn.com/submissions/detail/5714217/
 * 
 * [Solution]
 * https://www.e-learn.cn/content/qita/786323
 */
public class Test191 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // overlap bottom x
        int olbx = Integer.max(rec1[0], rec2[0]);

        // overlap top x
        int oltx = Integer.min(rec1[2], rec2[2]);

        // overlap bottom y
        int olby = Integer.max(rec1[1], rec2[1]);

        // overlap top y
        int olty = Integer.min(rec1[3], rec2[3]);

        return (olbx < oltx) && (olby < olty);
    }
}
