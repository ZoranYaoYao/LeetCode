package com.zoran.leetcode.simple6;

/**
 * ������ת��ĸ
 * https://leetcode-cn.com/submissions/detail/13277212/
 */
public class Test220 {

    public static void main(String[] args) {
        Test220 test220 = new Test220();
        String res = test220.reverseOnlyLetters("a-bC-dEf-ghIj");
        System.out.println(res);
    }

    public String reverseOnlyLetters(String S) {
        //ǰ��������������ĸ���ں�����
        char[] sChar = S.toCharArray();
        int len = sChar.length;
        int left = 0, right = len-1;
        char[] chrs = new char[len];

        for (int i=0; i<len; i++) {
            if ((sChar[i]>='a' && sChar[i]<='z') || (sChar[i]>='A' && sChar[i]<='Z')) {
                while(right >=0 && !((sChar[right]>='a' && sChar[right]<='z') || (sChar[right]>='A' && sChar[right]<='Z'))) {
                    System.out.println(right);
                    right--;
                }
                chrs[i] = sChar[right--];
            } else {
                chrs[i] = sChar[i];
            }
        }

        return new String(chrs);

    }
}

class LeetCode_Test220 {
    public String reverseONlyLetters(String S) {
        if (S.length() == 0 || S == null) return "";

        char[] array = S.toCharArray();
        int j = array.length - 1;
        for (int i=0; i<j; i++) {
            if (Character.isLetter(array[i])) {
                while (!Character.isLetter(array[j]))
                    if (j > i) j--;
            }
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            //Core �ж�j,i��ֵȷ���Ƿ���Ҫ���
            if (j>i) j--;
        }

        return new String(array);
    }
}
