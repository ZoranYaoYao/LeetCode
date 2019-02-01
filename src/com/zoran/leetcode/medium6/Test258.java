package com.zoran.leetcode.medium6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 实现一个魔法字典
 * https://leetcode-cn.com/submissions/detail/12321921/
 */
public class Test258 {
    class MagicDictionary {
        //顺序个数都要一致
        //按个数进行HashMap
        HashMap<Integer, List<String>> map;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            map = new HashMap<>();
        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String str : dict) {
                List<String> list;
                if (map.get(str.length()) == null) {
                    list = new ArrayList<>();
                    list.add(str);
                    map.put(str.length(), list);
                } else {
                    list = map.get(str.length());
                    list.add(str);
                }
            }
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) return false;
            List<String> list = map.get(word.length());
            if (list == null) return false;
            for (String str : list) {
                if (str.equals(word)) continue;

                int diff = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (diff > 1) break;
                    if (str.charAt(i) != word.charAt(i)) diff++;
                }

                if (diff < 2) return true;
            }

            return false;
        }
    }
}
