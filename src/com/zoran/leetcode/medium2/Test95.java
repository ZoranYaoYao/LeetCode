package com.zoran.leetcode.medium2;

/**
 * 长度最小的子数组
 * https://leetcode-cn.com/submissions/detail/8110586/
 */
public class Test95 {
	
	public static void main(String[] args) {
		Test95 test95 = new Test95();
		int[] nums = {2,3,1,2,4,3};
		int res = test95.minSubArrayLen(7, nums);
		System.out.println(res);
	}

    public int minSubArrayLen(int s, int[] nums) {
        //穷举每一个点开始, 满足>=s的结果集,进行筛选
        if (nums == null || nums.length == 0) return 0;
        
        int minLen = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            int curCount = nums[i];
            int len = 1;
            if (curCount >= s) return 1;
            
            for (int j = i+1; j<nums.length; j++) {
                curCount += nums[j];
                len++;
                if(curCount >= s) {
                    minLen = Math.min(minLen, len); 
                    break;
                }
            }
        }
        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
