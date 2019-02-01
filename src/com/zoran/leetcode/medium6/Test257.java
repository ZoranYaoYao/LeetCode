package com.zoran.leetcode.medium6;

/**
 * 最长递增子序列的个数
 * https://leetcode-cn.com/submissions/detail/12321339/
 *
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/79889714
 *
 * 多个数组保存对应值进行遍历！
 */
public class Test257 {
}

class Nice_Test257 {
    public int findNumberOfLIS(int[] nums) {
        int n= nums.length, res = 0, max_len = 0;
        //Nice 记录i位置结尾的递增序列长度，记录位置的个数
        int[] len = new int[n], cnt = new int[n];
        for (int i=0; i<n; i++) {
            //一定要注意这里的初始化
            len[i] = cnt[i] = 1;
            for (int j= 0; j<i; j++) {
                //Nice_core 首先判断位置是否能衔接上j位置的值
                if (nums[i] > nums[j]) {
                    if(len[i] == len[j]+1) cnt[i] += cnt[j];
                    if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }

            if (max_len == len[i]) res += cnt[i];
            if (max_len < len[i]) {
                max_len = len[i];
                res = cnt[i];
            }
        }

        return res;
    }
}