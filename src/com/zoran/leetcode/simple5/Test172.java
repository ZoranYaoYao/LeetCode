package com.zoran.leetcode.simple5;

/**
 * Ѱ�ұ�Ŀ����ĸ�����С��ĸ
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
    
    //�۰���ҷ�
    public char Nice_nextGreatestLetter(char[] letters, char target) {
    	int len = letters.length;
    	int low =0; int high = len -1;
    	while (low <= high) {  //ƽʱ���м�ֵ��, low > high ˵��û���ҵ�, ������һ���ĵ���
    		int middle = low + (high -low)/2;
    		if (letters[middle] <= target) { //Core. С�ڵ�ʱ��,���������в���
    			low = middle +1; 
    		}else {
				high = middle -1;
			}
    	}
    	
    	return low < len ? letters[low] : letters[0];
    }
}
