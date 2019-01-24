package com.zoran.leetcode.medium5;

/**
 * ��ⷽ��
 * https://leetcode-cn.com/submissions/detail/12031640/
 *
 * [Solution]
 * https://segmentfault.com/a/1190000016963673?utm_source=tag-newest
 *
 * �ǻ�ȡƥ�䣬����϶�Ԥ�飬���κ�ƥ��pattern���ַ�����ʼ��ƥ������ַ�������ƥ�䲻��Ҫ��ȡ���Ժ�ʹ�á�
 * ���磬��Windows(?=95|98|NT|2000)����ƥ�䡰Windows2000���еġ�Windows����������ƥ�䡰Windows3.1���еġ�Windows����
 * Ԥ�鲻�����ַ���Ҳ����˵����һ��ƥ�䷢���������һ��ƥ��֮��������ʼ��һ��ƥ��������������ǴӰ���Ԥ����ַ�֮��ʼ��
 */
public class Test241 {

    public String solveEquation(String equation) {
        //�з��ַ�������x��
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
        String[] parts = str.split("(?=[+-])"); //error Nice_Core, �и�2��������ַ�����
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