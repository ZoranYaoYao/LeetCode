package com.zoran.leetcode.simple5;

/**
 * ��������˵�������
 * https://leetcode-cn.com/submissions/detail/5791871/
 * 
 * ���˿��ö��Ĵ����ύ! �ɶ���
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
        return Integer.MAX_VALUE; //Core. û���ҵ�,�����ֵ,�ް�����
    }
    
    public int findRight(int[] seats, int index) {
        for(int i=index+1; i<seats.length; i++) {
            if(seats[i] == 1) return i-index;
        }
        return Integer.MAX_VALUE;
    }
}
