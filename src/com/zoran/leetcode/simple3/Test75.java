package com.zoran.leetcode.simple3;

/**
 * ��Ч����ȫƽ����
 * https://leetcode-cn.com/submissions/detail/3572218/
 */
public class Test75 {

	/**
	 * Core. ����,����. ����ƽ����
	 * �۰���ҷ�, ���м������ƽ�� �� num���жԱ�
	 */
    public boolean isPerfectSquare(int num) {
        if(num ==1) return true;
        
        int left = 0, right = num;
        while (left <= right) {
            int middle = left + (right - left) /2; //Core. ��Խ��
            if (num / middle > middle) { //Core. ������Խ��
              left = middle + 1;  
            } else if(num / middle < middle) {
                right = middle -1;
            } else {
                if(num % middle == 0) return true;
                return false;
            }
        }
        
        return false;
    }
}
