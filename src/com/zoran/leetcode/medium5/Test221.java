package com.zoran.leetcode.medium5;

/**
 * ���������еĵ�һԪ��
 * https://leetcode-cn.com/submissions/detail/11745155/
 *
 * ���úõĹ�ʽ��a^a = 0���ҵ�����ֵ
 */
public class Test221 {
    public static void main(String[] args) {
        Test221 test221 = new Test221();
        int[] nums = {1, 1, 2};
        int res = test221.singleNonDuplicate(nums);
        System.out.println(res);
    }

    public int singleNonDuplicate(int[] nums) {
        //�۰���ң�ǰ���Ƿ�����ֵͬ
        int res = halfSearch(nums, 0, nums.length - 1);
        return res;
    }

    /**
     * Core. �ݹ������ң���
     */
    private int halfSearch(int[] nums, int left, int right) {
        int res = -1;
        if(left > right || right < 0 ) return res;

        int mid = (left + right) / 2;
        if ((mid < nums.length-1 && nums[mid] == nums[mid + 1]) ||  (mid > 0 && nums[mid] == nums[mid - 1])) {
            res = halfSearch(nums, left, mid - 1);
            if (res != -1) return res;

            res = halfSearch(nums, mid + 1, right);
            if (res != -1) return res;
        } else {
            return  nums[mid];
        }

        return -1;
    }
}

class LeetCode_Test221 {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        for (int i=0; i<nums.length; i++) {
            ans ^= nums[i]; //Nice_Core ͨ��a^a = 0��ʽ�������ҵ�������ֵ����
        }
        return ans;
    }
}
