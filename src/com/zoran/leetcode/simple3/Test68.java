package com.zoran.leetcode.simple3;

/**
 * ����ͼ��� - ���鲻�ɱ�
 * https://leetcode-cn.com/submissions/detail/3513323/
 */
public class Test68 {

	class NumArray {
		int[] nums;

		public NumArray(int[] nums) {
			this.nums = nums;
		}

		public int sumRange(int i, int j) {
			int count = 0;
			for(int k = i;k <= j; k++) {
				count += nums[k];
			}

			return count;
		}
	}
	
	/**
	 * �ȴ洢,�ڼ��� 
	 */
	class Nice_NumArray {

	    private int[]sum;//sum��i���洢ǰi��Ԫ�صĺ� sum[0]=0,sum[i]�洢nums[0...i-1]�ĺ�
	    public Nice_NumArray(int[]nums){
	        sum=new int[nums.length+1];
	        sum[0]=0;
	        for(int i=1;i<sum.length;i++){
	            sum[i]=sum[i-1]+nums[i-1];
	        }

	    }
	    public int sumRange(int i,int j){
	        return sum[j+1]-sum[i];
	    }
	}

}
