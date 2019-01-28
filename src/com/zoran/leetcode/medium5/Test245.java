package com.zoran.leetcode.medium5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 单词替换
 * https://leetcode-cn.com/submissions/detail/12167003/
 */
public class Test245 {
    public static void main(String[] args) {
        Test245 test245 = new Test245();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String str = "the cattle was rattled by the battery";
        String res = test245.replaceWords(dict, str);
        System.out.println(res);
    }
    public String replaceWords(List<String> dict, String sentence) {
        //排序词根，然后对比是否包含替换
        Collections.sort(dict, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        String[] strs = sentence.split(" ");
        for (int i=0; i< strs.length; i++) {
            for (int j=0; j<dict.size(); j++) {
                if (strs[i].startsWith(dict.get(j))) {
                    strs[i] = dict.get(j);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<strs.length; i++) {
            sb.append(strs[i] + " ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
