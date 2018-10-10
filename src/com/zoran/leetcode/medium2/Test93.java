package com.zoran.leetcode.medium2;


/**
 * ���ַ�Χ��λ��
 * https://leetcode-cn.com/submissions/detail/8064444/
 * 
 *[Solution]
 *https://www.cnblogs.com/grandyang/p/4431646.html 
 *
 *�۲�����ƹ���!
 *λ����, �㷨����ǵ�
 */
public class Test93 {

	/**0 2147483647
	* ��ʱ
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
			//Core. Ѱ��m,n����λ������ͬ�Ĳ���, ��Ϊ"��"֮��Ľ��!
			m >>= 1; 
        	n >>= 1;
        	++i;
		}
		return (m<<i);
	}
}
