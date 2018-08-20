package com.zoran.leetcode.simple5;

import java.util.LinkedList;

/**
 * �ȽϺ��˸���ַ���
 * https://leetcode-cn.com/submissions/detail/5791007/
 */
public class Test193 {

    public boolean backspaceCompare(String S, String T) {
        char[] Schars = S.toCharArray();
        char[] Tchars = T.toCharArray();
        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();
        for(int i=0; i<Schars.length; i++) {
            if(Schars[i] == '#') {
                stack1.poll(); //Core. poll(): ���ᱨcrash����, ����nullֵ
            } else {
                stack1.push(Schars[i]);
            }
        }
        for(int i=0; i<Tchars.length; i++) {
            if(Tchars[i] == '#') {
                stack2.poll();
            } else {
                stack2.push(Tchars[i]);
            }
        }
        
        for(int i=stack1.size()-1; i>=0; i--) {
            if(stack1.poll() != stack2.poll()) return false;
        }
        
        return true;
    }
}
