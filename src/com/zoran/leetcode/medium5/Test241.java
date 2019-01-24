package com.zoran.leetcode.medium5;

/**
 * 求解方程
 * https://leetcode-cn.com/submissions/detail/12031640/
 *
 * [Solution]
 * https://segmentfault.com/a/1190000016963673?utm_source=tag-newest
 *
 * 非获取匹配，正向肯定预查，在任何匹配pattern的字符串开始处匹配查找字符串，该匹配不需要获取供以后使用。
 * 例如，“Windows(?=95|98|NT|2000)”能匹配“Windows2000”中的“Windows”，但不能匹配“Windows3.1”中的“Windows”。
 * 预查不消耗字符，也就是说，在一个匹配发生后，在最后一次匹配之后立即开始下一次匹配的搜索，而不是从包含预查的字符之后开始。
 */
public class Test241 {

    public String solveEquation(String equation) {
        //切分字符串，求x解
        String[] strs = equation.split("=");
        char[] one = strs[0].toCharArray();
        char[] two = strs[1].toCharArray();
        int count =0;
        for (int i=1; i<one.length; i++) {
//            if ()
        }
        return "";
    }
}

class Nice_Test241 {
    public static void main(String[] args) {
        String str = "-2x+3x-6x=x+2";
        Nice_Test241 nice_test241 = new Nice_Test241();
        nice_test241.solveEquation(str);
    }

    public String solveEquation(String equation) {
        String[] side = equation.split("=");
        String left = side[0], right = side[1];
        int[] ls = getCounts(left);
        int[] rs = getCounts(right);
        int countX = ls[0] - rs[0];
        int countNum = rs[1] - ls[1];
        if (countX == 0) {
            if (countNum == 0) return "Infinite solutions";
            return "No solution";
        }

        int x=countNum/countX;
        StringBuilder sb = new StringBuilder();
        sb.append("x=").append(x);
        return sb.toString();
    }

    private int[] getCounts(String str) {
        int[] res = new int[2];
        String[] parts = str.split("(?=[+-])"); //error Nice_Core, 切割2中情况的字符！！
        for (String part : parts) {
            System.out.println(part);
            if (part.equals("x") || part.equals("+x")) res[0]++;
            else if (part.equals("-x")) res[0]--;
            else if (part.contains("x")) res[0] += Integer.valueOf(part.substring(0, part.indexOf("x")));
            else res[1] += Integer.valueOf(part);
        }
        return res;
    }
}