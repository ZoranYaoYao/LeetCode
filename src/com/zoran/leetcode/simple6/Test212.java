package com.zoran.leetcode.simple6;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 最短完整词
 * https://leetcode-cn.com/submissions/detail/13068617/
 */
public class Test212 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        //获取字符进行对比， LinkedList
        // StringBuilder sb = new StringBuilder();
        LinkedList<Character> list = new LinkedList();
        for (char chr : licensePlate.toCharArray()) {
            if ((chr>='a' && chr <='z') || (chr>='A' && chr<='Z'))
                list.add(chr);
        }


        String res = new String();

        for(String item : words) {
            LinkedList<Character> copyList = (LinkedList<Character>) list.clone();
            for (char chr : item.toCharArray()) {

                Iterator cusor = copyList.iterator();
                while(cusor.hasNext()) {
                    Character c = (Character) cusor.next();
                    if ((chr == c) || (c > chr && (c-32 == chr)) || (c<chr && (c+32 == chr))) {
                        cusor.remove();
                        break;
                    }
                }

                if (copyList.size() == 0) {
                    if (res.length() == 0)
                        res = item;
                    else
                        res = res.length()<=item.length()? res: item;
                    break;
                }
            }
        }

        return res;
    }
}

class LeetCode_Test212 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <='z')
                //Nice_Core. 利用数组来存储连续的小写字母的个数
                count[c-'a']++;
        }
        String res = "";
        int min = 9999;
        for (String w : words) {
            int[] temp = new int[26];
            for (char c: w.toLowerCase().toCharArray()) {
                temp[c-'a']++;
            }
            boolean flag = false;
            for (int i=0; i<temp.length; i++) {
                //Nice_Core 对比数组字母个数
                if (count[i]>temp[i]){
                    flag = true;
                    break;
                }
            }
            if (!flag && w.length() < min) {
                min = w.length();
                res = w;
            }
        }

        return res;
    }
}
