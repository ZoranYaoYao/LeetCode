package com.zoran.leetcode.medium5;

import java.util.LinkedList;

/**
 * �����Ӽ�����
 * https://leetcode-cn.com/submissions/detail/11944719/
 *
 * ̫������
 */
public class Test232 {
    public String fractionAddition(String expression) {
        //�ָ�ֱ�����ӣ���ĸֵ���ڻ���
        char[] chars = expression.toCharArray();
        boolean firstNegative =false;
        if (chars[0] == '-') firstNegative = true;

        LinkedList<String> linkedList = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<chars.length; i++) {
            switch (chars[i]) {
                case '+':
                    linkedList.add(sb.toString());
                    linkedList.add("+");
//                    sb.delete(0,sb.length());
                    break;
                case '-':
                    if (firstNegative) {
                        sb.append('-');
                    } else {
                        linkedList.add(sb.toString());
                        linkedList.add("-");
//                        sb.reset();
                    }
                    break;
                default:
                    sb.append(chars[i]+"");

            }
        }

        for (String item : linkedList) {

        }

        return "";
    }
}
