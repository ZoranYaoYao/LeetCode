package com.zoran.leetcode.medium6;

/**
 * 乘积小于K的子数组
 * https://leetcode-cn.com/submissions/detail/12698586/
 */
public class Test267 {
    public static void main(String[] args) {
        Test267 test267 = new Test267();
        int[] nums = {10,5,2,6};
        int res = test267.numSubarrayProductLessThanK(nums, 100);
        System.out.println(res);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //穷举法 判断
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int temp = 1;
            for (int j=i; j<nums.length; j++) {
                temp *= nums[j];

                if (temp < k){
                    System.out.println(temp);
                    count++;
                }
                else
                    break;
            }
        }
        return count;
    }
}
