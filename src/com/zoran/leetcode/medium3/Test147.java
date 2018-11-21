package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * 摆动序列
 * https://leetcode-cn.com/submissions/detail/9596450/
 *
 * [Solution]
 * https://blog.csdn.net/laputafallen/article/details/79874727
 * https://blog.csdn.net/xuchonghao/article/details/81082673
 */
public class Test147 {

    public static void main(String[] args) {
        Test147 test147 = new Test147();
        int[] nums = {1,7,4,9,2,5};
        int res = test147.wiggleMaxLength(nums);
        System.out.println(res);
    }

    /**
     * 问题点： 把0，1点作为必要的点，出现问题
     */
    public int wiggleMaxLength(int[] nums) {
        //动态规划，并记录最后一个元素差值
        //dp[i] = (dp[i-1], dp[i-1]+1)
        if (nums == null || nums.length == 0) return 0;

        int[] loc = new int[nums.length];  //记录最后一个元素值
        int[] symbol = new int[nums.length]; //记录最后一次的差值
        int[] dp = new int[nums.length];
        dp[0] = 1;
        loc[0] = nums[0];
        symbol[0] = nums[0] > 0 ? 1 : -1;
        dp[1] = 2;
        loc[1] = nums[1];
        symbol[1] = nums[1] - nums[0] > 0 ? 1 : -1;
        for (int i = 2; i < nums.length; i++) {
            if ((symbol[i - 1] == 1 && nums[i] - loc[i-1] < 0)
                    || (symbol[i - 1] == -1 && nums[i] - loc[i-1] > 0)) {
                dp[i] = dp[i - 1] + 1;
                symbol[i] = nums[i] - loc[i-1] < 0 ? -1 : 1;
                loc[i] = nums[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[nums.length - 1];
    }
}

class Nice_Test147 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] up = new int[nums.length];
        int[] down = new int[nums.length];
        Arrays.fill(up,1);
        Arrays.fill(down,1);  //Core 对于每一元素，默认都是从0开始大小的！
        for (int i=1; i< nums.length; i++) {
            for (int j =0; j<i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] +1); //Core. up[i]是通过前面的down[j]值过来的，穷举遍历
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1); //Core. down[i] 是通过前面的up[j]值过来的，穷举遍历
                }
            }
        }

        return Math.max(down[nums.length -1], up[nums.length -1]);
    }
}
