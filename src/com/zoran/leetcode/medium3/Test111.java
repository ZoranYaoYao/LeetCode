package com.zoran.leetcode.medium3;

import java.util.Arrays;

/**
 * ֻ����һ�ε����� III
 * https://leetcode-cn.com/submissions/detail/8610797/
 */
public class Test111 {

    public int[] singleNumber(int[] nums) {
        //��������, ��ǰ����ͺ�һ�������Ƿ����, ���� ��ǰ�����ǰһ�������Ƿ����
        if (nums == null || nums.length == 0) return null;
        
        Arrays.sort(nums);
        int index =0;
        int[] res = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            if (index == 2) break;
            if(i==0 && nums[i] != nums[i+1]) {
                res[index++] = nums[i];
                continue;
            }    
            
            if (i+1<nums.length && nums[i] != nums[i+1] && nums[i-1] != nums[i]
               || (i == nums.length-1 && index == 1)) {
                res[index++] = nums[i];
            } 

        }
        return res;
    }
}
