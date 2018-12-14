package com.zoran.leetcode.medium4;

import java.util.Arrays;

/**
 * �Ȳ����л���
 * https://leetcode-cn.com/submissions/detail/10456942/
 *
 * [Solution]
 * https://blog.csdn.net/xuchonghao/article/details/80853595
 *
 * ����˼��Ķ�̬�滮
 */
public class Test168 {

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6};
        Test168 test168 = new Test168();
        int res = test168.numberOfArithmeticSlices(num);
        System.out.println(res);
    }

    /**
     * �㷨��ȷ��
     * ����int[] >1000000  ��ʱ
     */
    public int numberOfArithmeticSlices(int[] A) {
        //�ݹ������飬����С����
        //P,Q ��ֵ̬
        int res = 0;
        for (int i=3; i<=A.length; i++) {
            for(int j=0; j+i<=A.length; j++) { //Core. ע��Ⱥţ���ʾ���ֵ
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
                // Nice_Core. dp[i]��ʾ�ܵ���iֵ��β�ĸ���
                /***
                 * �ܵ����Ϊ2����
                 * 1. ��ǰ�ܵ���i-1��dp[i-1]�� ��һ��Ҳ�ܵ���i����ֵ
                 * 2. ���Ҷ�һ��Ԫ�غ���ǰ֮��2��Ԫ�ص�ֵ��Ҳ�ܵ������һ��ֵ�� ������Ҫ+1��  nice��
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
