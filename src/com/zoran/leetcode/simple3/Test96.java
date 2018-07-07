package com.zoran.leetcode.simple3;

/**
 * ��С�ƶ�����ʹ����Ԫ�����
 * https://leetcode-cn.com/submissions/detail/3886458/
 * 
 * [Solution]
 * https://www.cnblogs.com/grandyang/p/6053827.html
 */
public class Test96 {

	public static void main(String[] args) {
		int[] nums = {1,2147483647};
		System.out.println(minMoves(nums));
	}

	/**
	 * [1,2147483647] ��ʱ
	 */
	public static int minMoves(int[] nums) {
		if(nums == null || nums.length ==0) return 0;
		int count =0;
		int maxIndex = 0;

		while (!numsEqual(nums)){
			for(int i=1; i < nums.length; i++) {
				if(nums[i] > nums[maxIndex]) {
					maxIndex = i;
				}
			}

			for(int i=0; i < nums.length; i++) {
				if(i != maxIndex) {
					nums[i]++;
				}
			}
			count++;
		} 

		return count;
	}

	public static boolean numsEqual(int[] nums) {
		for(int i = 1; i <= nums.length - 1; i++) { //Core. i-1ʱ,Ҫ�������һ��Ԫ��
			if(nums[i] != nums[i - 1]) {
				return false;
			}
		}  
		return true;
	}
	
	/**
	 *  Nice_Nice����˼ά: (�����Ԫ��)ȫ���1  means  �������1, ���ı��ֵ
	 */
	public int Nice_minMoves(int[] nums) {
		int mn = Integer.MAX_VALUE; int res = 0;
		for (int num: nums) mn = Math.min(mn, num);
		for(int num: nums) res += num -mn;
		return res;
	}
}
