package com.zoran.leetcode.simple6;

/**
 * ���� AAA �� BBB ���ַ���
 * https://leetcode-cn.com/submissions/detail/14013775/
 */
public class Test236 {

    public String strWithout3a3b(int A, int B) {
        //��������
        StringBuilder sb = new StringBuilder();
        int orientation = 0;
        if (B > A) orientation = 1;
        while(A>0 || B>0) {
            if (orientation == 0) {
                //Core ���ĵ����ں����ĸ��������жϣ������2����ϵ����ô����Ҫ�����ܶ�Ľ���ƥ�䣡��
                if(A>1 && B!=0 && A/B>=2) {
                    A -= 2;
                    sb.append("aa");
                } else {
                    if (A == 0) break;
                    A--;
                    sb.append("a");
                }
                orientation = 1;
            } else {
                if (B>1 && A!= 0 && B/A>=2) {
                    B -= 2;
                    sb.append("bb");
                } else {
                    if (B == 0) break;
                    B--;
                    sb.append("b");
                }
                orientation = 0;
            }
        }
        while (A>0) {
            sb.append("a");
            A--;
        }
        while(B>0) {
            sb.append("b");
            B--;
        }

        return sb.toString();
    }
}
