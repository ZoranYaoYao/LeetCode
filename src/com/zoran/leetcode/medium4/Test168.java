package com.zoran.leetcode.medium4;

import java.util.Arrays;

/**
 * 等差数列划分
 * https://leetcode-cn.com/submissions/detail/10456942/
 *
 * [Solution]
 * https://blog.csdn.net/xuchonghao/article/details/80853595
 *
 * 不可思议的动态规划
 */
public class Test168 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6};
        Test168 test168 = new Test168();
        int res = test168.numberOfArithmeticSlices(num);
        System.out.println(res);
    }

    /**
     * 算法正确，
     * 但是int[] >1000000  超时
     */
    public int numberOfArithmeticSlices(int[] A) {
        //递归子数组，划分小数组
        //P,Q 动态值
        int res = 0;
        for (int i=3; i<=A.length; i++) {
            for(int j=0; j+i<=A.length; j++) { //Core. 注意等号，表示宽度值
                int[] B = Arrays.copyOfRange(A, j, j+i);
                res += isArithmetic(B);
                System.out.println(Arrays.toString(B) + ", res =  " + res);
            }
        }

        return res;
    }

    public int isArithmetic(int[] A){
        if (A == null || A.length < 3) return 0;
        int length = A.length;
        int diff = A[1] - A[0];
        int res = 1;
        for(int i=0; i<length; i++) {
            if(i-1 > 0 && A[i] - A[i-1] != diff) {
                return 0;
            }
        }

        return 1;
    }
}

class Nice_Test168 {

    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length == 0) return 0;

        int n = A.length;
        int[] dp = new int[A.length];
        for(int i=2; i<n; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
                // Nice_Core. dp[i]表示能到达i值结尾的个数
                /***
                 * 能到达分为2布：
                 * 1. 以前能到达i-1的dp[i-1]， 则一定也能到达i结束值
                 * 2. 并且多一个元素后，以前之后2个元素的值，也能到达最后一个值， 所以需要+1。  nice！
                 */
                dp[i] = dp[i-1] + 1;
            }
        }
        int total = 0;
        for (int c : dp) {
            total += c;
        }
        return total;
    }
}
