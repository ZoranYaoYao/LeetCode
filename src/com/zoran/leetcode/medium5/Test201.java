package com.zoran.leetcode.medium5;

/**
 * ��Ī����
 * https://leetcode-cn.com/submissions/detail/10976986/
 */
public class Test201 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,11,13,15}; //20 17
        Test201 test201 = new Test201();
        int res = test201.findPoisonedDuration(nums, 3);
        System.out.println(res);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        //ʱ����ص����㣬����ص���ֱ������0��ʼ����
        int res = 0;
        int endTime = 0;
        for (int i=0; i<timeSeries.length; i++) {
            if (endTime == 0) endTime = timeSeries[i] + duration;
            int nextStart = Integer.MAX_VALUE; //Core ��һ�ο�ʼ��ʱ�䣬Ĭ��ȡ���ֵ����֤���һ��Ԫ�ؿ���
            if (i+1 < timeSeries.length) nextStart = timeSeries[i+1];

            if (endTime <= nextStart) {
                res +=duration;
            } else {
                res += nextStart - timeSeries[i];
            }
            endTime = nextStart + duration; //Nice_Core!! �����ص���񣬶�����һ���ڵ㿪ʼʱ��+���ʱ��
            System.out.println("res = " + res); //�������ֺ�ʱ����
        }

        return res;
    }
}
