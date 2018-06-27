package com.zoran.leetcode.simple3;

/**
 * 有效的完全平方数
 * https://leetcode-cn.com/submissions/detail/3572218/
 */
public class Test75 {

	/**
	 * Core. 数组,有序. 查找平方数
	 * 折半查找法, 找中间的数的平方 与 num进行对比
	 */
    public boolean isPerfectSquare(int num) {
        if(num ==1) return true;
        
        int left = 0, right = num;
        while (left <= right) {
            int middle = left + (right - left) /2; //Core. 不越界
            if (num / middle > middle) { //Core. 除法不越界
              left = middle + 1;  
            } else if(num / middle < middle) {
                right = middle -1;
            } else {
                if(num % middle == 0) return true;
                return false;
            }
        }
        
        return false;
    }
}
