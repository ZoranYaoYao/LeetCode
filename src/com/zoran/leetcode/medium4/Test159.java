package com.zoran.leetcode.medium4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 字符串解码
 * https://leetcode-cn.com/submissions/detail/10301356/
 */
public class Test159 {

    public static void main(String[] args) {
        String str = "100[leetcode]";
        Test159 test159 = new Test159();
        String res = test159.decodeString(str);
        System.out.println(res);
    }

    public String decodeString(String s) {
        //栈结构，区分数字和后括号
        StringBuilder res = new StringBuilder();
        char[] chrs = s.toCharArray();
        LinkedList<String> stack = new LinkedList<>();
        for (int i=0; i<chrs.length; i++) {
            if(chrs[i] != ']') {
                stack.push(chrs[i]+"");
                System.out.println(chrs[i]+"");
            } else {
                String c = null;
                StringBuilder sb = new StringBuilder();
                StringBuilder item = new StringBuilder();
                while(!(c=stack.pop()).equals("[")) {
                    item.insert(0,c);  //
                }
                String pre = stack.peek();
                String num = "";
                while (pre != null && pre.length() >0 && pre.compareTo("0")>=0 && pre.compareTo("9")<=0) { //数字有问题
                    num = pre + num;
                    stack.pop();
                    pre = stack.peek();
                }

                if (num.length() > 0) {
                    int count = Integer.parseInt(num);
                    while(count >0) {
                        sb.append(item);
                        count--;
                    }
                } else {
                    sb.append(item);
                }
                stack.push(sb.toString());
                System.out.println(sb.toString());
            }
        }

        int nums = stack.size();
        for (int i=0; i<nums; i++) {
            res.insert(0, stack.pop());
        }

        return res.toString();
    }
}


/**
 * Core. 每次都生成最新的tmp字符串，保证与数字相连计算
 */
class LeetCode_Test159 {

    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        int num = 0;
        Deque<StringBuilder> builders = new ArrayDeque<>();
        Deque<Integer> ints = new ArrayDeque<>(); //Core. 单独一个集合存储数字栈
        StringBuilder tmp = new StringBuilder(); //Nice_Core. 每个字符串做临时变量
        for (int i=0; i<chars.length; i++) {
            if (Character.isDigit(chars[i])) { //Core.针对Character判断数字
                num = num*10 + (chars[i]-'0');
            } else if ('[' == chars[i]) {
                builders.addLast(tmp);
                ints.add(num);
                tmp = new StringBuilder();
                num = 0;
            } else if (']' == chars[i]) {
                String str = tmp.toString();
                for (int j=0;j<ints.peekLast(); j++) {
                    builders.peekLast().append(str);
                }
                tmp = builders.pollLast();
                ints.pollLast();
            } else {
                tmp.append(chars[i]);
            }
        }

        return tmp.toString();
    }
}





























