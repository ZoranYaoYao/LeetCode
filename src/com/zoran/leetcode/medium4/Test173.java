package com.zoran.leetcode.medium4;

/**
 * ��Ӣ�����ؽ�����
 * https://leetcode-cn.com/submissions/detail/10543562/
 *
 * [Solution]
 * https://www.cnblogs.com/liujinhong/p/6026046.html
 *
 * ��ѧ�ҹ�������
 */
public class Test173 {
    /**
     * ����㣺
     * 1.char������֣�����ֶ������
     * 2.��δ�string���޳��ҵ������֣�
     */
}

class Nice_Test173 {
    /**
     * ��ѧ���ص� : �ڶ�����ĸ���ڵ�һ�ι���֮�� �ֳ�Ϊ�˶����Ĺ�����ĸ
     */
    public String originalDigits(String s) {
        int[] temp = new int[26];
        int[] digit = new int[26];
        for (int i=0; i<s.length(); i++) {
            temp[s.charAt(i) - 97]++; //Core. ��¼26��˳����ĸ�ĸ���
        }
        digit[0] = temp['z'-97]; //Core. z�ĸ���
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
