package com.zoran.leetcode.medium;

/**
 * 下一个排列
 * https://leetcode-cn.com/submissions/detail/6156463/
 * 
 * [Solution]
 * https://leetcode-cn.com/problems/next-permutation/solution/
 * 
 * a[i-1]为什么后面的数字是降序的?
 * 答: 我们需要从右边找到第一对两个连续的数字 a[i]和 a[i-1]
 * 第一对,一定能保证后面是降序的!!, 例如:
 * 15463572 -> 第一对位置: 15463 572 -> 15463 752
 */
public class Test16 {

	public void Nice_nextPermutation(int[] nums) {
		int i = nums.length-2;
		while(i>=0 && nums[i+1] <= nums[i]) { //Core. 找到第一对差距数据
			i--;
		}
		
		if(i >= 0) {
			int j = nums.length -1;
			while (j>=0 && nums[j] <= nums[i]) { //Core. 寻找刚刚大于要交换的数字
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i+1);
	}

	private void reverse(int[] nums, int start) {
		int i = start; int j = nums.length -1;
		while(i<j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
