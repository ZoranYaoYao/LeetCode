package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 前K个高频元素
 * https://leetcode-cn.com/submissions/detail/9116395/
 */
public class Test139 {

	public static void main(String[] args) {
		Test139 test139 = new Test139();
		int[] nums = {4,1,-1,2,-1,2,3};
		List<Integer> res = test139.topKFrequent(nums, 2);
		System.out.println(res);
	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		//排序
		List<Integer> res = new ArrayList<>();
		if (nums == null || nums.length == 0) return res;

		Arrays.sort(nums);
		int count = 1;
		//HashMap
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			if (i+1<nums.length && nums[i] != nums[i+1] && res.size() < k) {
				map.put(nums[i], count);
				count = 1;
			} else if (i == nums.length-1) {
				map.put(nums[i], count);
			} else {
				count++;
			}

		}

		List<Entry<Integer, Integer>> list1 = new ArrayList<>();
		for (Entry<Integer, Integer> item : map.entrySet()) {
			int key = item.getKey();
			int times = item.getValue();
			list1.add(item);
		}

		Collections.sort(list1, new Comparator<Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				int count1 = o1.getValue();
				int count2 = o2.getValue();
				return -(count1-count2);
			}
		});


		for (Entry<Integer, Integer> item2 : list1) {
			if(res.size() < k) res.add(item2.getKey());
		}

		return res;
	}
}
