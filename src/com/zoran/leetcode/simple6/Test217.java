package com.zoran.leetcode.simple6;

/**
 * 按奇偶排序数组
 * https://leetcode-cn.com/submissions/detail/13133960/
 */
public class Test217 {

    public int[] sortArrayByParity(int[] A) {
        //双指针，左右遍历设置奇偶值
        int left = 0, right = A.length-1;
        while (left < right) {
            if (A[left] % 2 == 0) {
                left++;
                continue;
            }

            while (right > 0 && A[right] % 2 != 0) {
                right--;
            }
            if (right <= left) break;

            int temp = A[left];
            A[left++] = A[right];
            A[right--] = temp;
        }

        return A;
    }
}
