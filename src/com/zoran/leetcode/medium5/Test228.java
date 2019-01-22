package com.zoran.leetcode.medium5;

/**
 * ����Ƕ��
 * https://leetcode-cn.com/submissions/detail/11932252/
 *
 * FT
 */
public class Test228 {

    public int arrayNesting(int[] nums) {
        //����Ѱ������������Ƿ��ù�
        if(nums == null || nums.length == 0) return 0;
        int res = 0;
        boolean[] marked = new boolean[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                int temp = findChain(nums, marked, i);
                res = Math.max(temp, res);
            }
        }
        return res;
    }

    private int findChain(int[] nums, boolean[] marked, int start) {
        int count = 1;
        while (nums[start] < nums.length && !marked[nums[start]]) {
            marked[nums[start]] = true;
            count++;
            start = nums[start];
        }
        return count;
    }
}
