package com.zoran.leetcode.medium3;

/**
 * ��������Ԫ������
 * https://leetcode-cn.com/submissions/detail/9069226/
 */
public class Test134 {

    public boolean increasingTriplet(int[] nums) {
        //ֱ�ӱ���, ������Ծ
        if (nums == null || nums.length < 3) return false;
        
        for (int i=0; i<=nums.length-3; i++) {
            for(int j=i+1; j<=nums.length-2; j++) {
                for (int k=j+1; k<=nums.length-1; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) return true;
                }
            }
        }
        
        return false;
    }
}


class LeetCode_Test134 {
	
	public boolean increasingTriplet(int[] nums) {
		if (nums.length < 3) return false;
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for (int num : nums) {
			if (num <= first) first = num; //Core. ÿ�θ���first, secondֵ, ���first, secondֵ����, ��ô������һ��������3����Ԫ�� 
			else if (num <= second) second = num; 
			else return true;
		}
		
		return false;
	}
}