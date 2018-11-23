package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 常数时间插入、删除和获取随机元素
 * https://leetcode-cn.com/submissions/detail/9677241/
 */
public class Test150 {
    class RandomizedSet {
        //封装HashSet，进行处理
        List<Integer> list = new ArrayList<>();
        
        /** Initialize your data structure here. */
        public RandomizedSet() {

        }

        /** Inserts a value to the list. Returns true if the list did not already contain the specified element. */
        public boolean insert(int val) {
            if (list.contains(val)) return false;
            return list.add(val);

        }

        /** Removes a value from the list. Returns true if the list contained the specified element. */
        public boolean remove(int val) {
            return list.remove((Integer) val);
        }

        /** Get a random element from the list. */
        public int getRandom() {
            Random random = new Random();
            return list.get(random.nextInt(list.size()));
        }
    }
}
