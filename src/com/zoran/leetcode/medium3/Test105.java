package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 求众数 II
 * https://leetcode-cn.com/submissions/detail/8569031/
 */
public class Test105 {
	
	public static void main(String[] args) {
		Test105 test105 = new Test105();
		int[] nums = {1,1,1,3,3,2,2,2};
		List<Integer> res = test105.majorityElement(nums);
		System.out.println(res);
	}

    public List<Integer> majorityElement(int[] nums) {
        //计算条件, 进行对比
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        int condition = nums.length / 3;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int item: nums) {
            int times = map.get(item) == null ? 1 : map.get(item)+1;
            if(times > condition) {
                set.add(item);
            } else {
                map.put(item,times);
            }
        }
        
        return new ArrayList<>(set);
    }
}
