package com.zoran.leetcode.medium3;

/**
 * 超级次方
 * https://leetcode-cn.com/submissions/detail/9426488/
 * 
 *【Solution】
 * https://www.cnblogs.com/grandyang/p/5651982.html
 * 超时
 *
 */
public class Test144 {
	
	public static void main(String[] args) {
		Test144 test144 = new Test144();
		int[] b = {2,0,0};
		int res = test144.superPow(2147483647, b);
		System.out.println(res);
	}
	/**
	 * 2147483647
		[2,0,0]
	 */
    public int superPow(int a, int[] b) {
        //正常计算，转折求数值，使用Math.pow()
        int mi = 0;
        for (int i=0; i<b.length; i++) {
            mi = mi*10 + b[i];
        }
        return (int) (Math.pow(a, mi) % 1337);
    }
}
