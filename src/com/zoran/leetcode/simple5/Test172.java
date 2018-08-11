package com.zoran.leetcode.simple5;

/**
 * 寻找比目标字母大的最小字母
 * https://leetcode-cn.com/submissions/detail/5396535/
 */
public class Test172 {

    public char nextGreatestLetter(char[] letters, char target) {
        for(int i=0; i<letters.length; i++) {
            if(target - letters[i] < 0) {
                return letters[i];
            }
        }
        
        return letters[0];
    }
    
    //折半查找法
    public char Nice_nextGreatestLetter(char[] letters, char target) {
    	int len = letters.length;
    	int low =0; int high = len -1;
    	while (low <= high) {  //平时找中间值是, low > high 说明没有找到, 所以是一样的道理
    		int middle = low + (high -low)/2;
    		if (letters[middle] <= target) { //Core. 小于的时候,向大的数进行查找
    			low = middle +1; 
    		}else {
				high = middle -1;
			}
    	}
    	
    	return low < len ? letters[low] : letters[0];
    }
}
