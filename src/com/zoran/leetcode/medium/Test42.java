package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * https://leetcode-cn.com/submissions/detail/6947393/
 * 
 * OT
 */
public class Test42 {

    public List<List<Integer>> subsets(int[] nums) {
        //回溯算法, 对列表长度相等集合进行区分
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        
        for(int length=0; length<=nums.length; length++) {
             backTrace(result, nums, new ArrayList<Integer>(), 0, length);
        }

        return result;
    }
    
    public void backTrace(List<List<Integer>> result, int[] nums, List<Integer> list, int startIndext, int length) {
        if (list.size() == length) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for(int i=startIndext; i<nums.length; i++) {
                if(list.contains((Integer) nums[i])) continue; //Core. 去除列表中已有的选项
                list.add(nums[i]);
                backTrace(result, nums, list, i, length);
                list.remove((Integer) nums[i]);
            }
        }
    }
}
