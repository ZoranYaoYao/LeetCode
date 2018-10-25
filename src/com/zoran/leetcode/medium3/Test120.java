package com.zoran.leetcode.medium3;

/**
 * �����������
 * https://leetcode-cn.com/submissions/detail/8661193/
 * 
 * ����: ������������ļ���
 * ��̬�滮: �����������н� 
 *
 * [Solution]
 * https://blog.csdn.net/OneDeveloper/article/details/80047289
 */
public class Test120 {
	
	public static void main(String[] args) {
		Test120 test120 = new Test120();
		int[] nums = {10,9,2,5,3,4};
		test120.lengthOfLIS(nums);
	}
	
	/**
	 * �����㷨��ȷ, ���ǻᳬʱ
	 */
    int max = 0;
    public int lengthOfLIS(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            backTrace(nums, i, 1, nums[i]);
        }
        System.out.println("max = " + max);
        return max;
    }
    
    private void backTrace(int[] nums, int curIndex, int count,int lastNum) {
        if (curIndex == nums.length-1) {
//        	System.out.println("count" + count);
            max = Math.max(max, count);
            return;
        }
        
        for (int i = curIndex+1; i<nums.length; i++) {
            if (nums[i] > lastNum) {
                backTrace(nums, i, ++count, nums[i]);
                --count;
            }
            
            if (i== nums.length-1) {
//            	System.out.println(count);
                max = Math.max(max, count);
            }
        }
    }
}

class Nice_Test120 {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		
		int[] dp = new int[nums.length];
		dp[0] =1;
		int result = 1;
		for (int i=1; i<nums.length; i++) {
			int max =0;
			for (int j=i-1; j>=0; j--) {
				if (nums[i]>nums[j] && max<dp[j]) //NNice_Core. dp[i]������ǰ���dp[j], �ڼӳ����г���
					max = dp[j];
			}
			dp[i] = max + 1;
			result = Math.max(result, dp[i]);
		}
		
		return result;
	}
}





























