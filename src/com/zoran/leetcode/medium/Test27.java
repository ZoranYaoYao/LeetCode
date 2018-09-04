package com.zoran.leetcode.medium;

/**
 * Pow(x, n)
 * https://leetcode-cn.com/submissions/detail/6516801/
 * 
 * [Solution]
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51655964
 * 
 * 采用折半乘机 n/2的关系, 少运行几次代码
 */
public class Test27 {

	public static void main(String[] args) {
		Test27 test27 = new Test27();
		System.out.println(test27.myPow(2d, 10));
	}

	/**
	 *    超出时间限制
	 * 0.00001
	 * 2147483647
	 */
	public double myPow(double x, int n) {
		if(n==0) return 1;

		int m = Math.abs(n);
		double result =1;
		while(m>0) {
			result *= x;
			m--;
		}

		return n>0 ? result : 1/result;
	}
}

class Nice_Test27 {

    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        int t = n / 2;
        if(n < 0) {
            t = -t;
            x = 1 / x;
        }
        double res = myPow(x, t);
        if(n % 2 == 0) return res * res;
        return res * res * x;
    }

}
