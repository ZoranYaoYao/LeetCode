package com.zoran.leetcode.medium4;

import java.util.HashSet;
import java.util.Set;

/**
 * 环绕字符串中唯一的子字符串
 * https://leetcode-cn.com/submissions/detail/10838373/
 *
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/6143071.html
 *
 * 核心问题： 如何去重？
 * //Very_Nice_Core 去重，通过记录结束字符的不同来区分，
 * // 并且每次遍历，都记录该字符结束的最大值
 */
public class Test190 {
    public static void main(String[] args) {
        Test190 test190 = new Test190();
//        int res = test190.findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmn" +
//                "opqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz");
        int res = test190.findSubstringInWraproundString("zaba");
        System.out.println(res);
    }


    /**
     * abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmn" +
     * "opqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy
     * 14 / 81 个通过测试用例 状态：超出时间限制
     */
    public int findSubstringInWraproundString(String p) {
        //字符转整形计算
        if (p == null || p.length() == 0) return 0;

        char[] chrs = p.toCharArray();
        int orderCount = 1;
        int res = 0;
        Set<Character> set = new HashSet<>();
        Set<String> strSet = new HashSet<>();
        Set<String> onlySet = new HashSet<>();
        for (int i = 0; i < chrs.length; i++) {
            set.add(chrs[i]);
            if (i + 1 < chrs.length ) {
                if (chrs[i + 1] - chrs[i] == 1 || chrs[i + 1] - chrs[i] == -25) {
                    orderCount++;
                } else if (orderCount > 1){
                    strSet.add(p.substring(i+1 - orderCount, i+1));
                    orderCount = 0;
                }
            }
        }

        if (orderCount != 0) {
            strSet.add(p.substring(p.length() - orderCount, p.length()));
        }

        for (String item : strSet) {
            res += (item.length() * (item.length()+1) /2) - item.length();
            char[] temp = item.toCharArray();
            for (int i = 1; i < temp.length; i++) {
                for (int j = 0; j < temp.length - i; j++) {
                    onlySet.add(item.substring(j, j + i + 1));
                }
            }
        }

//        for (String item : onlySet) {
//            System.out.println(item);
//        }
        return onlySet.size() + set.size();
    }
}

class Nice_Test190 {
    public int findSubstringInWraproundString(String p) {
        int[] cnt = new int[26];
        int len = 0;
        char[] chrs = p.toCharArray();
        for (int i=0; i<p.length(); i++) {
            if (i > 0 && (chrs[i] - chrs[i-1] == 1 || chrs[i-1] - chrs[i] == 25)) {
                len++;
            } else {
                len = 1;
            }

            //Very_Nice_Core 去重，通过记录结束字符的不同来区分，
            // 并且每次遍历，都记录该字符结束的最大值
            cnt[chrs[i] -'a'] = Math.max(cnt[chrs[i]-'a'], len);
        }

        int res = 0;
        for (int item : cnt) {
            res += item;
        }
        return res;
    }
}
