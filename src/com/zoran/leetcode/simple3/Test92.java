package com.zoran.leetcode.simple3;

/**
 * 排列硬币
 * https://leetcode-cn.com/submissions/detail/3791429/
 * 
 * [Solution]
 * https://www.2cto.com/kf/201612/561789.html
 */
public class Test92 {

	public static void main(String[] args) {
		System.out.println(arrangeCoins(5));
	}
	
	/**
	 * 超时:
	 * 2147483647  
	 */
    public static int arrangeCoins(int n) {
        int count = 0; int row = 0;
        do {
        	row++;
        	count += row;
        } while (count < n);
        
        return count == n ? row : --row;
    }

    /**
     * 时间复杂度 O(1) 
     */
    public static int Nice_arrangeCoins(int n) {
    	return (int) ((Math.sqrt(8*(long)n + 1) -1) /2);
    }
}
