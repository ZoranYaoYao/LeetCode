package com.zoran.leetcode.simple6;

/**
 * 不含 AAA 或 BBB 的字符串
 * https://leetcode-cn.com/submissions/detail/14013775/
 */
public class Test236 {

    public String strWithout3a3b(int A, int B) {
        //交叉填入
        StringBuilder sb = new StringBuilder();
        int orientation = 0;
        if (B > A) orientation = 1;
        while(A>0 || B>0) {
            if (orientation == 0) {
                //Core 核心点在于后续的个数比例判断，如果是2倍关系，那么还是要竟可能多的进行匹配！！
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
