package com.zoran.leetcode.medium3;

/**
 * ����ͼ��� - ������޸�
 * https://leetcode-cn.com/submissions/detail/8796911/
 */
public class Test123 {

	class NumArray {
	    //��������в���
	    int[] nums;
	    public NumArray(int[] nums) {
	        this.nums = nums;
	    }
	    
	    public void update(int i, int val) {
	        nums[i] = val;
	    }
	    
	    public int sumRange(int i, int j) {
	        int sum = 0;
	        for(int k=i; k<=j; k++) {
	            sum += nums[k];
	        } 
	        return sum;
	    }
	}
}
