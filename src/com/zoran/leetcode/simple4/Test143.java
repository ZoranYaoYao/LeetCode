package com.zoran.leetcode.simple4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * ����ļ��� 
 * https://leetcode-cn.com/submissions/detail/4877575/
 * 
 * [Solution]
 * https://www.cnblogs.com/jimmycheng/p/7843515.html
 */
public class Test143 {

	public static void main(String[] args) {
		Test143 test143 = new Test143();
		int[] nums = {2,2};
		int[] arr = test143.findErrorNums(nums);
		for(int item: arr) {
			System.out.println(item);
		}
	}

	/**
	 * (1)String :�ַ���1  ��Ӧ19 Ҳ��1,�������ݽṹ����
	 * 
	 * (2) ����ʱ������: List ��ʱ
	 */
	public int[] findErrorNums(int[] nums) {
		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<nums.length; i++) {
			list.add((Integer)nums[i]);
		}

		int[] result = new int[2];
		for(int i=1; i<=nums.length; i++) {
			if(list.indexOf(Integer.valueOf(i)) == -1) {
				result[1] = i;
				continue;
			}
			
			if(list.indexOf((Integer)i) != list.lastIndexOf((Integer)(i))) {
				result[0] = i;
			}
		}

		return result;
	}

	/**
	 * ���� HashSet + ��ʽ 
	 */
	public int[] Nice_findErrorNums(int[] nums) {
		HashSet<Integer> set = new HashSet<>();
		int[] res = new int[2];
		int corSum = (1 + nums.length) * nums.length /2;
		int sum =0;
		
		for(int num:nums) {
			if(set.contains(num)) {
				res[0] = num;
			} else {
				set.add(num);
				sum += num;
			}
		}
		res[1] = corSum - sum;
		
		return res;
	}

	/**
	 * ţ�� 
	 */
	public int[] NNice_findErrorNums(int[] nums) {
		int[] result = new int[2];
		boolean[] array = new boolean[nums.length+1]; //Core. +1��Ӧ��ֵ!
		for(int num: nums) {
			if(array[num]) result[0] = num;
			array[num] = true;
		}
		
		for(int i=1; i<array.length; i++) {
			if(!array[i]) result[1] =i;
		}
		return result;
	}
}
