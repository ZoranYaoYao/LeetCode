package com.zoran.leetcode.medium;

import java.util.Arrays;

/**
 * ��ӽ�������֮��
 * https://leetcode-cn.com/submissions/detail/6039447/
 * 
 * ����ָ���ҹ̶�ֵ
 */
public class Test09 {
	
	public static void main(String[] args) {
		Test09 test09 = new Test09();
		int[] nums = {-1,2,1,-4};
		System.out.println(test09.threeSumClosest(nums, 1));
	}

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length < 3) return -1;

		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			int left=i+1; int right=nums.length-1;
			while(left<right) {
				int sum = nums[i] + nums[left] + nums[right];
				int diff = sum-target;
				if(diff == 0) {
					return target;
				} else if (diff>0) {
					if(diff<min) {
						min = diff;
						result = sum;
					}
					right--;
				} else if(diff<0) {
					if(-diff<min) {
						min = -diff;
						result = sum;
					}
					left++;
				}
			}
		}

		return result;
	}

	/**
	 * ѭ��sumֵ���޿���target����
	 */
	public int Nice_threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		int diff = Integer.MAX_VALUE;
		int res = target;
		Arrays.sort(nums);
		
		for(int base=0; base<n-2; ++base) {
			int start = base+1;
			int end = n-1;
			while(start<end) {
				int sum = nums[base] + nums[start] + nums[end];
				if(sum == target) {
					return target;
				} else if(sum > target) { //Core. ����sum>0,����sum<0. �ƶ���ָ�붼�����߿���targetֵ
					end--;
				} else {
					start++;
				}
				int curdiff = Math.abs(sum-target);
				if(curdiff < diff) {
					diff = curdiff;
					res = sum;
				}
			}
		}
		
		return res;
	}
}
