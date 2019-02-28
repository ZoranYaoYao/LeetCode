package com.zoran.leetcode.simple6;

/**
 * 验证外星语词典
 * https://leetcode-cn.com/submissions/detail/13542514/
 */
public class Test330 {

    public static void main(String[] args) {
        Test330 test330 = new Test330();
        String[] strings = {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"
        };
        String order = "zkgwaverfimqxbnctdplsjyohu";
        boolean res = test330.isAlienSorted(strings, order);
        System.out.println(res);
    }

    public boolean isAlienSorted(String[] words, String order) {
        //对数组进行特定的顺序验证
        String last = "";
        for(String str : words) {
            if (last == "")  {
                last = str;
            } else {
                int compareIndex = 0;
                for (int i=0; i<str.length(); i++) {
                    if (i>last.length()-1) {
                        break;
                    }
                    int strIndex = order.indexOf(str.charAt(i));
                    int lastIndex = order.indexOf(last.charAt(i));
                    if (strIndex<lastIndex) return false;
                    else if (strIndex > lastIndex) break;
                    compareIndex++;
                }
                if (compareIndex== str.length() && last.length() > str.length())
                    return false;
                last = str;
            }
        }

        return true;
    }
}
