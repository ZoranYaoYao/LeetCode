package com.zoran.leetcode.medium6;

import java.util.*;

/**
 * ������ת������
 * https://leetcode-cn.com/submissions/detail/16153734/
 *
 * ����HashMap�洢keyΪ������λ��
 */
public class Test281 {

    public static void main(String[] args) {
        List<List<Character>> list = new ArrayList<>();
        System.out.println(list.get(2));
    }

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //��Ϲ�ϵ������Ԫ��Ϊ1
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

        //���⣺ ÿ���ַ������������µ��ַ�����
        for (int i=0; i<list.size(); i++) {

        }

        return true;
    }
}

class LeetCode_Test281 {
    private Map<String, List<Character>> map;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        //����ʹ��HashMap ���л���
        /**
         ֱ�ӱ���������dfs�ᳬʱ, Ҫ����һ��map�������з�����ܵĶ�����ĸ
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
        // bottomΪ1˵���������������, ���Դ�ɽ�����
        if(bottom.length() == 1) return true;
        // ���bottom����δ���ֹ��ķ���ײ�˵�����ܴ�ɽ�����
        for (int i=0; i<bottom.length()-1; i++)
            if (!map.containsKey(bottom.substring(i,i+2))) return false;
        // ����bottom�������п��ܵ��ϲ㷽��
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
