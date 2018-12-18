package com.zoran.leetcode.medium4;

/**
 * �滻�����ظ��ַ�
 * https://leetcode-cn.com/submissions/detail/10581300/
 *
 * [Solution]
 * https://blog.csdn.net/cloudox_/article/details/69759558
 *
 * �������ڽⷨ
 */
public class Test174 {

    /**
     * "ABBB" 2 ���鲻��
     */
    public int characterReplacement(String s, int k) {
        //��ٷ��� ÿ����ĸ��Ϊ��ͷ(Ψһ)��ɸѡ�����ֵ
        if(s ==null || s.length() == 0) return 0;
        char[] chrs = s.toCharArray();
        int res = 0;
        for (int i=0; i<chrs.length; i++) {
            char first = chrs[i];
            int temp = 1;
            int count = 0;
            for (int j=i+1; j<chrs.length; j++) {
                if(chrs[j] == first) {
                    temp++;
                    continue;
                } else if(chrs[j] != first){
                    if(count < k) {
                        temp++;
                        count++;
                    } else {
                        break;
                    }
                }
            }
            res = Math.max(res, temp);
        }

        return res;
    }
}


class Nice_Test174 {

    public int characterReplacement(String s, int k) {
        if (s.length()<1) return 0;
        int start = 0;
        int end = 0;
        int res = 0;
        int[] charNum = new int[26];
        charNum[s.charAt(0) - 'A']++;
        while (s.length() > end) {
            int maxChar = 0;
            for (int i=0; i<26; i++) {
                if (charNum[i] > maxChar) maxChar = charNum[i];
            }

            if (maxChar + k > end-start) {
                end++;
                if (end < s.length()) charNum[s.charAt(end) - 'A']++;
            } else {
                charNum[s.charAt(start) - 'A']--; //Core. �Ƚ�����ֵ�ĸ���-1
                start++;
            }

            if (maxChar + k > res)
                res = maxChar+k <= s.length() ? maxChar+k : s.length();
        }

        return res;
    }
}


































