package com.zoran.leetcode.medium;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/submissions/detail/5992430/ 
 */
public class Test06 {

    public int maxArea(int[] height) {
        if(height == null || height.length ==0) return 0;
        
        int max = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=i+1; j<height.length; j++) {
                int mheight = Math.min(height[i], height[j]);
                int mwidth = j-i;
                max = Math.max(max, mheight*mwidth);
            }
        }
        
        return max;
    }
}
