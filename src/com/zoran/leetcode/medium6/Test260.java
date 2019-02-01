package com.zoran.leetcode.medium6;

import java.util.ArrayDeque;

/**
 * ��Ч�������ַ���
 * https://leetcode-cn.com/submissions/detail/12324956/
 *
 * [Solution]
 * https://blog.csdn.net/jackzhang_123/article/details/78879862
 *
 * 2��ջ���д���
 */
public class Test260 {
    /**
     * ����ַ�������̫���*, �ᵼ�³�ʱ��
     * @param s
     * @return
     */
//    public boolean checkValidString(String s) {
//        //*���Ǳ仯�ģ�����
//        char[] chrs = s.toCharArray();
//        ArrayDeque<Character> stack = new ArrayDeque<>();
//        return backTrace(stack,chrs,0);
//    }
//
//    private boolean backTrace(ArrayDeque<Character> stack, char[] chrs, int start) {
//        boolean res;
//
//        switch (chrs[i]) {
//            char top = stack.peek();
//            if (top == null) stack.push(char[i]);
//            case '(' :
//                stack.push(chrs[i]);
//                break;
//            case ')' :
//
//                if (top !+ top == ')') return fasle;
//                    else if (top == '(') stack.pop();
//            else if (top == '*') {
//                stack.pop(); //��Ϊ��
//                backTrace(stack,chrs,start+1);
//
//                // stack.push('*'); ��Ϊ�ַ���
//                backTrace(stack,chrs,start+1);
//
//            }
//            break;
//            case '*' :
//
//                if (top == ')') stack.push(chrs[i]);
//                else if ()
//                    stack.pop(); //��Ϊ��
//                backTrace(stack,chrs,start+1);
//
//                break;
//        }
//
//    }

}

class Nice_Test260 {
    public static void main(String[] args) {
        Nice_Test260 nice_test260 = new Nice_Test260();
        String s = "(())((())()()(*)(*()(())())())()()((()())((()))(*";
        boolean res = nice_test260.checkValidString(s);
        System.out.println(res);
    }

    public boolean checkValidString(String s) {
        //ջ�ܱ�֤����˳�����ȷ�ԣ���
        // �Ȱ�*��Ϊ��,����ƥ�䣬 ���µĽ���left��*֮���ϵ
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> star = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*')
                star.push(i);
            else if (s.charAt(i) == '(')
                left.push(i);
            else {
                /**NNice_Core ���ȵ�'(' ��Ȼ�����*��'('֮ǰ���ͻ����������
                 * eg: *: 47
                 *     (: 58
                 *     ����*�仯��ʲô����󶼲���ƥ���ϣ���
                 **/
                if (!left.isEmpty())
                    left.pop();
                else if (!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }
        //*�ŵ�˳�������⣡��
        // "(())((())()()(*)(*()(())())())()()((()())((()))(*"
//        if (left.isEmpty() && star.isEmpty()) return true;
//        if (star.isEmpty()) return false;
//        return left.size() <= star.size();

        while(!left.isEmpty() && !star.isEmpty()){
            //NNice_Core.��� '*' �� '(' ֮ǰ�Ļ�, �������������
            if (star.peek() < left.peek()) {
                return false;
            } else {
                left.pop();
                star.pop();
            }
        }
        return left.isEmpty();
    }
}