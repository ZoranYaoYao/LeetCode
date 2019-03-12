package com.zoran.leetcode.simple6;

/**
 * �ҵ�С��ķ���
 * https://leetcode-cn.com/submissions/detail/14452714/
 *
 * [Solution]
 * https://blog.csdn.net/qq_34269988/article/details/87901832
 */
public class Test241 {
}

class Nice_Test241 {
    public int findJudge(int N, int[][] trust) {
        //��ÿ���˶���ͬ���ε���? ÿ���˶�ָ���� -�� �ýڵ�����ֵΪN-1����
        int[] outDegree = new int[N+1];
        int[] inDegree = new int[N+1];
        for (int[] item : trust) {
            outDegree[item[0]]++;
            inDegree[item[1]]++;
        }

        for (int i=1; i<N+1; i++) {
            //Core. �ýڵ��������ΪN-1,���ҷ��ٲ������κ���
            if (outDegree[i] == 0 && inDegree[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}
