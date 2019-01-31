package com.zoran.leetcode.medium6;

/**
 * 优美的排列 II
 * https://leetcode-cn.com/submissions/detail/12286690/
 */
public class Test254 {

    /**
     * pass
     */
    public int[] constructArray(int n, int k) {
        //生成数组
        int[] res = new int[n];
        for (int i=0; i<n; i++) {
            res[i] = i+1;
        }
        int count = 0;
        if (k == 1) return res;

        int last = 0;
        int cur = 2;
        int diff = k;
        for(int i=1; i<=k; i++) {
            if (i % 2 == 1) {
                res[i] = res[last] + (diff--);
            } else {
                res[i] = res[last] - (diff--);
            }
            last = i;
        }

        return res;
    }
}

class Leet_Test255 {
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;
        //Core. 写法简单
        for (int i=1, inner =k; i<=k; i++, inner--) {
            ret[i] = i%2 ==1 ? ret[i-1] + inner : ret[i-1] - inner;
        }
        for (int i=k+1; i<n; i++) {
            ret[i] = i+1;
        }
        return ret;
    }
}