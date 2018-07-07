package com.zoran.leetcode.simple3;

/**
 * 最小移动次数使数组元素相等
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
	 * [1,2147483647] 超时
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
		for(int i = 1; i <= nums.length - 1; i++) { //Core. i-1时,要包含最后一个元素
			if(nums[i] != nums[i - 1]) {
				return false;
			}
		}  
		return true;
	}
	
	/**
	 *  Nice_Nice逆向思维: (除最大元素)全体加1  means  最大数减1, 不改变差值
	 */
	public int Nice_minMoves(int[] nums) {
		int mn = Integer.MAX_VALUE; int res = 0;
		for (int num: nums) mn = Math.min(mn, num);
		for(int num: nums) res += num -mn;
		return res;
	}
}
