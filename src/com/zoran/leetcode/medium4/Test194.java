package com.zoran.leetcode.medium4;

/**
 * ���ƴ������
 * https://leetcode-cn.com/submissions/detail/10878536/
 *
 * [Solution]
 * https://blog.csdn.net/elpsycongr00/article/details/82915815
 * https://blog.csdn.net/qq_22080999/article/details/80834671 rebase
 *
 * ��������ѡ���ݣ������㷨
 */
public class Test194 {

    public boolean makesquare(int[] nums) {
        //�ı���ȣ����
        int count = 0;
        for (int i = 0; i<nums.length; i++) {
            count += nums[i];
        }
        if (count % 4 != 0) return false;

        int slide = count/4;
        int[] mark = new int[nums.length];
        /**���ѡ�������ߣ���*/
        for (int i=1; i<=4; i++) {

        }
        return false;
    }
}

class Nice_Test194 {

    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if (sum%4 != 0) return false;
        int[] bucket = new int[4];
        return generate(0, nums, sum/4, bucket);
    }

    /**
     * �����㷨
     */
    private boolean generate(int i, int[] nums, int target, int[] bucket) {
        if (i == nums.length) {
            return bucket[0] == target && bucket[1] == target &&
                    bucket[2] == target && bucket[3] == target;
        }

        for (int j=0; j<4; j++) {
            if (bucket[j] + nums[i] > target) continue;
            bucket[j] += nums[i];
            if (generate(i+1, nums, target, bucket)) return true;
            bucket[j] -= nums[i];
        }
        return false;
    }
}


























