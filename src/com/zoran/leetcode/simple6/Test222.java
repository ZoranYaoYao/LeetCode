package com.zoran.leetcode.simple6;

/**
 * ����ż�������� II
 * https://leetcode-cn.com/submissions/detail/13304555/
 */
public class Test222 {

    public int[] sortArrayByParityII(int[] A) {
        //��ż����˫��ָ��
        int right = A.length-1;
        for (int i=0; i<A.length; i++) {
            //��ż�Բ�һ��
            right = A.length-1;
            if (i%2 != A[i]%2) {
                while(A[right]%2 != i%2) {
                    right--;
                }
                int temp = A[i];
                A[i] = A[right];
                A[right] = temp;
            }
        }

        return A;

    }
}
