package com.zoran.leetcode.medium4;

import java.util.HashSet;
import java.util.Set;


/**
 * 最小基因变化
 * https://leetcode-cn.com/submissions/detail/10586145/
 *
 * [Solution]
 * https://blog.csdn.net/excellentlizhensbfhw/article/details/80934056
 */
public class Test176 {

    char[] geneCh = new char[]{'A','T','C','G'};
    public int Nice_minMutation(String start, String end, String[] bank) {
        Set<String> reached = new HashSet<>();
        reached.add(start);
        int len = 1;
        Set<String> wordDictSet = new HashSet<>();
        for (String s : bank){
            wordDictSet.add(s);
        }
        while (reached.size() > 0){
            Set<String> tmp = new HashSet<>();
            for (String word : reached){
                int length = word.length();
                for (int i = 0; i < length; ++ i){
                    char ch[] = word.toCharArray();
                    for (char c : geneCh){
                        ch[i] = c;
                        String s = new String(ch);
                        if (wordDictSet.contains(s)){
                            if (s.equals(end)){
                                return len;
                            }
                            wordDictSet.remove(s);
                            tmp.add(s);
                        }
                    }
                }
            }
            if (tmp.size() == 0){
                return -1;
            }
            reached = tmp;
            len ++;
        }
        return -1;
    }
}
