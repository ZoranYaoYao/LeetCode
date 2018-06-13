package com.zoran.leetcode.simple2;

import java.util.HashSet;
import java.util.Set;

/**
 * ������
 * https://leetcode-cn.com/submissions/detail/3146845/
 * 
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/8564438.html
 * https://www.cnblogs.com/grandyang/p/4447233.html  4��һ������ѭ���Ĳ�������
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
            if(times > 30) return false; // 覴õ�-> ����ѭ����������
        }
        
        return true;
    }

    public static boolean Nice_isHappy(int n) {
    	Set<Integer> set = new HashSet<>();
    	while(n != 1 && !set.contains(n)) {
    		set.add(n); //Nice_core : ��¼ѭ�����Ƿ�n �Ƿ���ֹ�,����Ѿ�������,˵���ͻ����������ѭ����
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
