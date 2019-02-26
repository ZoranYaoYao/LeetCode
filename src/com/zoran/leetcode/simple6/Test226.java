package com.zoran.leetcode.simple6;

/**
 * 增减字符串匹配
 * https://leetcode-cn.com/submissions/detail/13379584/
 */
public class Test226 {

    public int[] diStringMatch(String S) {
        //找规律，增加是最小值开始，减少是最大值开始
        int[] res = new int[S.length()+1];
        int min = 0, max = res.length-1;
        for (int i=0; i<S.length(); i++) {
            char c = S.charAt(i);
            if (c == 'I') {
                res[i] = min++;
            } else {
                res[i] = max--;
            }

            if (i == S.length()-1) {
                res[i+1] = min;
            }
        }

        return res;
    }
}
