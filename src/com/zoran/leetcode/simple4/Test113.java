package com.zoran.leetcode.simple4;

/**
 * 完美数
 * https://leetcode-cn.com/submissions/detail/4151813/
 * 
 * [Solution]
 * https://blog.csdn.net/LITTENg/article/details/80202780
 */
public class Test113 {
	
	public static void main(String[] args) {
		System.out.println(checkPerfectNumberU1(28));
	}

	/**
	 * 超时 :99999993 
	 */
    public boolean checkPerfectNumber(int num) {
        int count = 0;
        for(int i = 1; i < num; i ++) {
            if(num % i == 0) count += i;
        }
        return count == num;
    }
    
	/**
	 * 超时 :99999993 
	 */
    public static boolean checkPerfectNumberU1(int num) {
        int count = 0; int flag = num;
        for(int i = 2; i < num ; i ++) {
            if(num % i == 0 && i < flag ) {
                count += i;
                flag = num/i;
                count += flag;
            }
        }
        return count + 1 == num;
    }

    /**
     *  易知一个数n一半的因子都在 [1,sqrt(n)]区间当中
     *  n * n = nums 中间值为 n
     */
    public static boolean Nice_checkPerfectNumber(int num) {
    	if(num == 1) return false;
    	int count = 1;
    	for (int i = 2; i <= Math.sqrt(num); i++) {
    		if (num % i == 0) {
				count += i + num/i;
			}
    	}
    	return count == num;
    }
}
