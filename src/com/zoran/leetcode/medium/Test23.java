package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ȫ����
 * https://leetcode-cn.com/submissions/detail/6363374/
 * 
 * ���ݷ� -> �ݹ麯�� ����forѭ�� 
 */
public class Test23 {

    public List<List<Integer>> permute(int[] nums) {
        //���ݷ�, ѡ��ÿ�ֿ���
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
            for(int i=0; i<nums.length; i++) {		 //Core. ÿ�ζ��Ǵ�����0��ʼ���ֵ, ����ȫ������
                if(temp.contains(nums[i])) continue; 
                temp.add(nums[i]);
                backTace(nums, result, temp);  
                temp.remove(temp.size()-1); //���ݵ�, ÿ����,������forѭ�������������!!
            }
        }
    }
}
