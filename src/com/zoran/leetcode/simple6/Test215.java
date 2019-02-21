package com.zoran.leetcode.simple6;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/13072320/
 */
public class Test215 {


    public boolean isMonotonic(int[] A) {
        //�ݹ��ж�2��ֵ
        if (A.length == 1) return true;

        int cur = Integer.MAX_VALUE;
        for (int i=0; i<A.length-1; i++) {
            int temp = A[i] - A[i+1];
            if (temp == 0) continue;
            if (cur == Integer.MAX_VALUE) {
                cur = temp;
                continue;
            }

            //Nice_Core 2�β�ֵ��ţ� ��֤���ǵ���������
            if (temp * cur < 0) return false;
        }

        return true;
    }
}
