package com.zoran.leetcode.simple6;

import java.util.Arrays;

/**
 * 三角形的最大周长
 * https://leetcode-cn.com/submissions/detail/13921786/
 *
 * 如果A[i] > A[i-1] + A[i-2]，则A[i]>A[i-1]+A[i-3]. 那么说明A[i]就不是构成3条边的元素了！！
 */
public class Test234 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,4,18,8};
        Test234 test234 = new Test234();
        int res = test234.largestPerimeter(nums);
        System.out.println(res);
    }

    public int largestPerimeter(int[] A) {
        //两边之和 大于 第三条边
        //两边之差 小于 第三条边
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
            //NNice 如果A[i] < A[i-1] + A[i-2]， 那么左边移过来，一定有A[i] - A[i-1] < A[i-2]！！
            //如果A[i] > A[i-1] + A[i-2]，则A[i]>A[i-1]+A[i-3]. 那么说明A[i]就不是构成3条边的元素了！！
            if (A[i] < A[i-1] + A[i-2]) {
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }
}
