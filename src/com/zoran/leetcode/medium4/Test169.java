package com.zoran.leetcode.medium4;

/**
 * 分割等和子集
 * https://leetcode-cn.com/submissions/detail/10459758/
 *
 * [Solution]
 * http://www.mamicode.com/info-detail-2358579.html
 */
public class Test169 {

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,5};
        Test169 test169 = new Test169();
        boolean res = test169.canPartition(nums);
        System.out.println(res);
    }

    /**
     * 算法正确，但是大数组 超时
     */
//    public boolean canPartition(int[] nums) {
//        //总和除以2， 然后回溯算法 选择是否要值
//        Arrays.sort(nums);
//        int count = 0;
//        for(int item : nums) {
//            count += item;
//        }
//        if (count % 2 != 0) return false;
//
//        boolean res = backTrace(nums, 0, count/2, 0);
//        return res;
//
//    }
//
//    public boolean backTrace(int[] nums, int curCount, int expect, int startIndex) {
//        System.out.println("curCount = " + curCount);
//        if(curCount == expect) return true;
//        if (curCount > expect) return false;
//
//        boolean res = false;
//        for(int i=startIndex; i<nums.length; i++) {
//            curCount += nums[i];
//            res = backTrace(nums, curCount, expect, i+1);
//            if(res) return true;
//            curCount -= nums[i];
//        }
//        return res;
//    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        if ((sum & 1) == 1) return false;  //Core. & 1 可以表示奇偶性
        sum >>= 1;  //Core. 数字 /2
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int j = 0; j < nums.length; j++) {
            for (int i = sum; i >=nums[j]; i--) {
                dp[i] = dp[i] || dp[i-nums[j]]; //Nice_Core. 每次都去刷新dp[sum] - dp[0]的值
                int a = i -nums[j];
                System.out.println("j = " + j + ", nums[j] = " + nums[j]);
                System.out.println("dp["+a+"]" + " = " + dp[a]);
            }

            if (dp[sum]) return true;
        }
        return dp[sum];
    }
}
