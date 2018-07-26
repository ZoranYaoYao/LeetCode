package com.zoran.leetcode.simple4;

/**
 * 605. �ֻ�����
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
	 * ���Ǳ߽�ֵ������� Ӧ����[0]����Ϊ1 !!!!!
	 */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        //�ҵ�������ֵ
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
            if(i == 2 && flowerbed[i-2] == 0 && flowerbed[i-1] ==0) { //Core. �ȴ���ʼλ�õı߾�����
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
     * �ж��ܷ��ֵ���ȷ�ж� 
     *    1.������3��0
     *    2.����:�߽�2��
     */
	private boolean satisfy(int[] flowerbed, int i) {
		if(flowerbed[i] == 1) return false;
		int index = flowerbed.length-1;
		
		if(flowerbed[i] == 0 && (i-1<0 || flowerbed[i-1] ==0) && (i+1>index || flowerbed[i+1] ==0)) return true;
		return false;
	}
}
