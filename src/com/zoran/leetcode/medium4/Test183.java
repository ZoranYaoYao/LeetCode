package com.zoran.leetcode.medium4;

import java.util.*;

/**
 * �����ַ�����Ƶ������
 * https://leetcode-cn.com/submissions/detail/10672558/
 *
 * OT : ���ݽṹ��ѡ��
 */
public class Test183 {

    public String frequencySort(String s) {
        //ʹ��map�洢��Ȼ����List��������
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
                return o2.length() - o1.length(); //o1���ȳ���, ��ȡ�Ľ��ֵ����С�������ǽ���
            }
        });
        StringBuilder res = new StringBuilder();
        for (String item : list) res.append(item);

        return res.toString();
    }
}
