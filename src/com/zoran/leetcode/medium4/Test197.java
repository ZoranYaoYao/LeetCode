package com.zoran.leetcode.medium4;

/**
 * �����ַ���
 * https://leetcode-cn.com/submissions/detail/10920614/
 *
 * ����ҵĹ��ɣ�
 */
public class Test197 {

    public int magicalString(int n) {
        StringBuilder s = new StringBuilder("122");
        int i = 2, x = 2;
        while (s.length() <= n) {
            if (x == 2) x = 1;
            else x = 2;
            if (s.charAt(i) == '1') s.append(x);
            else{
                s.append(x);
                s.append(x);
            }
            i++;
        }
        int res = 0;
        for(int j = 0; j<n;j++){
            if (s.charAt(j) == '1') res++;
        }
        return res;
    }
}
