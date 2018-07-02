package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * 第三大的数
 * https://leetcode-cn.com/submissions/detail/3668882/
 */
public class Test87 {
	public static void main(String[] args) {
		int[] nums = {1,2,2,5,3,5};
		System.out.println(thirdMax(nums));
	}

	/**
	 * [1,2,-2147483648]
	 */
	public static int thirdMax(int[] nums) {
		if(nums == null || nums.length == 0) return 0;

		int[] record = new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};

		List<Integer> list = new ArrayList<>();  //Core. 记录不重复元素的个数, 

		for(int i: nums) {
			if(list.contains(i)) {  //耗时操作contains()
				continue;
			} else {
				list.add(i);
			}

			if(i >= record[0]) {
				if(i == record[0]) continue;
				int tmp = record[0];int tmp2 = record[1];
				record[0] = i;
				record[1] = tmp;
				record[2] = tmp2;
			} else if (i >= record[1]) {
				if(i == record[1]) continue;
				int tmp2 = record[1];
				record[1] = i;
				record[2] = tmp2;
			} else if (i >= record[2]) {
				record[2] = i;
			}
		}


		return list.size() >= 3 ?  record[2] :record[0];
	}

	public int Nice_thirdMax(int[] nums) {
		int first = nums[0];
		int second = nums[0];
		int third = nums[0];
		int len = nums.length;
		for (int i = 1; i < len; i++) {
			if (first < nums[i]) {
				third = second;
				second = first;
				first = nums[i]; 
			} else if (first > nums[i] && (nums[i] > second || second == first)) {
				third = second;
				second = nums[i];
			} else if (second > nums[i] && (nums[i] > third || third == second || third == first)) {
				third = nums[i];
			}
		}
		if (first > second && second > third) {
			return third;
		}
		return first;
	}
}
}
