package com.zoran.leetcode.medium6;

import java.util.ArrayDeque;

/**
 * 有效的括号字符串
 * https://leetcode-cn.com/submissions/detail/12324956/
 *
 * [Solution]
 * https://blog.csdn.net/jackzhang_123/article/details/78879862
 *
 * 2个栈进行处理
 */
public class Test260 {
    /**
     * 如果字符串里面太多的*, 会导致超时！
     * @param s
     * @return
     */
//    public boolean checkValidString(String s) {
//        //*号是变化的，回溯
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
//                stack.pop(); //作为（
//                backTrace(stack,chrs,start+1);
//
//                // stack.push('*'); 作为字符串
//                backTrace(stack,chrs,start+1);
//
//            }
//            break;
//            case '*' :
//
//                if (top == ')') stack.push(chrs[i]);
//                else if ()
//                    stack.pop(); //作为）
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
        //栈能保证括号顺序的正确性！！
        // 先把*作为（,进行匹配， 留下的进行left与*之间关系
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> star = new ArrayDeque<>();
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '*')
                star.push(i);
            else if (s.charAt(i) == '(')
                left.push(i);
            else {
                /**NNice_Core 优先弹'(' 不然后面的*在'('之前，就会出现有问题
                 * eg: *: 47
                 *     (: 58
                 *     无论*变化是什么，最后都不能匹配上！！
                 **/
                if (!left.isEmpty())
                    left.pop();
                else if (!star.isEmpty())
                    star.pop();
                else
                    return false;
            }
        }
        //*号的顺序有问题！！
        // "(())((())()()(*)(*()(())())())()()((()())((()))(*"
//        if (left.isEmpty() && star.isEmpty()) return true;
//        if (star.isEmpty()) return false;
//        return left.size() <= star.size();

        while(!left.isEmpty() && !star.isEmpty()){
            //NNice_Core.如果 '*' 在 '(' 之前的话, 表明是有问题的
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