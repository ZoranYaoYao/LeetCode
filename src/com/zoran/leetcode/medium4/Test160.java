package com.zoran.leetcode.medium4;

import java.util.HashMap;
import java.util.Map;

/**
 * ������K���ظ��ַ�����Ӵ�
 * https://leetcode-cn.com/submissions/detail/10338747/
 *
 * [Solution]
 * https://blog.csdn.net/weixin_40921797/article/details/83903387
 */
public class Test160 {

    public int longestSubstring(String s, int k) {
        //����������ÿ���ַ��ĸ���
        //���⣺ ��֪������λ�ã�
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
            int[] mip = new int[26]; //Nice_core. ͨ�������滻HashMap, �����ڲ�ӳ��, ����ÿ��ˢ��
            for (int j=i+1; j<arr.length; j++) {
                mip[arr[j] - 'a']++;
                if (arrBiggerK(mip, k) && j-i+1>size) {
                    size = j-i+1; //Nice_core. 1.�����滻������
                }
            }

        }

    }

    /**
     * �������ܣ�������ȡ
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


























