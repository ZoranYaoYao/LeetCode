package com.zoran.leetcode.medium4;

import com.zoran.leetcode.util.NestedInteger;

import java.util.LinkedList;

/**
 * 迷你语法分析器
 * https://leetcode-cn.com/submissions/detail/9766397/
 *
 * 问题点：
 * 题做出来了， 可是里面的if case太多
 *
 * solution:
 * 当'[' 表示创建一个NestedInteger
 * 当数字0-9 或 -， 表示当前对象添加
 * 当']' 表示结束该对象，并添加给上一个对象
 */
public class Test153 {

    class Solution {
        //组合模式，解析字符串
        public NestedInteger deserialize(String s) {
            if (s == null || s.length() == 0) return null;
            char[] chrs = s.toCharArray();
            int numstart = -1; int numend = -1;
            NestedInteger res = new NestedInteger();
            NestedInteger cusor = res;
            LinkedList<NestedInteger> pre = new LinkedList<>();
            // pre.add(res);

            //单数字处理
            if (!s.startsWith("[")) {
                int num = Integer.parseInt(s);
                res.setInteger(num);
                return res;
            }

            //列表处理
            for (int i=0; i<chrs.length; i++) {
                if ((chrs[i] >= '0'  && chrs[i] <= '9') || chrs[i] == '-') {
                    if(numstart == -1) numstart = i;
                } else if (chrs[i] == ',') {
                    //"[123,456,[788,799,833],[[]],10,[]]"  -> ,之前不一定是一个数字
                    int num;
                    if (numstart == -1) continue;

                    if (chrs[i-1] == ']') {
                        num = Integer.parseInt(s.substring(numstart, i-1));
                    } else {
                        num = Integer.parseInt(s.substring(numstart, i));
                    }

                    NestedInteger temp = new NestedInteger(num);
                    numstart = -1;
                    pre.peek().add(temp);
                } else if (chrs[i] == '[') {
                    NestedInteger list = new NestedInteger();
                    if (pre.peek() != null) {
                        pre.peek().add(list);
                    } else {
                        res = list;
                    }
                    pre.push(list); //记录上一个NestedInteger
                } else if (chrs[i] == ']') {
                    if (numstart != -1) {
                        int num = Integer.parseInt(s.substring(numstart, i));
                        NestedInteger temp = new NestedInteger(num);
                        pre.peek().add(temp);
                        numstart = -1;
                    }
                    pre.pop();
                }
            }

            return res;
        }
    }
}


class LeetCode_Test153 {
    public NestedInteger deserialize(String s) {
        if (s == null && s.length() == 0) return null;

        char[] list = s.toCharArray();
        if (list[0] != '[') return new NestedInteger(Integer.parseInt(s));

        LinkedList<NestedInteger> stack = new LinkedList<>();
        int val = 0; boolean pos =true;
        for (int i=0; i<list.length; i++) {
            if (list[i] == '[') {
                stack.push(new NestedInteger());
            } else if (Character.isDigit(list[i]) || list[i] == '-') {
                if (list[i] == '-') {
                    pos = false; i++;
                }
                while (Character.isDigit(list[i])) {   //Core. 直接一次性解析出一个数字
                    val = val*10 + (list[i] - '0');
                    i++;
                }
                i--;
                stack.peek().add(new NestedInteger(pos?val : -val));
                val = 0; pos = true;
            } else if (list[i] == ']' && stack.size()>1) {
                NestedInteger n = stack.pop();
                stack.peek().add(n);
            }
        }

        return stack.pop(); //Core. 弹出最低端那个对象，就是最后要返回的对象！
    }
}


























