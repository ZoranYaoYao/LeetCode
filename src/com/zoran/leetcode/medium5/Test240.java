package com.zoran.leetcode.medium5;

import java.util.ArrayList;
import java.util.List;

/**
 * 大礼包
 * https://leetcode-cn.com/submissions/detail/12030375/
 *
 * [Solution]
 * https://blog.csdn.net/start_lie/article/details/84111984
 *
 * 大礼包深度优先遍历搜索dfs
 */
public class Test240 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //买各种礼包，替换最有解
        int res = 0;
        if (special == null || special.size() == 0) {
            for (int i =0; i<needs.size(); i++) {
                res += needs.get(i) * price.get(i);
            }
            return res;
        }

        //如何处理重复买？ 大礼包组合问题？
        for (int i=0; i<special.size(); i++) {
            int count = special.get(i).size();
            for (int j=0; j<count; j++) {
                if (j>needs.get(j)) break;
            }
        }

        return -1;

    }
}

class NNNice_Test240 {
    int res = Integer.MAX_VALUE;
    int n;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        n = needs.size();
        dfs(price, special, needs, 0, 0);
        return res;
    }

    public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int begin, int sum){
        int temp = sum;
        for (int i=0; i<n; i++) {
            if (needs.get(i)<0) return;
            temp += needs.get(i)*price.get(i);
        }
        res = Math.min(res, temp); //Core, 替换最优值

        for (int i=begin; i<special.size(); i++) {
            List<Integer> newNeed = new ArrayList<>();
            for (int j=0; j<n; j++)
                newNeed.add(needs.get(j) - special.get(i).get(j));
            //Nice_Core. 循环中，递归开始索引值，能重新开始新的礼包选择
            dfs(price, special, newNeed, i, sum+special.get(i).get(n));
        }
    }
}