package com.zoran.leetcode.medium5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 通过删除字母匹配到字典里最长单词
 * https://leetcode-cn.com/submissions/detail/11695580/
 */
public class Test213 {

    public static void main(String[] args) {
        Test213 test213 = new Test213();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
//        list.add("plea");
        String res = test213.findLongestWord("abpcplea", list);
        System.out.println(res);
    }

    /**
     * "bab"
     * ["ba","ab","a","b"]
     * 预期结果是：ab
     * 我的输出结果是：ba
     * 为啥有问题？？
     */
    public String findLongestWord(String s, List<String> d) {
        //克隆排序，然后返回满足条件的字符串
        ArrayList<String> copyList = (ArrayList<String>) ((ArrayList<String>) d).clone();
        Collections.sort(copyList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -(o1.length() - o2.length()); //长度长的在前面
            }
        });

        List<String> list = new ArrayList<>();
        int preSize = 0;
        boolean has = false;

        for (int i = 0; i < copyList.size(); i++) {
            if (has && preSize > copyList.get(i).length()) break;

            char[] arr = s.toCharArray();
            char[] temp = copyList.get(i).toCharArray();
            int cur = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == temp[cur]) cur++;

                if (cur == temp.length) {
                    has = true;
                    preSize = copyList.get(i).length();
                    break;
                }
            }
            if (has) list.add(copyList.get(i));

        }

        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (d.get(i).equals(list.get(j))) {
                    return d.get(i);
                }
            }
        }
        return "";
    }
}
