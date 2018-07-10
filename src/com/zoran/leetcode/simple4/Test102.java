package com.zoran.leetcode.simple4;

import java.util.Arrays;

/**
 * 供暖器
 * https://leetcode-cn.com/submissions/detail/4020256/
 * 
 * [Solution]
 * https://blog.csdn.net/MebiuW/article/details/53610837
 */
public class Test102 {
	
	/**
	 * error 
	 */
    public int findRadius(int[] houses, int[] heaters) {
        if(heaters == null || heaters.length == 1) {
        	if(houses[houses.length -1] - heaters[0] > heaters[0] - houses[0]) {
        		return houses[houses.length -1] - heaters[0];
        	} else {
        		return heaters[0] - houses[0];
        	}
        }
        
        //查看2点之间的间断距离
        int maxLength = 0;
        for(int i = 1; i < heaters.length; i++) {
            int length = heaters[i] - heaters[i -1];
            if(length > maxLength) maxLength = length;
        }
        
        return maxLength/2;
    }
    
    public int Nice_findRadius(int[] houses, int[] heaters) {
    	Arrays.sort(houses);
    	Arrays.sort(heaters);
    	int n = houses.length;
    	int m = heaters.length;
    	int miniMun = 0;
    	int j = 0;
    	for(int i = 0; i < n; i++) {
    		while (j < m-1 && (Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i]))) {
    			j++;
    		}
    		
    		miniMun = Math.max(miniMun, Math.abs(heaters[j] - houses[i]));
    	}
    	
    	return miniMun;
    }
}
