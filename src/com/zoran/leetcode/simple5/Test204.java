package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 两句话中的不常见单词
 * https://leetcode-cn.com/submissions/detail/5844561/
 * 
 * getOrDefault()
 */
public class Test204 {
	
	public static void main(String[] args) {
		Test204 test204 = new Test204();
		String[] strings = test204.uncommonFromSentences("this apple is sweet", "this apple is sour");
		System.out.println(strings);
	}

    public String[] uncommonFromSentences(String A, String B) {
        String[] Astrs = A.split(" ");
        String[] Bstrs = B.split(" ");
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        
        for(String item: Astrs) {
        	if(mapA.get(item) == null) {
        		mapA.put(item, 1);
        	} else {
        		mapA.put(item, mapA.get(item)+1);
        	}
        }
        for(String item: Bstrs) {
        	if(mapB.get(item) == null) {
        		mapB.put(item, 1);
        	} else {
        		mapB.put(item, mapB.get(item)+1);
        	}
        }
        
        List<String> list = new ArrayList<>();
        for(Entry<String, Integer> item: mapA.entrySet()) {
            if(item.getValue() == 1 && !mapB.containsKey(item.getKey())) list.add(item.getKey());
        }
        for(Entry<String, Integer> item: mapB.entrySet()) {
            if(item.getValue() == 1 && !mapA.containsKey(item.getKey())) list.add(item.getKey());
        }
        
        String[] result = new String[list.size()];
        return list.toArray(result);
    }
}
