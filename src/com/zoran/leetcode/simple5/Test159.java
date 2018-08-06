package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 数组的度
 * https://leetcode-cn.com/submissions/detail/5198506/
 */
public class Test159 {
	public static void main(String[] args) {
		Test159 test159 = new Test159();
		int[] nums = {1,1,2,2,2,1}; //多个相同度
		System.out.println(test159.findShortestSubArray(nums));
	}

	/**
	 * 找到数组中的最大值相关数可能是一个,可能是多个!
	 */
	public int findShortestSubArray(int[] nums) {
		int[] arr = Arrays.copyOf(nums,nums.length);
		Arrays.sort(arr);
		Map<Integer,Integer> map = new HashMap<>();
		int mostNum = 1; 
		int tmp =1; int value = arr[0]; int count = 1;
		for(int i =1; i<arr.length; i++) {
			if(value == arr[i]) {
				tmp++;
			} else {
				if(tmp > count) {
					mostNum = arr[i-1];
					count = tmp;
				}
				map.put(arr[i-1], tmp);
				value = arr[i]; //reset
				tmp = 1;
			}

			//差一问题
			if(i == arr.length -1 && tmp != 1 && tmp >= count) {
				mostNum = arr[i-1];
				count = tmp;
				map.put(arr[i-1], tmp);
			}
		}

		if(arr.length == 1) map.put(value,count);

		//找第二遍
		List<Integer> list = new ArrayList<>();
		for (Entry<Integer, Integer> item : map.entrySet()) {
			if(item.getValue() == count) {
				list.add(item.getKey());
			}
		}

		int result = Integer.MAX_VALUE;
		for(Integer item: list) {
			int startIndex =-1; int endIndex =-1;
			for(int left =0, right = nums.length-1; left < nums.length;){
				if(startIndex != -1 && endIndex != -1) break;

				if(nums[left] == item && startIndex == -1) {
					startIndex = left;
				}

				if(nums[right] == item && endIndex == -1) {
					endIndex = right;
				} 

				left++;
				right--;
			}
			result = Math.min(result, endIndex - startIndex +1);

		}

		return result;
	}
}
