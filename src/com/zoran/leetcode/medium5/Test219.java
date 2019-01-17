package com.zoran.leetcode.medium5;

/**
 * 复数乘法
 * https://leetcode-cn.com/submissions/detail/11740524/
 */
public class Test219 {
    public static void main(String[] args) {
        Test219 test219 = new Test219();
        String res = test219.complexNumberMultiply("1+1i","1+1i");
        System.out.println(res);
    }

    public String complexNumberMultiply(String a, String b) {
        //实数 与 复数 分离计算
        String[] arrA = a.split("\\+");
        String[] arrB = b.split("\\+");
        int numA = Integer.valueOf(arrA[0]);
        int virtualA = Integer.valueOf(arrA[1].substring(0,arrA[1].indexOf("i")));
        int numB = Integer.valueOf(arrB[0]);
        int virtualB = Integer.valueOf(arrB[1].substring(0,arrB[1].indexOf("i")));
        int res = numA*numB - virtualA*virtualB;
        String i = (numA*virtualB + numB*virtualA) + "i";
        return res + "+" + i;
    }
}
