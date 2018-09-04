package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
     ��ĸ��λ�ʷ���
   https://leetcode-cn.com/submissions/detail/6515700/
 */
public class Test26 {

    public List<List<String>> groupAnagrams(String[] strs) {
        //����HashMap ���з������
        List<String> index = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        if(strs == null || strs.length ==0) return result;
        Map<String, List<String>> map = new HashMap<>();
        
        for(String item: strs) {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(map.get(sortStr) == null) {
                List<String> list = new ArrayList<>(); list.add(item);
                map.put(sortStr, list);
            } else {
                List<String> list = map.get(sortStr);
                list.add(item); //Core. ��ȥ��
                // if(!list.contains(item)) list.add(item);
            }
        }
        
        for(Entry<String, List<String>> item: map.entrySet()) {
            result.add(item.getValue());
        }
        
        return result;
    }
}
