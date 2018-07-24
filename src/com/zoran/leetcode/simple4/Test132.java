package com.zoran.leetcode.simple4;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 最长和谐子序列
 * https://leetcode-cn.com/submissions/detail/4572699/
 * 
 * 1.充分利用TreeMap
 */
public class Test132 {

	public static void main(String[] args) {
		int[] nums = {1,2,2,3,4,5,1,1,1,1};
		Test132 test132 = new Test132();
		System.out.println(test132.findHSUpdate1(nums));
	}

	/**
	 * 未通过
	 * if-else太多,考虑case太多
	 */
	public int findLHS(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);

		int maxCount = 0;
		int currentNum = Integer.MAX_VALUE;int lastNum = Integer.MAX_VALUE;
		int currentCount = 0;
		for(int j = 0; j < nums.length; j++) {
			if(lastNum == nums[j]) continue;
			currentNum = nums[j];
			for(int i = j; i < nums.length; i++) {
				if(currentNum + 1 >= nums[i]) {
					currentCount++;
				} else {
					if(nums[i] > currentNum+1 && currentCount==1) {

					} else {
						if(currentCount > maxCount && nums[i] != currentNum && nums[i]-currentNum  <= 1) maxCount = currentCount;
					}
					currentCount = 0;
					lastNum = currentNum;
					break;
				}

				if(i == nums.length -1 && nums[i] - currentNum  > 0) {
					if(currentCount > maxCount) maxCount = currentCount;
					currentCount = 0;
					lastNum = currentNum;
				}
			}
		}

		return maxCount;
	}

	/**
	 * 思路:
	 * 1.TreeMap 实现对数值进行整理
	 * 2.遍历Map, 判定<=1的情况下有最大值
	 */
	public int findHSUpdate1(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		Arrays.sort(nums);
		int maxCount = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		for(Integer item: nums) {
			if(map.get(item) == null) {
				map.put(item, 1);
			}else {
				map.put(item, map.get(item)+1);
			}
		}

		int lastNum = Integer.MAX_VALUE; int lastCount = 0; //Core.对map进行遍历时,用外部变量进行保存上一个变量键值对
		for (Map.Entry<Integer, Integer> item : map.entrySet()) {
			if(lastNum != Integer.MAX_VALUE && item.getKey() - lastNum <= 1 && maxCount < item.getValue() + lastCount) {
				maxCount = item.getValue() + lastCount;
			}
			lastNum = item.getKey();
			lastCount = item.getValue();
		}

		return maxCount;
	}
}
