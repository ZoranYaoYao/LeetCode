package com.zoran.leetcode.medium4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 数组中重复的数据
 * https://leetcode-cn.com/submissions/detail/10623132/
 *
 * OT
 */
public class Test179 {

    public List<Integer> findDuplicates(int[] nums) {
        //hashSet 去重
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if(!set.add(i)) {
                res.add(i);
            }
        }

        return res;
    }
}
