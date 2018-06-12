package com.zoran.leetcode.simple2;

/**
 * ��ҽ���
 * https://leetcode-cn.com/submissions/detail/3135909/
 * 
 * [Solution]
 * https://www.cnblogs.com/lightwindy/p/8648410.html
 */
public class Test44 {
	
	public static void main(String[] args) {
		//[2,1,1,2...]
		int[] nums = new int[] {2,1,1,2};
		System.out.println(Nice_rob(nums));
	}
	
	/**
	 *    Ҫô������� ȡ��һ�ҵ��ۻ�
     *    Ҫôȡ��� �����ϼҵ��ۻ�
	 * Dynamic Plan ��̬�滮
	 * dp[i] = max(num[i] + dp[i-2],dp[i-1]) 
	 */
	public static int Nice_rob(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		
		//a ά����һ�������ֵ, b ά�ֵ�ǰ�����ֵ
		int b = Math.max(nums[0], nums[1]);
		int a = nums[0];
		for(int i = 2; i< nums.length; i++) {
			/**core*/
			int tmp = b;
			b = Math.max(nums[i] + a, b);  //core : b ��ֵ֮ǰ��,��һ�ε����ֵ!
			a = tmp;
		}
		
		return b;
	}
	
	/**
	 * error 
	 */
	public int rob(int[] nums) {
		int oddSum = 0; int evenSum = 0;
		for(int i = 0; i < nums.length; i++) {
			if (i % 2 != 0) {
				oddSum += nums[i];
			} else {
				evenSum += nums[i];
			}
		}
		return Math.max(oddSum,evenSum);
	}
}
