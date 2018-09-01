package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列
 * https://leetcode-cn.com/submissions/detail/6363374/
 * 
 * 回溯法 -> 递归函数 包含for循环 
 */
public class Test23 {

    public List<List<Integer>> permute(int[] nums) {
        //回溯法, 选择每种可能
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length==0) return result;
        Arrays.sort(nums);
        
        backTace(nums, result, new ArrayList<Integer>());
        return result;
    }
    
    public void backTace(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if(temp.size() == nums.length) {
            result.add(new ArrayList<Integer>(temp));
        } else {
            for(int i=0; i<nums.length; i++) {		 //Core. 每次都是从索引0开始添加值, 进行全部遍历
                if(temp.contains(nums[i])) continue; 
                temp.add(nums[i]);
                backTace(nums, result, temp);  
                temp.remove(temp.size()-1); //回溯点, 每个点,可以是for循环里面的其他点!!
            }
        }
    }
}
