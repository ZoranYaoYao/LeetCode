package com.zoran.leetcode.medium4;

/**
 * 从英文中重建数字
 * https://leetcode-cn.com/submissions/detail/10543562/
 *
 * [Solution]
 * https://www.cnblogs.com/liujinhong/p/6026046.html
 *
 * 数学找规律问题
 */
public class Test173 {
    /**
     * 问题点：
     * 1.char组合数字，会出现多种情况
     * 2.如何从string中剔除找到的数字？
     */
}

class Nice_Test173 {
    /**
     * 数学找特点 : 第二个字母是在第一次过滤之后， 又成为了独立的过滤字母
     */
    public String originalDigits(String s) {
        int[] temp = new int[26];
        int[] digit = new int[26];
        for (int i=0; i<s.length(); i++) {
            temp[s.charAt(i) - 97]++; //Core. 记录26个顺序字母的个数
        }
        digit[0] = temp['z'-97]; //Core. z的个数
        digit[2] = temp['w'-97];
        digit[6] = temp['x'-97];
        digit[8] = temp['g'-97];
        digit[4] = temp['u'-97];

        digit[1] = temp['o'-97] - (digit[0] + digit[2] + digit[4]);
        digit[3] = temp['h'-97] - digit[8];
        digit[5] = temp['f'-97] - digit[4];
        digit[7] = temp['s'-97] - digit[6];
        digit[9] = temp['i'-97] - (digit[6] + digit[8] + digit[5]);

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<digit.length; i++) {
            for (int j=0; j<digit[i]; j++) {
                sb.append(i+"");
            }
        }
        return sb.toString();
    }
}
