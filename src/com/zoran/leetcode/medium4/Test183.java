package com.zoran.leetcode.medium4;

import java.util.*;

/**
 * 根据字符出现频率排序
 * https://leetcode-cn.com/submissions/detail/10672558/
 *
 * OT : 数据结构的选择
 */
public class Test183 {

    public String frequencySort(String s) {
        //使用map存储，然后用List进行排序
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        for(int i=0; i<chrs.length; i++) {
            if(map.get(chrs[i]) == null) {
                map.put(chrs[i], 1);
            } else {
                map.put(chrs[i], map.get(chrs[i]) + 1);
            }
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> item : map.entrySet()) {
            int count = item.getValue();
            Character cha = item.getKey();
            StringBuilder sb = new StringBuilder();
            while(count != 0) {
                sb.append(cha);
                count--;
            }
            list.add(sb.toString());
        }
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.length() - o1.length(); //o1长度长的, 获取的结果值反而小，所以是降序
            }
        });
        StringBuilder res = new StringBuilder();
        for (String item : list) res.append(item);

        return res.toString();
    }
}
