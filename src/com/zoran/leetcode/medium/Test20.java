package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和
 * https://leetcode-cn.com/submissions/detail/6274185/
 * 
 * [Solution]
 * https://www.cnblogs.com/zpfbuaa/p/6537720.html
 */
public class Test20 {

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}
	
	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums
			, int remain, int start) {
		if(remain < 0) return;
		else if(remain == 0) list.add(new ArrayList<>(tempList));// Core. 通过new ArrayList()最后生成一个结果值
		else {
			for (int i=start; i<nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain-nums[i], i); // not i+1 because we can resuse same elements
				tempList.remove(tempList.size()-1); // Nice_Core. 回溯法,对已添加的元素进行删除之后,组合后续选择.
			}
		}
	}
}
