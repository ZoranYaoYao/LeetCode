package com.zoran;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        System.out.println(compress("Zaaa"));
    }


    public static String compress(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int len = map.entrySet().size() * 2;
        if (len > s.length()) {
            return s;
        }
        StringBuilder sb = new StringBuilder(len);
        int i = -1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue());
            sb.append(entry.getKey());
        }
        return sb.toString();
    }
}



