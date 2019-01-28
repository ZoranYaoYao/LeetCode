package com.zoran.leetcode.medium5;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * �������
 * https://leetcode-cn.com/submissions/detail/12164829/
 *
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/76284296
 */
public class Test243 {
    public static void main(String[] args) {
        int[][] nums = {{1,2}, {2,3}, {3,4}};
        Test243 test243 = new Test243();
        int res = test243.findLongestChain(nums);
        System.out.println(res);
    }

    /**
     * 90 / 202 ��ͨ����������
     * ״̬��������
     * ���⣺ dp��ʽ�����⣡
     */
    public int findLongestChain(int[][] pairs) {
        //���� dp[i] = dp[i-1] +1 | dp[i-1];
        int row = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0]; //����
            }
        });
        int[] dp = new int[row];
        int[] pre;
        dp[1] = 1;dp[0] = 1; pre = pairs[0];
        int res = 0;
        for (int j=1; j<row; j++) { //ÿ��ֵ��Ϊ��һ��Ԫ��
            pre = pairs[j-1];
            Arrays.fill(dp, 0); dp[j] = 1;
            for (int i =j+1; i<row; i++) {
                if (pre[1] < pairs[i][0]) {
                    dp[i] = dp[i-1] + 1;
                    pre = pairs[i];
                    continue;
                }

                dp[i] = dp[i-1];
            }
            res = Math.max(dp[dp.length - 1], res);
        }


        return res;

    }
}

class Nice_Test243 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[1] -b[1]);
        int sum =0, n = pairs.length;
        int i=0;
        while (i<n) {
            int currentEnd = pairs[i][1];
            sum++;
            while(i<n && pairs[i][0]<= currentEnd) i++;
        }
        return sum;
    }
}










