package com.zoran.leetcode.simple4;

/**
 * 下一个更大元素 I
 * https://leetcode-cn.com/submissions/detail/4100806/
 * 
 * https://blog.csdn.net/daidaineteasy/article/details/52998209
 */
public class Test108 {
	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		int[] result = nextGreaterElement(nums1, nums2);
		for (int i : result) {
			System.out.println(i+ ",");
		}
	}

	/**
	 * goto的用法
	 */
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		for(int k = 0; k < nums1.length; k++) {
			here:for(int i = 0; i < nums2.length; i++) {
				if(nums1[k] == nums2[i]) {
					for(int j = i +1; j < nums2.length; j++) {
						if(nums2[j] > nums1[k]) {
							result[k] = nums2[j];
							break here;
						}

						if(j == nums2.length -1) {
							result[k] = -1;
							break here;
						}
					}
					result[k] = -1;
				} else {
					if(i == nums2.length -1) result[k] = -1;
				}
			}

		}

		return result;
	}
}
