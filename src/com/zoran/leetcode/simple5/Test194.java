package com.zoran.leetcode.simple5;

/**
 * 到最近的人的最大距离
 * https://leetcode-cn.com/submissions/detail/5791871/
 * 
 * 让人看得懂的代码提交! 可读性
 */
public class Test194 {

    public int maxDistToClosest(int[] seats) {
        int max = 0;
        for(int i=0; i<seats.length; i++) {
            if(seats[i] == 0) {
                int left = findLeft(seats,i);
                int right = findRight(seats,i);
                max = Math.min(left, right) > max ? Math.min(left, right) : max;
            }
        }
        return max;
    }
    
    public int findLeft(int[] seats, int index) {
        for(int i=index-1; i>=0; i--) {
            if(seats[i] == 1) return index-i;
        }
        return Integer.MAX_VALUE; //Core. 没有找到,则最大值,无挨近人
    }
    
    public int findRight(int[] seats, int index) {
        for(int i=index+1; i<seats.length; i++) {
            if(seats[i] == 1) return i-index;
        }
        return Integer.MAX_VALUE;
    }
}
