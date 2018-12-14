package com.zoran.leetcode.medium4;

/**
 * �ָ�Ⱥ��Ӽ�
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
     * �㷨��ȷ�����Ǵ����� ��ʱ
     */
//    public boolean canPartition(int[] nums) {
//        //�ܺͳ���2�� Ȼ������㷨 ѡ���Ƿ�Ҫֵ
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
        if ((sum & 1) == 1) return false;  //Core. & 1 ���Ա�ʾ��ż��
        sum >>= 1;  //Core. ���� /2
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int j = 0; j < nums.length; j++) {
            for (int i = sum; i >=nums[j]; i--) {
                dp[i] = dp[i] || dp[i-nums[j]]; //Nice_Core. ÿ�ζ�ȥˢ��dp[sum] - dp[0]��ֵ
                int a = i -nums[j];
                System.out.println("j = " + j + ", nums[j] = " + nums[j]);
                System.out.println("dp["+a+"]" + " = " + dp[a]);
            }

            if (dp[sum]) return true;
        }
        return dp[sum];
    }
}
