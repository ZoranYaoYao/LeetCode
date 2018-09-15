package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II
 * https://leetcode-cn.com/submissions/detail/7116771/
 */
public class Test49 {

	public static void main(String[] args) {
		Test49 test49 = new Test49();
		int[] nums = {1,2,2};
		test49.subsetsWithDup(nums);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		//组合: 回溯法 根据不同长度进行分组添加
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;

		Arrays.sort(nums); //Nice.Core : [4,4,4,1,4] 414, 441 重复问题
		for(int i=0; i<=nums.length; i++) {
			backTrace(res, nums, new ArrayList<Integer>(), 0, i);
		}

		return res;
	}

	public void backTrace(List<List<Integer>> res, int[] nums, List<Integer> list, int startIndex, int length) {
		if(list.size() == length && !res.contains(list)) { //Core.  !res.contains(list)
			res.add(new ArrayList<Integer>(list));
		} else {
			for(int i=startIndex; i<nums.length; i++) {
				list.add(nums[i]);
				backTrace(res, nums, list, i+1, length);
				list.remove((Integer) nums[i]);
			}
		}
	}
}

// 2个列表 子元素顺序不同的对比过程 - > 麻烦
//for (int i=0; i<res.size();i++) {
//List<Integer> item = res.get(i);
//if(item.size() == list.size()) {
//	Map<Integer, Integer> itemMap = new HashMap<>();
//	for(Integer it : item) {
//		if(itemMap.get(it) == null) itemMap.put(it, 1);
//		else itemMap.put(it, itemMap.get(it)+1);
//	}
//	
//	Map<Integer, Integer> listMap = new HashMap<>();
//	for(Integer it : list) {
//		if(listMap.get(it) == null) listMap.put(it, 1);
//		else listMap.put(it, listMap.get(it)+1);
//	}
//	
//	for()
//}
//}