package com.zoran.leetcode.simple6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 查找常用字符
 * https://leetcode-cn.com/submissions/detail/14630129/
 *
 * 记录字符的个数
 */
public class Test243 {


}

class Leetcode_Test243 {
    public List<String> commonChars(String[] A) {
        //用一个int数组记录，所有字符串共同字符的个数！!
        int[] t1 = new int[26];
        Arrays.fill(t1, Integer.MAX_VALUE);
        for (String s : A) {
            int[] t2 = new int[26];
            for (char c : s.toCharArray()) {
                t2[c - 'a']++;
            }
            for (int i=0; i<t2.length; i++) {
                //Nice_Core, 取目前字符匹配的公共char个数
                t2[i] = Math.min(t1[i], t2[i]);
            }
            t1 = t2;
        }
        List<String> res = new ArrayList<>();
        for (int i=0; i<t1.length; i++) {
            for (int j=0; j<t1[i]; j++) {
                res.add((char) ('a' + i) + "");
            }
        }

        return res;
    }
}
