package com.zoran.leetcode.simple5;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 703. 数据流中的第K大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/description/
 * 
 * Linked 排序时超时
 */
public class Test161 {

	public static void main(String[] args) {
		int k = 1;
		//		int[] arr = {4,5,8,2};
		int[] arr = {};
		KthLargest kthLargest = new KthLargest(1, arr);
		print(kthLargest.add2(-3));   // returns 4
		print(kthLargest.add2(-2));   // returns 5
		print(kthLargest.add2(-4));  // returns 5
		print(kthLargest.add2(0));   // returns 8
		print(kthLargest.add2(4));   // returns 8
	}

	private static void print(int val) {
		System.out.println(val);
	}
}

class KthLargest {
	int kth = -1;
	//使用多插入结构
	LinkedList<Integer> list = new LinkedList<>();
	public KthLargest(int k, int[] nums) {
		kth = k;
		for(int i: nums) {
			list.add(i);
		}
		Collections.sort(list);
	}

	/**
	 * 超时: 
	 */
	public int add(int val) {
		//倒序
		if(list.size() == 0) {
			list.add(0,val);
		} else {
			for(int i = list.size() -1; i >= 0; i--) {
				if (list.get(i) > val) {
					list.add(i+1,val);
					break;
				}

				//边界问题
				if(i==0) list.add(0,val);
			}
		}
		return list.size() >= kth -1 ? list.get(kth-1) : -1;
	}

	public int add2(int val) {
		//倒序
		int left = 0; int right = list.size() -1;int middle = 0;
		boolean find = false;
		while (left <= right) {
			middle = left + (right -left)/2;
			if(list.get(middle) > val) {
				right = middle-1;
			} else if(list.get(middle) < val) {
				left = middle +1;
			}else {
				list.add(middle, val);
				find = true;
			}
		}
		if(!find) {
			list.add(middle,val);
		}
		return list.size() >= kth -1 ? list.get(list.size()-kth) : -1;
	}
}
