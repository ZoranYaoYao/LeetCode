package com.zoran.leetcode.medium5;

import java.util.ArrayList;
import java.util.List;

/**
 * �����
 * https://leetcode-cn.com/submissions/detail/12030375/
 *
 * [Solution]
 * https://blog.csdn.net/start_lie/article/details/84111984
 *
 * �����������ȱ�������dfs
 */
public class Test240 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        //�����������滻���н�
        int res = 0;
        if (special == null || special.size() == 0) {
            for (int i =0; i<needs.size(); i++) {
                res += needs.get(i) * price.get(i);
            }
            return res;
        }

        //��δ����ظ��� �����������⣿
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
        res = Math.min(res, temp); //Core, �滻����ֵ

        for (int i=begin; i<special.size(); i++) {
            List<Integer> newNeed = new ArrayList<>();
            for (int j=0; j<n; j++)
                newNeed.add(needs.get(j) - special.get(i).get(j));
            //Nice_Core. ѭ���У��ݹ鿪ʼ����ֵ�������¿�ʼ�µ����ѡ��
            dfs(price, special, newNeed, i, sum+special.get(i).get(n));
        }
    }
}