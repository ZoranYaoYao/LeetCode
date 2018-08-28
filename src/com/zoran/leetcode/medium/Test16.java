package com.zoran.leetcode.medium;

/**
 * ��һ������
 * https://leetcode-cn.com/submissions/detail/6156463/
 * 
 * [Solution]
 * https://leetcode-cn.com/problems/next-permutation/solution/
 * 
 * a[i-1]Ϊʲô����������ǽ����?
 * ��: ������Ҫ���ұ��ҵ���һ���������������� a[i]�� a[i-1]
 * ��һ��,һ���ܱ�֤�����ǽ����!!, ����:
 * 15463572 -> ��һ��λ��: 15463 572 -> 15463 752
 */
public class Test16 {

	public void Nice_nextPermutation(int[] nums) {
		int i = nums.length-2;
		while(i>=0 && nums[i+1] <= nums[i]) { //Core. �ҵ���һ�Բ������
			i--;
		}
		
		if(i >= 0) {
			int j = nums.length -1;
			while (j>=0 && nums[j] <= nums[i]) { //Core. Ѱ�Ҹոմ���Ҫ����������
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
