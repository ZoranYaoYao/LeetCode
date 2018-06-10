package com.zoran.leetcode.simple2;

/**
 * 阶乘后的零
 * https://leetcode-cn.com/submissions/detail/3065373/
 * 
 * 时间复杂度为 O(log(n)) 是对数形式的时候,必定是循环除以的状态
 * [eg]
 * nums = 5 ^ n -> log5 (30) 
 * 
 * [Solution]
 * https://www.cnblogs.com/qflyue/p/8974263.html
 */
public class Test40 {

	public static void main(String[] args) {
		System.out.println(Nice_trailingZeroes(40));
	}
	
	/**
	 * long 取值范围 2^63 -1 = 9.22 * 10*19
	 * 30! 大于long的取值范围 数值溢出
	 */
    public static int trailingZeroes(int n) {
        if (n == 0) return 0;
        if (n == 1) return 0;
        
        long num = 1;    int count = 0;
        while (n > 0) {
            num *= n;
            
            if  (num % 10 == 0) {
                count++;
                num = num /10;
            }
            
            n--;
        }
        
        return count;
    }
    
    /**
     * 时间复杂度 O(logN)
     * 问题: nums (long)数值溢出
     */
    public static int trailingZeroesUpdate(int n) {
    	if (n == 0) return 0;
    	
    	int left = 1; int right = n; long nums = 1;int count = 0;
    	while (left <= right) {
    		nums *= left * right;
    		if(left == right) nums = nums / left;
    		
    		if(nums % 10 == 0) {
    			count++;
    			nums = nums / 10;
    		}
    		left++;
    		right--;
    	}
    	
    	return count;
    }

    /**
     * 寻找 乘法因子5的个数
     * 时间复杂度 O(logN)
     */
    public static int Nice_trailingZeroes(int n) {
    	int sum = 0;
    	while (n > 0) {
    		sum += n/5;
    		n /= 5; //core 当n=25 = 5*5 , 有2个5.
    				//满5个必会多一个5
    	}
    	
    	return sum;
    }
}
