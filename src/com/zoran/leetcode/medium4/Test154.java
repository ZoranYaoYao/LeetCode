package com.zoran.leetcode.medium4;


import java.util.*;

/**
 * 字典序排数
 * https://leetcode-cn.com/submissions/detail/10028202/
 *
 * [Solution]
 * http://www.mamicode.com/info-detail-2366128.html
 *
 * dfs 深度优先遍历，但是不用先生成9叉树
 */
public class Test154 {

    /**
     * 23489 超时
     */
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        //整数型的排序算法
        for(int i=1; i<=n; i++) {
            res.add(i);
        }

        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                char[] chars1 = String.valueOf(o1).toCharArray();
                char[] chars2 = String.valueOf(o2).toCharArray();
                int len = Math.min(chars1.length, chars2.length);
                for (int i=0; i<len; i++) {
                    if (chars1[i] < chars2[i]) return -1; //自然顺序排列
                    if (chars1[i] > chars2[i]) return 1;
                }

                if (chars1.length < chars2.length) return -1;
                else return 1;
            }
        });

        return res;
    }
}

class Nice_Test154 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i=1; i<=9; i++) {
            if (i > n) break;
            dfs(i, res, n);
        }
        return res;
    }

    private void dfs(int i, List<Integer> res, int n) {
        res.add(i);
        for (int k=0; k<=9; k++) {
            if (i*10 + k > n) break;
            dfs(i*10 + k, res, n);
        }
    }
}
