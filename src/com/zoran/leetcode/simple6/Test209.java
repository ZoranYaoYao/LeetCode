package com.zoran.leetcode.simple6;

/**
 * �����յ�����
 * https://leetcode-cn.com/submissions/detail/12961324/
 *
 * [Solutoin]
 * https://blog.csdn.net/elpsycongr00/article/details/81840602
 *
 * ��ѧ���ҹ���
 */
public class Test209 {

}

class Nice_Test209 {
    public int reachNumber(int target) {
        int times =1;
        int sum =0;
        //Nice_Core. ����ֻ�Ƿ��ţ����л�������
        if (target<0) target = -target;

        while (sum < target) {
            sum += times;
            times++;
        }
        //Core
        times--;

        int diff = Math.abs(sum - target);
        /**Nice �����ֵ��ż���Ļ���ͨ�����Ըı���Ž���ʵ�֣���*/
        if (diff%2 == 0) {
            return times;
        } else {
            if (times%2 == 0) {
                return times+1;
            } else {
                return times+2;
            }
        }
    }
}
