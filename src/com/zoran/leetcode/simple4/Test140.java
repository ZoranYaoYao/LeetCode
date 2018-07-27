package com.zoran.leetcode.simple4;

/**
 * 633. ƽ����֮��
 * https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 * 
 * [Solution]
 * https://blog.csdn.net/m0_37693059/article/details/77985348
 */
public class Test140 {

	/**
	 * ��ʱ:
	 * 2147482647
	 */
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        for(int a = 0; a <= max; a++) {
            for(int b = 0; b <= max; b++) {
                if(a*a + b*b == c) return true;
            }
        }
        
        return false;
    }
    
    /**
     * �۰���ҷ�����:
     * ���������������۰�����
     */
    public boolean Nice_judgeSquareSum(int c) {
    	if (c < 0) return false;
    	int mid = (int) Math.sqrt(c);
    	int left = 0; int right = mid;
    	while (left <= right) {
    		int temp = left* left + right*right;
    		if(c == temp) return true;
    		else if (c > temp) left++;
    		else right--;
    	}
    	
    	return false;
    }
}
