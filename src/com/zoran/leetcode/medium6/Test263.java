package com.zoran.leetcode.medium6;

import java.util.*;

/**
 * 前K个高频单词
 * https://leetcode-cn.com/submissions/detail/12647577/
 *
 * 使用了优先级队列ProrityQueue
 */
public class Test263 {
    public List<String> topKFrequent(String[] words, int k) {
        //生成一个节点，进行多个条件排序
        Map<String, Integer> map = new HashMap<>();
        for (String item : words) {
            map.put(item, map.getOrDefault(item,0)+1);
        }
        List<Node> list = new ArrayList<>();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            list.add(new Node(item.getKey(),item.getValue()));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.freq == o2.freq) {
                    return o1.words.compareTo(o2.words);
                }
                return -(o1.freq - o2.freq);
            }
        });
        List<String> res = new ArrayList<>();
        for (int i=0; i<k; i++) {
            res.add(list.get(i).words);
        }
        return res;
    }

    class Node {
        public String words;
        public int freq;

        public Node(String words, int freq) {
            this.words = words;
            this.freq = freq;
        }
    }
}


class LeetCode_Test263 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> countsMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            countsMap.put(word, countsMap.getOrDefault(word,0) + 1);
        }

        /**
         * 使用优先级队列，进行排序Map.Entry多维变量
         */
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()) {
                    return -1;
                } else if (o1.getValue() < o2.getValue()) {
                    return 1;
                } else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
        for (Map.Entry<String, Integer> entry : countsMap.entrySet()) {
            pq.offer(entry);
        }
        while (k-- != 0) {
            result.add(pq.poll().getKey());
        }
        return result;
    }
}






















