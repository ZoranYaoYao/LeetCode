package com.zoran.leetcode.simple3;

/**
 * 458. ������С��
 * https://leetcode-cn.com/problems/poor-pigs/description/
 * 
 * �������������, �о�������, С��ÿ15���ӵ����ܺȶ���?
 * 
 * [Solution]
 * https://blog.csdn.net/Torch_Man/article/details/80559530 
 */
public class Test98 {

	/**
	 * wrong algorithm 
	 */
//    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
//        //500 + 250 + 125 +75 = 950
//        //count = p / 15; ������
//        int count = minutesToTest / minutesToDie;
//        int pigNums = 0;
//        while(count > 0) {
//            buckets = buckets /2;
//            pigNums += buckets;
//            count--;
//        }
//        
//        return pigNums;
//    }
    
    
    public int Nice_poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets == 1) return 0;
        int base = minutesToTest / minutesToDie + 1;
        int r = 1; int i = 0;
        while(r < buckets) {
            r *= base;
            i++;
        }
        return i;
    }
}
