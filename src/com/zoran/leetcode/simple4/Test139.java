package com.zoran.leetcode.simple4;

import java.util.Arrays;

/**
 * �����������˻�
 * https://leetcode-cn.com/submissions/detail/4711681/
 */
public class Test139 {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		Test139 test139 = new Test139();
		System.out.println(test139.maximumProduct(nums));
		
	}

	/**
	 * ���ֵ: ֻ�������2�������
	 */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if(nums == null || nums.length == 0) return 0;
        int result = 1;
        
        for(int i = 0; i < 3; i++) {
            result *= nums[nums.length-1 -i];
        }
        
        int tmp = 1;
        for(int i=0; i<3;i++) {
            if(i == 2) {
            	tmp *= nums[nums.length -1];
            }else {
                tmp *= nums[i];
            }
        }
        
        return result > tmp ? result : tmp;
    }
}
