package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * K ��ȡ������󻯵������
 * https://leetcode-cn.com/submissions/detail/14718790/
 *
 * �ҹ���
 */
public class Test244 {

    public int largestSumAfterKNegations(int[] A, int K) {
        //����֮�����ȸı为����Ȼ����С����
        Arrays.sort(A);
        while(K > 0) {
            A[0] = -A[0];
            K--;
            Arrays.sort(A);
        }

        int res = 0;
        for (int item : A) {
            res += item;
        }
        return res;
    }
}
