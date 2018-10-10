package com.zoran.leetcode.medium2;


/**
 * 数字范围按位与
 * https://leetcode-cn.com/submissions/detail/8064444/
 * 
 *[Solution]
 *https://www.cnblogs.com/grandyang/p/4431646.html 
 *
 *观察二进制规律!
 *位运算, 算法真的是叼
 */
public class Test93 {

	/**0 2147483647
	* 超时
	*/
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i=m; i<=n; i++) {
            res = res&i;
        }
        
        return res;
    }
}

class Nice_Test93 {
	public int rangeBitwiseAnd(int m, int n) {
		int i=0;
		while (m != n) {
			//Core. 寻找m,n数字位数上相同的部分, 则为"与"之后的结果!
			m >>= 1; 
        	n >>= 1;
        	++i;
		}
		return (m<<i);
	}
}
