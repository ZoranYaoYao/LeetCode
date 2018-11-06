package com.zoran.leetcode.medium3;

/**
 * 比特位计数
 * https://leetcode-cn.com/submissions/detail/9074726/
 */
public class Test136 {

    public int[] countBits(int num) {
        //转折除2操作,
        int[] res = new int[num+1];
        for (int i=0; i<=num; i++) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                if (temp%2 == 1) count++;
                temp = temp/2;
            }
            res[i] = count;
        }
        return res;
    }
}

