package com.zoran.leetcode.medium3;

/**
 * 水壶问题
 * https://leetcode-cn.com/submissions/detail/9157979/
 * 
 * [Solution]
 * https://blog.csdn.net/seagal890/article/details/79370653
 *
 */
public class Test142 {

    public boolean canMeasureWater(int x, int y, int z) {
        //规律, 大往小一个差值 + 大小值, 小往大溢出一个差值 + 大小值, 或者 z = x + y
        if (x == 0 && y != z) return false;
        if (y == 0 && z != x) return false;
        
        if (z > x + y) return false;
        if (z == x + y) return true;
        
        if (x > y) {
            int temp = x; x= y; y = temp;
        }
        
        if (y - x + y == z || y == z || x == z) return true;
        
        int temp = x;
        int times = 1;
        while (temp-y < 0) {
            temp = x*(++times);
        }
        if (temp-y == z || temp-y+x == z|| temp == z) return true;
        
        return false;
    }
}
