package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表
 * https://leetcode-cn.com/submissions/detail/3630536/
 * 
 * [Solution]
 * https://blog.csdn.net/Shauna_Wu/article/details/78664218
 */
public class Test82 {
	
	/**
	 * 枚举每种case, 书写代码困难 
	 */
    public List<String> readBinaryWatch(int num) {
        int[] hour = {1,2,4,8};
        int[] minute = {1,2,4,8,16,32};
        
        for(int i = 0; i < num; i++) {
            List<String> hList = new ArrayList<>();
            String h = "";
            for(int k = 1; k <= i; k++) {
            }
            for(int j = 0; j < num -i; j++) {
                String str = "";
//                str = 
            }            
        }
        
        return null;
    }


    public List<String> Nice_readBinaryWatch(int num) {
    	List<String> result = new ArrayList<>();
    	for (int i = 0; i < 12; i++) {
    		for(int j =0; j < 60; j++) {
    			if(Integer.bitCount(i) + Integer.bitCount(j) == num) {
    				result.add(String.format("%d,%02d", i,j)); //Nice, 字符串格式处理
    			}
    		}
    	}
    	
    	return result;
    }
}
