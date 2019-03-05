package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * �����ε�����ܳ�
 * https://leetcode-cn.com/submissions/detail/13921786/
 *
 * ���A[i] > A[i-1] + A[i-2]����A[i]>A[i-1]+A[i-3]. ��ô˵��A[i]�Ͳ��ǹ���3���ߵ�Ԫ���ˣ���
 */
public class Test234 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,18,8};
        Test234 test234 = new Test234();
        int res = test234.largestPerimeter(nums);
        System.out.println(res);
    }

    public int largestPerimeter(int[] A) {
        //����֮�� ���� ��������
        //����֮�� С�� ��������
        Arrays.sort(A);
        int len = A.length;

        int X = A[len-1];
        int B = A[len-2];
        int C = A[len-3];
        int index = 3;
        while (B+C <= X || Math.abs(B-C) >= X) {
            if (++index == len+1) return 0;

            if (index%3 == 1) {
                X = A[len-index];
            } else if (index%3 == 2) {
                B = A[len-index];
            } else {
                C = A[len-index];
            }
        }

        return X+B+C;
    }
}

class LeetCode_Test234 {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i=A.length-1; i>=2; i--) {
            //NNice ���A[i] < A[i-1] + A[i-2]�� ��ô����ƹ�����һ����A[i] - A[i-1] < A[i-2]����
            //���A[i] > A[i-1] + A[i-2]����A[i]>A[i-1]+A[i-3]. ��ô˵��A[i]�Ͳ��ǹ���3���ߵ�Ԫ���ˣ���
            if (A[i] < A[i-1] + A[i-2]) {
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }
}
