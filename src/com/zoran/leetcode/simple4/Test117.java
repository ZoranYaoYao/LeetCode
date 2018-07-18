package com.zoran.leetcode.simple4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中的K-diff数对
 * https://leetcode-cn.com/submissions/detail/4313208/
 */
public class Test117 {

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);

		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			for(int j =i+1; j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) <= k) {
					if(Math.abs(nums[i] - nums[j]) == k) {
						map.put(nums[i], nums[j]); break;
					}
				} else {
					break;
				}
			}
		}

		return map.size();
	}
}
