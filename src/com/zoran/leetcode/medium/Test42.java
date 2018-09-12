package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * �Ӽ�
 * https://leetcode-cn.com/submissions/detail/6947393/
 * 
 * OT
 */
public class Test42 {

    public List<List<Integer>> subsets(int[] nums) {
        //�����㷨, ���б�����ȼ��Ͻ�������
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
                if(list.contains((Integer) nums[i])) continue; //Core. ȥ���б������е�ѡ��
                list.add(nums[i]);
                backTrace(result, nums, list, i, length);
                list.remove((Integer) nums[i]);
            }
        }
    }
}
