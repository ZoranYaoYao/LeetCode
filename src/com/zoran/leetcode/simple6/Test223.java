package com.zoran.leetcode.simple6;

/**
 * 长按键入
 * https://leetcode-cn.com/submissions/detail/13305382/
 */
public class Test223 {

    public static void main(String[] args) {
        Test223 test223 = new Test223();
        String str1 = "saeed";
        String str2 = "ssaaedd";
        boolean res = test223.isLongPressedName(str1, str2);
        System.out.println(res);
    }

    public boolean isLongPressedName(String name, String typed) {
        //字符串匹配
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        int index = 0;
        for (char c : names) {
            while (index < typeds.length && typeds[index] != c) {
                index++;
            }
            if (index >= typeds.length) return false;
            index++;
        }
        return true;
    }
}

class LeetCode_Test223 {
    public boolean isLongPressedName(String name, String typed) {
        if (name == typed) return true;
        if (name.length()>typed.length()
                || name.charAt(name.length()-1) != typed.charAt(typed.length()-1)) return false;

        //Nice_Core 双指针记录位置！
        int i=0, j=0, pre = 0;
        while (i<name.length() && j<typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                pre = i;
                i++;
                j++;
            } else if (name.charAt(pre) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
