package com.zoran.leetcode.simple2;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 * https://leetcode-cn.com/submissions/detail/3146845/
 * 
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/8564438.html
 * https://www.cnblogs.com/grandyang/p/4447233.html  4是一个无限循环的不快乐数
 */
public class Test45 {
	public static void main(String[] args) {
		System.out.println(Nice_isHappy(19));
	}
	
    public static boolean isHappy(int n) {
    	int times = 0;
        while (n != 1) {
        	int count = 0;
            while(n != 0) {
                int tmp = n % 10 ; 
                count += tmp*tmp;
                n = n / 10;
            }
            
            if(count == 1) return true;
            n = count;
            times++;
            if(times > 30) return false; // 瑕疵点-> 无限循环跳出限制
        }
        
        return true;
    }

    public static boolean Nice_isHappy(int n) {
    	Set<Integer> set = new HashSet<>();
    	while(n != 1 && !set.contains(n)) {
    		set.add(n); //Nice_core : 记录循环中是否n 是否出现过,如果已经出现了,说明就会进入无限死循环中
    		int count =0;
    		while (n != 0) {
    			int tmp = n % 10;
    			count += tmp * tmp;
    			n = n / 10;
    		}
    		
    		if(count == 1) return true;
    		n = count;
    	}
    	
    	return n == 1;
    }
}
