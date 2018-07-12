package com.zoran.leetcode.simple4;

/**
 * 492. 构造矩形
 * https://leetcode-cn.com/problems/construct-the-rectangle/description/
 */
public class Test107 {
	
    public int[] constructRectangle(int area) {
        int[] result = new int[2];
        //i 为长度
        for (int i =1; i <= area; i++) {
            if(area % i == 0 && i >= area/i) {
                if(result[0]== 0 || (i - area/i <= result[0] -result[1])) { //Core. result[0]== 0默认值时,也要做处理
                    result[0] = i;
                    result[1] = area / i;
                }
            }
        }
        
        return result;
    }
}
