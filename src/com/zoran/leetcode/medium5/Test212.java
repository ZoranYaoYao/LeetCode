package com.zoran.leetcode.medium5;

import java.util.HashSet;

/**
 * �������������
 * https://leetcode-cn.com/submissions/detail/11692503/
 *
 * [Nice_Solution]
 * LeetCode
 */
public class Test212 {
    public boolean checkSubarraySum(int[] nums, int k) {
        //��0��ʼ����ٱ���
        if (k == 0) {
            for (int i=1; i<nums.length; i++) {
                if(nums[i] == 0 && nums[i-1] == 0) return true;
            }
            return false;
        }

        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            for (int j=i+1; j<nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
            sum = 0;
        }
        return false;
    }
}

class LeetCode_Test212 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int pre = 0;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += nums[i];
            int mod =k == 0 ? sum : sum % k;
            if (set.contains(mod)) {
                return true;
            }
            set.add(pre);
            //Nice_core, ͨ����set������һ������������ֵ��ֻ�к�������ֵ����k�ı���ʱ���ͻ��ٴεõ�����������
            pre = mod;
        }
        return false;
    }
}