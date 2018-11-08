package com.zoran.leetcode.medium3;

/**
 * ˮ������
 * https://leetcode-cn.com/submissions/detail/9157979/
 * 
 * [Solution]
 * https://blog.csdn.net/seagal890/article/details/79370653
 *
 */
public class Test142 {

    public boolean canMeasureWater(int x, int y, int z) {
        //����, ����Сһ����ֵ + ��Сֵ, С�������һ����ֵ + ��Сֵ, ���� z = x + y
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
