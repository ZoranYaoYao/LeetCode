package com.zoran.leetcode.simple6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 强整数
 * https://leetcode-cn.com/submissions/detail/13646241/
 *
 * [Solution]
 * https://segmentfault.com/a/1190000017781196?utm_source=tag-newest
 */
public class Test232 {

    /**
     * 40
     * 40
     * 10000
     */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        //遍历指数
        List<Integer> res = new ArrayList<>();
        for (int k=2; k<=bound; k++) {
            for (int i=0; i<=bound; i++) {
                boolean add = false;
                for (int j=0; j<=bound; j++) {
                    if (Math.pow(x,i) + Math.pow(y,j) == k) {
                        res.add(k);
                        add = true;
                        break;
                    }
                }
                if (add) break;
            }
        }
        return res;

    }
}

class Nice_Test232 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i=0; i<bound; i++) {
            int tmp1 = (int) Math.pow(x, i);
            if (tmp1 > bound) break;

            for (int j=0; j<bound; j++) {
                int tmp2 = (int) Math.pow(y,j);
                int tmp = tmp1 + tmp2;
                if (tmp <= bound)
                    set.add(tmp);
                else
                    break;
            }
        }

        return new ArrayList<Integer>(set);
    }
}
