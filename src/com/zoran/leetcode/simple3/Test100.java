package com.zoran.leetcode.simple3;

/**
 * 汉明距离
 * https://leetcode-cn.com/submissions/detail/3994281/
 */
public class Test100 {
	
	/**
	 * OT 
	 */
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x>0 || y > 0) {
            int itemX = x & 01;  //Core. 获取尾数的二进制值
            int itemY = y & 01;
            if(itemX != itemY) count++;
            x = x >> 1;
            y = y >> 1;
        }
        
        return count;
    }
}
