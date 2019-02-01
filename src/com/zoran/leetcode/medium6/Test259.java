package com.zoran.leetcode.medium6;

import java.util.HashMap;
import java.util.Map;

/**
 * ¼üÖµÓ³Éä
 * https://leetcode-cn.com/submissions/detail/12322174/
 */
public class Test259 {
    class MapSum {

        //ÀûÓÃMap´æ´¢
        Map<String, Integer> map;
        /** Initialize your data structure here. */
        public MapSum() {
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int res = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getKey().startsWith(prefix))
                    res += entry.getValue();
            }
            return res;
        }
    }
}
