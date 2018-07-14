package com.zoran.leetcode.simple4;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 相对名次
 * https://leetcode-cn.com/submissions/detail/4150959/
 * 
 * [Solution]
 * https://blog.csdn.net/weixin_40550726/article/details/80580967
 */
public class Test112 {
	public static void main(String[] args) {
		int[] nums = {5, 4, 3, 2, 1};
		String[] result = findRelativeRanks(nums);
		System.out.println(Arrays.toString(result));
	}
	
	/**
	 * 思路: 对以前的整形数组转换成 String[] 数组的数字进行排序
	 */
	public static String[] findRelativeRanks(int[] nums) {
		if(nums == null) return new String[0];

		String[] result = new String[nums.length];
		int maxIndex =0;
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums.length; j++) {
				if(nums[maxIndex] < nums[j]) {
					maxIndex = j;
				} 
			}
			result[maxIndex] = (i+1) + "";
			nums[maxIndex] = Integer.MIN_VALUE; //Core. 重置状态, 相当于移出该元素!
		}

		for(int i = 0; i < result.length; i++) {
			if(result[i].equals("1")) result[i] = "Gold Medal";
			if(result[i].equals("2")) result[i] = "Silver Medal";
			if(result[i].equals("3")) result[i] = "Bronze Medal";
		}

		return result;
	}

	/**
	 * Map 结构 -> 数据对应名次存储 
	 */
	public String[] Nice_findRelativeRanks(int[] nums) {
		String[] result = new String[nums.length];
		
		int[] nums2 = new int[nums.length];
		for(int i =0; i < nums.length; i++) {
			nums2[i] = nums[i];
		}
		
		Arrays.sort(nums2);
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = nums2.length -1; i >=0; i--) {
			map.put(nums2[i], map.size() + 1);
		}
		
		for(int i = 0; i < nums.length; i++) {
			int temp = map.get(nums[i]);
			
			if (temp == 1) {
				result[i] = "Gold Medal";
			} else if (temp == 2) {
				result[i] = "Silver Medal";
			} else if (temp == 3) {
				result[i] = "Bronze Medal";
			} else {
				result[i] = temp + "";
			}
		}
		
		return result;
	}
}
