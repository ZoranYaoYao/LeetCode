package com.zoran.leetcode.medium6;

/**
 * ����������еĸ���
 * https://leetcode-cn.com/submissions/detail/12321339/
 *
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/79889714
 *
 * ������鱣���Ӧֵ���б�����
 */
public class Test257 {
}

class Nice_Test257 {
    public int findNumberOfLIS(int[] nums) {
        int n= nums.length, res = 0, max_len = 0;
        //Nice ��¼iλ�ý�β�ĵ������г��ȣ���¼λ�õĸ���
        int[] len = new int[n], cnt = new int[n];
        for (int i=0; i<n; i++) {
            //һ��Ҫע������ĳ�ʼ��
            len[i] = cnt[i] = 1;
            for (int j= 0; j<i; j++) {
                //Nice_core �����ж�λ���Ƿ����ν���jλ�õ�ֵ
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