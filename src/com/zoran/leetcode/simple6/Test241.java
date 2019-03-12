package com.zoran.leetcode.simple6;

/**
 * 找到小镇的法官
 * https://leetcode-cn.com/submissions/detail/14452714/
 *
 * [Solution]
 * https://blog.csdn.net/qq_34269988/article/details/87901832
 */
public class Test241 {
}

class Nice_Test241 {
    public int findJudge(int N, int[][] trust) {
        //找每个人都共同信任的人? 每个人都指向他 -》 该节点的入度值为N-1！！
        int[] outDegree = new int[N+1];
        int[] inDegree = new int[N+1];
        for (int[] item : trust) {
            outDegree[item[0]]++;
            inDegree[item[1]]++;
        }

        for (int i=1; i<N+1; i++) {
            //Core. 该节点他的入度为N-1,并且法官不相信任何人
            if (outDegree[i] == 0 && inDegree[i] == N-1) {
                return i;
            }
        }
        return -1;
    }
}
