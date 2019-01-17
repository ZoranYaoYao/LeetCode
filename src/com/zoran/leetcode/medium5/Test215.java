package com.zoran.leetcode.medium5;

/**
 * 优美的排列
 * https://leetcode-cn.com/submissions/detail/11735561/
 */
public class Test215 {
    public static void main(String[] args) {
        Test215 test215 = new Test215();
        int a = test215.countArrangement(2);
        System.out.println(a);
    }

    int res;

    public int countArrangement(int N) {
        //条件 a[i]/i =0 | i/a[i] = 0
        //回溯+ 标记法
        int[] nums = new int[N + 1];
        for (int i = 1; i < nums.length; i++) nums[i] = i;
        int[] mark = new int[N + 1];
        backTrace(nums, mark, 1);
        return res;
    }

    public void backTrace(int[] nums, int[] mark, int curIndex) {
        if (curIndex == nums.length) res++; //Core。 递归出口的位置

        for (int j = 1; j < nums.length; j++) {
            if (mark[j] == 0 && (nums[j] % curIndex == 0 || curIndex % nums[j] == 0)) {
                mark[j] = 1;
                backTrace(nums, mark, curIndex + 1);
                mark[j] = 0;
            }
        }
    }
}
