package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 两个数组的交集 II
 * https://leetcode-cn.com/submissions/detail/3548594/
 * 
 * [Solution]
 * https://blog.csdn.net/u014248127/article/details/53574211
 */
public class Test74 {

	/**
	 * 交集元素可以重复
	 */
    public int[] Nice_intersection(int[] nums1, int[] nums2) {
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	List<Integer> result = new ArrayList<>();
    	for(int i = 0, j = 0; i < nums1.length && j < nums2.length;) {
    		if(nums1[i] == nums2[j]) {
    			result.add(nums1[i]);
    			i++;
    			j++;
    		} else if (nums1[i] < nums2[j]) {
    			i++;
    		} else {
    			j++;
    		}
    	}
    	
    	int[] res = new int[result.size()];
    	for (int i = 0; i < result.size(); i++) {
    		res[i] = result.get(i);
    	}
    	return res;
    }
}
