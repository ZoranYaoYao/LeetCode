package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 账户合并
 * https://leetcode-cn.com/submissions/detail/12705382/
 *
 * [Solution]
 * https://blog.csdn.net/SundyGuo/article/details/80910059
 *
 * 采用并查集解决！
 */
public class Test270 {

    /**
     * [["Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"],["Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"],
     * ["Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"],
     * ["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"],["Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"]]
     * 算法没有去重
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        //生成新的列表，并进行对比添加
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : accounts) {
            if (res.size() == 0) res.add(list);

            boolean has = false;
            int cur = 0;
            for (int i=0; i<res.size(); i++) {
                for (int j=1; j<res.get(i).size(); j++) {
                    if (list.contains(res.get(i).get(j))) {
                        has = true;
                        cur = i;
                        break;
                    }
                }

            }
            if (has) {
                List<String> temp = res.get(cur);
                for (int i=1; i<list.size(); i++) {
                    if (!temp.contains(list.get(i)))
                        temp.add(list.get(i));
                }
            } else {
                res.add(list);
            }
        }

        //排序
        List<List<String>> res2 = new ArrayList<>();
        for (List<String> list : res) {
            List<String> sub = list.subList(1,list.size());
            Collections.sort(sub);
            sub.add(0, list.get(0));
            res2.add(sub);
        }

        return res2;
    }
}
