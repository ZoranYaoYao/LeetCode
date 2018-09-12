package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *  ���
 * https://leetcode-cn.com/submissions/detail/6946161/
 * 
 * OT 
 */
public class Tset41 {
    public List<List<Integer>> combine(int n, int k) {
        //�����㷨 ��length=k��list
        List<List<Integer>> result = new ArrayList<>();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) nums[i] = i+1;
        
        backTrace(result, nums, new ArrayList<Integer>(), 0, k);
        
        return result;
    }
    
    public void backTrace(List<List<Integer>> result, int[] nums, List<Integer> list, int startIndex, int length) {
        if (list.size() == length) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for(int i=startIndex; i<nums.length; i++) {
                list.add(nums[i]);
                backTrace(result, nums, list, i+1, length); //Core. ��ʼλ���ǵ�ǰλ�õ���һ��Ԫ��
                list.remove((Integer) nums[i]);
            }
        }
    }
}
