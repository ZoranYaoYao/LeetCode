package com.zoran.leetcode.medium3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 超级丑数
 * https://leetcode-cn.com/submissions/detail/8829335/
 * 
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/9758211.html
 */
public class Test126 {
//	public static void main(String[] args) {
//		Test126 test126 = new Test126();
//		int[] nums = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
//		int res = test126.nthSuperUglyNumber(100000, nums);
//		System.out.println(res);
//	}
	
    Set<Integer> set = new HashSet<>();
    public int nthSuperUglyNumber(int n, int[] primes) {
        // 穷举, 分解因式进行判断
        if(n == 1) return 1;
        int index = 0;
        for (int i=1; i<Integer.MAX_VALUE; i++) {
            if (isUgly(i, primes)) {
            	index++;
            	set.add(i);
            	System.out.println(i);
            }
            if (index == n) return i;
        }
        
        return -1;
    }
    
    private boolean isUgly(int num, int[] primes) {
    	if (num == 1) return true;
    	
        while (num != 1) {
        	if (set.contains(num)) return true;  //优化性能很小
        	
            boolean flag = false;
            for (int i=0; i<primes.length; i++) {
                if(num%primes[i] == 0) {
                    num /= primes[i];
                    flag = true;
                }
            } 
            
            if (!flag) return false;
        }
        
        return true;
    }
}

class Nice_Test126 {
	
	public static void main(String[] args) {
		Nice_Test126 test126 = new Nice_Test126();
		int[] nums = {2,7,13,19};
		int res = test126.nthSuperUglyNumber(12, nums);
		System.out.println(res);
	}
	
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n+1];
        ugly[0]=1;
        int[] pointer = new int[primes.length];
        for(int i=1;i<n;i++) {
            int min=Integer.MAX_VALUE;
            int minIndex = 0;
            for(int j=0;j<primes.length;j++) {
                if(ugly[pointer[j]]*primes[j]<min) {  //pointer[j]: !!!纪录上一次乘以primes[j]的位置,在ugly结果集里面的位置!!!!
                    min=ugly[pointer[j]]*primes[j];
                    minIndex = j;
                }else if(ugly[pointer[j]]*primes[j]==min) {
                    pointer[j]++;
                }
            }
            ugly[i]=min;
            pointer[minIndex]++;
            System.out.println(Arrays.toString(pointer));
            System.out.println(Arrays.toString(ugly));

        }
        return ugly[n-1];
    }
}
