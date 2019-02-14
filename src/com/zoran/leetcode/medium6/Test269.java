package com.zoran.leetcode.medium6;

/**
 * ��ظ�������
 * https://leetcode-cn.com/submissions/detail/12701215/
 *
 * [Solution]
 * https://blog.csdn.net/xuxuxuqian1/article/details/81072967
 */
public class Test269 {
    /**
     * �㷨���ԣ�2�����ֵ�ʱ��������
     * [16,33,14,2,98]
     * [55,24,97,50,38]
     */
    public int findLength(int[] A, int[] B) {
        //��ٱ�����ȡ
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();
        for (int item : A)
            sbA.append(item);
        for (int item : B)
            sbB.append(item);
        String strA = sbA.toString();
        String strB = sbB.toString();
        int res = 0;
        for (int i=0; i<strA.length(); i++) {
            for (int j=i+1; j<=strB.length(); j++) {
                String temp = strA.substring(i,j);
                if (strB.contains(temp))
                    res = Math.max(res, temp.length());
            }
        }
        return res;
    }
}

class Nice_Test269 {
    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] smaeCount = new int[A.length][B.length];
        //��ʼ����һ�е�һ��A[i]B[j]
        for (int i=0; i<A.length; i++) {
            if (B[0] == A[i])
                smaeCount[i][0] = 1;
        }
        for (int i=0; i<B.length; i++) {
            if (B[i] == A[0])
                smaeCount[0][i] = 1;
        }

        //����������
        for (int row =1; row < A.length; row++) {
            for (int col =1; col<B.length; col++) {
                //Nice ��A row B col,����λ�õ��ַ�����β ��A[row-1]B[col-1]+1!!
                //dp[i][j] = dp[i-1][j-1] + 1 ��i��j�ַ����ʱ��ת������
                if (A[row] == B[col]) {
                    smaeCount[row][col] = smaeCount[row-1][col] + 1;
                    max = Math.max(max, smaeCount[row][col]);
                }
            }
        }
        return max;
    }
}
