package com.zoran.leetcode.simple3;

/**
 * 区域和检索 - 数组不可变
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
	 * 先存储,在计算 
	 */
	class Nice_NumArray {

	    private int[]sum;//sum【i】存储前i个元素的和 sum[0]=0,sum[i]存储nums[0...i-1]的和
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
