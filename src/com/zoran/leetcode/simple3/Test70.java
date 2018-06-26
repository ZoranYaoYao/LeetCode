package com.zoran.leetcode.simple3;

/**
 * 4的幂
 * https://leetcode-cn.com/submissions/detail/3533442/ 
 * 
 * [Solution]
 * https://blog.csdn.net/u010564321/article/details/51210749
 */
public class Test70 {

    public boolean isPowerOfFour(int num) {
        if(num == 0) return false;
        
        while(num != 1) {
            if(num % 4 != 0) return false; //判断是否整除4
            num = num /4;  //获得除以4之后的因子
        }
        return true;
    }
    
    public boolean Nice_isPowerOfFour(int num) {
    	return (num & (num -1)) == 0 && num > 0 && (num & 0x55555555) != 0;
    }
}
