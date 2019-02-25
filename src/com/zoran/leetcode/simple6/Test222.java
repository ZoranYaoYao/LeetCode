package com.zoran.leetcode.simple6;

/**
 * 按奇偶排序数组 II
 * https://leetcode-cn.com/submissions/detail/13304555/
 */
public class Test222 {

    public int[] sortArrayByParityII(int[] A) {
        //奇偶排序，双向指针
        int right = A.length-1;
        for (int i=0; i<A.length; i++) {
            //奇偶性不一致
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
