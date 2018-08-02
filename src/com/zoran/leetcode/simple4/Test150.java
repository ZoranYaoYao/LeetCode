package com.zoran.leetcode.simple4;

/**
 * �������������
 * https://leetcode-cn.com/submissions/detail/4980303/
 */
public class Test150 {

	/**
	 * 1.��������, �жϺ�һ�������Ƿ����ǰһ��,������������+1, 
	 * 							���С���������ֵ�жϽ��н���,�����ü�����
	 */
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int max = 1;int count =1;
        for (int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                count++;
            } else {
                if(count > max) max = count;
                count =1;
            }
            
            if (i == nums.length -1 && count > max) max = count; //Core. ĩβ���һ�����ж�
        }
        
        return max;
    }
}
