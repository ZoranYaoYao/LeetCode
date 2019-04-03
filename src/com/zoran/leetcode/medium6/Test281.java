package com.zoran.leetcode.medium6;

import java.util.*;

/**
 * 金字塔转换矩阵
 * https://leetcode-cn.com/submissions/detail/16153734/
 *
 * 巧用HashMap存储key为公共的位置
 */
public class Test281 {

    public static void main(String[] args) {
        List<List<Character>> list = new ArrayList<>();
        System.out.println(list.get(2));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //组合关系，塔尖元素为1
        if (bottom.length() < 2) return true;

        List<List<Character>> list = new ArrayList<>();
        for (int i=1; i<bottom.length(); i++) {
            String str = bottom.substring(i,i+1);
            for (String item : allowed) {
                char[] chrs = item.toCharArray();
                if (item.startsWith(str)) {
                    if (list.get(i-1) == null) {
                        List<Character> tempList = new LinkedList<>();
                        list.add(tempList);
                        list.get(i-1).add(chrs[2]);
                    } else {
                        list.get(i-1).add(chrs[2]);
                    }
                }

            }
            if (list.get(i-1) == null) return false;
        }

        //问题： 每个字符如何组合生成新的字符串？
        for (int i=0; i<list.size(); i++) {

        }

        return true;
    }
}

class LeetCode_Test281 {
    private Map<String, List<Character>> map;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //合理使用HashMap 进行缓存
        /**
         直接暴力搜索的dfs会超时, 要利用一个map保存所有方块可能的顶部字母
         **/
        map = new HashMap<>();
        for (String brick : allowed) {
            String base = brick.substring(0,2);
            if (!map.containsKey(base))
                map.put(base, new ArrayList<>());
            map.get(base).add(brick.charAt(2));
        }
        return dfs(bottom);
    }

    private boolean dfs(String bottom) {
        // bottom为1说明到达金字塔顶端, 可以搭成金字塔
        if(bottom.length() == 1) return true;
        // 如果bottom中有未出现过的方块底层说明不能搭成金字塔
        for (int i=0; i<bottom.length()-1; i++)
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        // 根据bottom生成所有可能的上层方块
        List<String> candidates = new ArrayList<>();
        generateUpper(bottom, candidates, new StringBuilder(), 0);
        for (String upper : candidates)
            if (dfs(upper))
                return true;
        return false;

    }

    private void generateUpper(String bottom, List<String> candidates, StringBuilder sb, int st) {
        if (st == bottom.length() - 1) {
            candidates.add(sb.toString());
            return;
        }

        for (Character c : map.get(bottom.substring(st, st+2))) {
            sb.append(c);
            generateUpper(bottom, candidates, sb, st+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
