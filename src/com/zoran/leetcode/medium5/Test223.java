package com.zoran.leetcode.medium5;

import java.util.ArrayList;
import java.util.List;

/**
 * 朋友圈
 * https://leetcode-cn.com/submissions/detail/11784195/
 *
 * [Solution]
 * https://blog.csdn.net/mine_song/article/details/70195463
 *
 * 考察了图的连通性
 */
public class Test223 {

    /**
     * 算法有问题
     * 66 / 113 个通过测试用例
     */
    public int findCircleNum(int[][] M) {
        //遍历左上斜对角，加入不同的列表中
        int res = 0;
        if (M == null || M.length <= 1) return M.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<M.length; i++) {
            for (int j=i+1; j<M.length; j++) {
                if (M[i][j] == 1) {
                    if (list.size() == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i); temp.add(j);
                        list.add(temp);
                    } else {
                        boolean contains = false;
                        for (List<Integer> item : list) {
                            if (item.contains(i)) {
                                contains = true;
                                item.add(j);
                                break;
                            }
                        }
                        if (!contains) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(i);temp.add(j);
                            list.add(temp);
                        }
                    }
                }
            }
        }

        int self = 0;
        for (int i=0; i<M[0].length; i++) {
            boolean contains = false;
            for (List<Integer> item : list) {
                if (item.contains(i)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) self++;
        }

        return list.size() + self;
    }
}

class Nice_Test223 {
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int n=M.length;
        boolean[] visited = new boolean[n]; //Core. 记录是否已被链接
        int count =0;
        for (int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(M, i, visited);
                count++;
            }


        }
        return count;
    }

    /**
     * 将j变成i,进行遍历连通性
     */
    private void dfs(int[][] mat, int i, boolean[] visited) {
        visited[i] = true;
        for (int j=0; j<visited.length; j++) {
            if (i != j && mat[i][j] == 1 && !visited[j])
                 dfs(mat, j, visited);
        }
    }
}
























