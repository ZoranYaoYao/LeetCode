package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 唯一摩尔斯密码词
 * https://leetcode-cn.com/submissions/detail/5568594/
 */
public class Test182 {

    public int uniqueMorseRepresentations(String[] words) {
        String[] secret = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        List<String> list = new ArrayList<>();
        for (String item: words) {
            char[] chrs = item.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c: chrs) {
                sb.append(secret[c-'a']);
            }
            if(!list.contains(sb.toString())) list.add(sb.toString());
        }
        
        return list.size();
    }
    
    //利用set集合
    public int Nice_uniqueMorseRepresentations(String[] words) {
        String[] secret = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        for (String item: words) {
            char[] chrs = item.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char c: chrs) {
                sb.append(secret[c-'a']);
            }
            set.add(sb.toString());
        }
        
        return set.size();
    }
}
