package com.zoran.leetcode.medium5;

import java.util.Arrays;

/**
 * 字符串的排列
 * https://leetcode-cn.com/submissions/detail/11933050/
 *
 * [Solution]
 * http://www.cnblogs.com/MrSaver/p/9638279.html
 *
 * 滑动窗口的经典案例
 */
public class Test229 {

    /**
     * 69 / 102 个通过测试用例
     * 状态：超出时间限制
     * 长字符串超长时
     */
    public boolean checkInclusion(String s1, String s2) {
        //找到所有S1排列，在看S2是否包含 -》 会超时
        //转换为s1,s2字符对比
        if (s1 == null || s1.length() == 0) return true;
        if (s1.length() > s2.length()) return false;

        char[] charS1 = s1.toCharArray();
        boolean[] marked = new boolean[charS1.length];
        char[] charS2 = s2.toCharArray();
        for (int i=0; i<charS2.length; i++) {
            int temp = find(charS1, charS2, marked, i);
            if (temp == charS1.length) return true;
            else {
                Arrays.fill(marked, false);
                i += temp;
            }
        }
        return false;
    }

    private int find(char[] charS1, char[] charS2, boolean[] marked, int start) {
        int count = 0;
        for (int i=start; i<charS2.length; i++) {
            boolean find = false;
            for (int j=0; j<charS1.length; j++) {
                if (!marked[j] && charS2[i] == charS1[j]) {
                    marked[j] = true;
                    count++;
                    find = true;
                    break;
                }
            }
            if (!find) return count;
            if (count == charS1.length) return count;
        }

        return count;
    }
}

class Nice_Test229 {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (char c : s1.toCharArray())
            c1[c-'a']++;

        for (int i=0; i<l2; i++) {
            if (i >= l1)
                --c2[s2.charAt(i-l1)-'a']; //滑动窗口滑动
            c2[s2.charAt(i)-'a']++;
            //Nice_Core. 判断2个数组是否相等！！
            if (Arrays.equals(c1,c2))
                return true;
        }

        return false;
    }
}





















