package com.zoran.leetcode.medium5;

import java.util.LinkedList;

/**
 * 分数加减运算
 * https://leetcode-cn.com/submissions/detail/11944719/
 *
 * 太繁琐了
 */
public class Test232 {
    public String fractionAddition(String expression) {
        //分割，分别求分子，分母值，在化简
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
