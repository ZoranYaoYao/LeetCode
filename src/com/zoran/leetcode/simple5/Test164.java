package com.zoran.leetcode.simple5;

import java.util.HashMap;
import java.util.Map;

/**
 * …Ëº∆π˛œ£”≥…‰ 
 * https://leetcode-cn.com/submissions/detail/5263146/
 */
public class Test164 {

}

class MyHashMap {

    Map<Integer, Integer> map= new HashMap<>();
    int[] nums = new int[1000000];
    /** Initialize your data structure here. */
    public MyHashMap() {
        for(int i =0; i< nums.length; i++) {
            nums[i] = -1;
        }
    }
    
    /** value will always be positive. */
    public void put(int key, int value) {
        nums[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return key >= 1000000 ? -1 : nums[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        nums[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */