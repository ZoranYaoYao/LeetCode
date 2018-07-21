package com.zoran.leetcode.simple4;

import java.util.HashMap;
import java.util.Map;

/**
 * ·ÖÌÇ¹û
 * https://leetcode-cn.com/submissions/detail/4443019/
 */
public class Test128 {

    public int distributeCandies(int[] candies) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int item: candies) {
            if(map.get(item)  == null) {
                map.put(item,1);
            } else {
                map.put(item, map.get(item) + 1);
            }
        }
        
        if (map.size() >= candies.length/2) {
            return candies.length/2;
        } else {
            return map.size();
        }
        
    }
}
