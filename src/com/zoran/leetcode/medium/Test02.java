package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ظ��ַ�����Ӵ�
 * https://leetcode-cn.com/submissions/detail/5892258/
 */
public class Test02 {

    public int lengthOfLongestSubstring(String s) {
        //�����ÿ�ֿ���
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int max =0;
        for(int i=0; i<chars.length; i++) {
            list.add(chars[i]);
            for(int j=i+1; j<chars.length; j++) {
                if(j == chars.length) break;
                if(!list.contains(chars[j])) {
                    list.add(chars[j]);
                } else {
                    break;
                }
            }
            
            max = Math.max(max, list.size());
            list.clear();
        }
        
        return max;
    }
}
