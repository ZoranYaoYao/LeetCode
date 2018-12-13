package com.zoran.leetcode.medium4;

/**
 * 移掉K位数字
 * https://leetcode-cn.com/submissions/detail/10422375/
 *
 * [Solution]
 * https://blog.csdn.net/zxm1306192988/article/details/80725404
 *
 * 栈结构可以在比较中，移除栈顶元素
 */
public class Test165 {

    public static void main(String[] args) {
        String num = "10"; int k = 1;
        Test165 test165 = new Test165();
        String aa = test165.removeKdigits(num, k);
        System.out.println("---"+aa);
    }


    /**
     * 回溯法 超时 >10000长度的字符串！！
     */
    String res = "";
    public String removeKdigits(String num, int k) {
        //回溯 移除法
        char[] chrs = num.toCharArray();
        int[] mark = new int[chrs.length];
        backTrace(chrs, mark, 0, k, 0);

        int index0 = -1;
        if(res.startsWith("0")) {
            for(int i=0; i<res.length(); i++) {
                if(res.charAt(i) == '0') index0 = i;
                else
                    break;
            }
        }

        if(index0 == res.length()-1) return "0";
        if (res.equals("")) return "0";

        return index0 == -1 ? res : res.substring(index0+1);
    }

    public void backTrace(char[] chrs, int[] mark, int curCount, int k, int start) {
        if (curCount == k) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<mark.length; i++) {
                if(mark[i]==0) sb.append(chrs[i]);
            }



            String temp = sb.toString();
            System.out.println(temp);
            if(res.equals("")) res = temp;

            if(res.compareTo(sb.toString()) > 0) {
                res = temp;
            }

            return;

        }

        for(int i=start; i<chrs.length; i++) {
            mark[i] = 1;
            backTrace(chrs, mark, curCount+1, k, i+1);
            mark[i] = 0;
        }
    }
}


class Nice_Test165 {
    public String removeKdigits(String num, int k) {
        if (k <= 0) return num;
        if (num.length() == 0 || k>=num.length()) return "0";

        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        for (int i=0; i<num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top--;
                k--;
            }
            stk[top++] = c;  //Core. top-1代表栈顶的顶元素！
        }
        int idx = 0;
        while (idx < digits && stk[idx] == '0') {
            idx++;
        }
        return idx == digits ? "0" : new String(stk, idx, digits - idx);
    }
}






















