package com.zoran.leetcode.simple4;

/**
 * 605. 种花问题
 * https://leetcode-cn.com/submissions/detail/4661342/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80204799
 */
public class Test135 {
	public static void main(String[] args) {
		Test135 test135 = new Test135();
		int[] nums = {1,0,0,0,0,1};
		System.out.println(test135.canPlaceFlowers(nums, 2));
	}

	/**
	 * [0,0,0,0,1]
	 * 考虑边界值问题出错 应该是[0]设置为1 !!!!!
	 */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //找到最大插入值
        int maxInsert = 0;
        if(flowerbed == null || flowerbed.length == 0) return false;
        
        if(flowerbed.length == 1 ) {
            if(flowerbed[0] == 1) return n <= 0;
            return n<=1;
        }
        if(flowerbed.length == 2) {
            if(flowerbed[0] == 0 && flowerbed[1] == 0) return n<=1;
            return n <= 0 ;
        }
        
        for(int i=2; i<flowerbed.length; i++) {
            if(i == 2 && flowerbed[i-2] == 0 && flowerbed[i-1] ==0) { //Core. 先处理开始位置的边距问题
                flowerbed[i-2] = 1;
               maxInsert++;
           }
            if(flowerbed[i-2] == 0 && flowerbed[i-1] ==0 && flowerbed[i] == 0) {
                flowerbed[i-1] = 1;
                maxInsert++;
            }

            if(i == flowerbed.length-1 && flowerbed[i-1] ==0 && flowerbed[i] == 0) {
                 flowerbed[i] = 1;
                maxInsert++;
            }
        }
        
        return maxInsert >= n;
    }

    public boolean Nice_canPlaceFlowers(int[] flowerbed, int n) {
    	for(int i=0; i<flowerbed.length; i++) {
    		if (satisfy(flowerbed, i)) {
				flowerbed[i] =1;
				n--;
			}
    	}
    	return n<=0;
    }

    /**
     * 判断能否种的正确判定 
     *    1.连续的3个0
     *    2.特例:边界2个
     */
	private boolean satisfy(int[] flowerbed, int i) {
		if(flowerbed[i] == 1) return false;
		int index = flowerbed.length-1;
		
		if(flowerbed[i] == 0 && (i-1<0 || flowerbed[i-1] ==0) && (i+1>index || flowerbed[i+1] ==0)) return true;
		return false;
	}
}
