package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;

/**
 * 丑数 II
 * https://leetcode-cn.com/submissions/detail/8612564/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_14927217/article/details/73614325
 * https://www.cnblogs.com/njczy2010/p/5708377.html 
 *
 * 纪录的是, 
 * *2 超过当前元素的位置, 
 * *3 超过当前元素的位置, 
 * *5 超过当前元素的位置, 
 */
public class Test112 {
	
	public static void main(String[] args) {
		Test112 test112 = new Test112();
		int res = test112.nthUglyNumber(100);
		System.out.println(res);
	}

	/**
	 * 超时
	 */
    public int nthUglyNumber(int n) {
        //计数 + 判断当前是否是丑数
        //因式分解 : 1*2*3*5...
        int index =0;
        for (int i=1; i<Integer.MAX_VALUE; i++) {
            if (isUglyNumber(i)) {
            	index++;
            }
            
            if(index == n) return i;
        }
        
        return -1;
    }
    
    private boolean isUglyNumber(int n) {
        if (n == 1) return true;
        
        while (n != 1) {
        	
            if (n % 2 == 0) {n = n/2; continue;}
            if (n % 3 == 0) {n = n/3; continue;}
            if (n % 5 == 0) {n = n/5; continue;}
            
            return false;
        }
        
        return true;
    }
}







class Nice_Test112 {
	public int nthUglyNumber(int n) {
		List<Integer> uglys = new ArrayList<>();
		uglys.add(1);
		int p2 =0; int p3 =0; int p5 =0;
		for (int i=1; i<n; i++) {
			int lastNumber = uglys.get(uglys.size()-1);
			/**
			 * ----------------------------->
			 *   	p5     p3      p2
			 *  Note: 如果p3位置乘以2,是一定小于lastNumber的, 所以p2索引值在最前面, 同理 p5在最后面!!
			 */
			while (uglys.get(p2)*2 <= lastNumber) p2++;  //Nice_Core. 纪录上一个值的位置. 在乘以2
			while (uglys.get(p3)*3 <= lastNumber) p3++;
			while (uglys.get(p5)*5 <= lastNumber) p5++;
			int newValue = Math.min(uglys.get(p2)*2, Math.min(uglys.get(p3)*3, uglys.get(p5)*5));
			uglys.add(newValue);
		}
		
		return uglys.get(uglys.size() -1);
	}
}

//使用数组, 效率更高!!
class LeetCode_Test112 {
    public int nthUglyNumber(int n) {
        int[]ugly = new int[n];
        ugly[0] = 1;
        int num_2 = 0;
        int num_3 = 0;
        int num_5 = 0;
        for(int i = 1;i<n;i++)
        {
            ugly[i] = Math.min(Math.min(ugly[num_2]*2,ugly[num_3]*3),ugly[num_5]*5);
            if(ugly[i] / ugly[num_2] == 2)
                num_2 ++;
            if(ugly[i] / ugly[num_3] == 3)
                num_3 ++;
            if(ugly[i] / ugly[num_5] == 5)
                num_5 ++;
            // System.out.println(i+"  " + "i"+ " "+ num_2 + " " + num_3 + " " +num_5 + " " + ugly[i]);
        }
        return ugly[n-1];
    }
}























