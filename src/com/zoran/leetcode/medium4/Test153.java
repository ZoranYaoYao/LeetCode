package com.zoran.leetcode.medium4;

import com.zoran.leetcode.util.NestedInteger;

import java.util.LinkedList;

/**
 * �����﷨������
 * https://leetcode-cn.com/submissions/detail/9766397/
 *
 * ����㣺
 * ���������ˣ� ���������if case̫��
 *
 * solution:
 * ��'[' ��ʾ����һ��NestedInteger
 * ������0-9 �� -�� ��ʾ��ǰ�������
 * ��']' ��ʾ�����ö��󣬲���Ӹ���һ������
 */
public class Test153 {

    class Solution {
        //���ģʽ�������ַ���
        public NestedInteger deserialize(String s) {
            if (s == null || s.length() == 0) return null;
            char[] chrs = s.toCharArray();
            int numstart = -1; int numend = -1;
            NestedInteger res = new NestedInteger();
            NestedInteger cusor = res;
            LinkedList<NestedInteger> pre = new LinkedList<>();
            // pre.add(res);

            //�����ִ���
            if (!s.startsWith("[")) {
                int num = Integer.parseInt(s);
                res.setInteger(num);
                return res;
            }

            //�б���
            for (int i=0; i<chrs.length; i++) {
                if ((chrs[i] >= '0'  && chrs[i] <= '9') || chrs[i] == '-') {
                    if(numstart == -1) numstart = i;
                } else if (chrs[i] == ',') {
                    //"[123,456,[788,799,833],[[]],10,[]]"  -> ,֮ǰ��һ����һ������
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
                    pre.push(list); //��¼��һ��NestedInteger
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
                while (Character.isDigit(list[i])) {   //Core. ֱ��һ���Խ�����һ������
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

        return stack.pop(); //Core. ������Ͷ��Ǹ����󣬾������Ҫ���صĶ���
    }
}


























