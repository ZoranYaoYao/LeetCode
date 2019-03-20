package com.zoran.leetcode.medium6;

/**
 * ɾ�����õ���
 * https://leetcode-cn.com/submissions/detail/15102826/
 *
 * [Solution]
 * https://blog.csdn.net/OneDeveloper/article/details/80001202
 */
public class Test278 {

}

class Nice_Test278 {
    public int deleteAndEarn(int[] nums) {
        //dp[i] = dp[i-1] | dp[i-2]*(i-2) ����

        if (nums == null || nums.length == 0) return 0;
        int l = nums.length;
        int[] numCount = new int[10001];
        int max = 0;
        for (int i=0; i<l; i++) {
            numCount[nums[i]]++;
            //�Ż�1����ȡnums���ֵ����Լ��������
            max = Math.max(max, nums[i]);
        }

        int t1 = 0, t2 = numCount[1];
        int tmp = 0;
        for (int i=2; i<= max; i++) {
            tmp = Math.max(t2, numCount[i]*i + t1);
            //�Ż����� t1 ��ǰ������ t2����ǰһ��
            t1 = t2;
            t2 = tmp;
        }

        return t2;
    }
}
