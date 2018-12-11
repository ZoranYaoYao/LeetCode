package com.zoran.leetcode.medium4;

import java.util.HashMap;
import java.util.Map;

/**
 * 至少有K个重复字符的最长子串
 * https://leetcode-cn.com/submissions/detail/10338747/
 *
 * [Solution]
 * https://blog.csdn.net/weixin_40921797/article/details/83903387
 */
public class Test160 {

    public int longestSubstring(String s, int k) {
        //遍历，保存每个字符的个数
        //问题： 不知道结束位置？
        Map<Character, Integer> map = new HashMap<>();
        char[] chrs = s.toCharArray();
        for (int i = 0; i<chrs.length; i++) {
            for (int j=i+1; j<chrs.length; j++) {

            }
        }

        return 0;
    }
}

class Nice_Test160 {
    public int longestSubstring(String s, int k) {
        if (k <= 1) return s.length();
        char[] arr = s.toCharArray();
        int size = 0;
        for (int i=0; i<arr.length; i++) {
            int[] mip = new int[26]; //Nice_core. 通过数组替换HashMap, 进行内部映射, 并且每次刷新
            for (int j=i+1; j<arr.length; j++) {
                mip[arr[j] - 'a']++;
                if (arrBiggerK(mip, k) && j-i+1>size) {
                    size = j-i+1; //Nice_core. 1.满足替换法！！
                }
            }

        }

    }

    /**
     * 独立功能，进行提取
     */
    private boolean arrBiggerK(int[] arr, int k) {
        for (int num : arr) {
            if (num > 0 && num < k) {
                return false;
            }
        }
        return true;
    }
}


























