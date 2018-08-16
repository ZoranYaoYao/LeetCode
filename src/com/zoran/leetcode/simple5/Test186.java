package com.zoran.leetcode.simple5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 最常见的单词
 * https://leetcode-cn.com/submissions/detail/5619460/
 * 
 * OT
 * map.put(temp, map.getOrDefault(temp, 0)); //Core.
 */
public class Test186 {
	
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] strs = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for(String item: strs) {
            char end = item.charAt(item.length()-1);
            String temp = "";
            if(end < 'A' || (end > 'Z' && end < 'a') || end > 'z') {
                temp = item.substring(0, item.length()-1);
            } else {
                temp = item.substring(0, item.length());
            }
            
            temp = temp.toLowerCase();
//            if(map.get(temp) == null) {
//                map.put(temp, 1);
//            }else {
//                map.put(temp, map.get(temp)+1);
//            }
            map.put(temp, map.getOrDefault(temp, 0)); //Core.
        }
        
        int max =0; String result = new String();
        List<String> list = Arrays.asList(banned);
        for(Entry<String, Integer> item: map.entrySet()) {
            if(item.getValue() > max) {
                if(!list.contains(item.getKey())) {
                    result = item.getKey();
                    max = item.getValue();
                }
            }
        }
        
        return result;
    }
}
