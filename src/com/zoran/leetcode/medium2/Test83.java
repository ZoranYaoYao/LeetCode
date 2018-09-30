package com.zoran.leetcode.medium2;

/**
 * 乘积最大子序列
 * https://leetcode-cn.com/submissions/detail/7747901/
 * 
 * 整数数组: 先分割0, 在分割负数的位置, 分治
 * 可以用动态规划: dp[i] = dp[i-1] * nums[i] (nums[i] > 0);
 */
public class Test83 {
	
	public static void main(String[] args) {
		Test83 test83 = new Test83();
		int[] nums = {1,0,-1,2,3,-5,-2};
		int res = test83.maxProduct(nums);
		System.out.println(res);
	}

    int max = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        //整数数组: 先分割0, 在分割负数的位置, 分治
        
        if(nums == null || nums.length == 0) return 0;
        int preZeroLoc = -1;
        for(int i=0; i<nums.length; i++) {
        	max = Math.max(max, nums[i]); //单个元素
            if (nums[i] == 0 )  { 
              divide(nums, preZeroLoc, i);
              preZeroLoc = i;
            }
            
            if(preZeroLoc!=-1 && i==nums.length-1) { //处理句尾
                divide(nums, preZeroLoc, i+1);
            }
        }
        
        if(preZeroLoc == -1) divide(nums, -1, nums.length);

        return max;
    }
    
    public void divide(int[] nums, int start, int end) { //不包含start, end
    	if (end - start <= 2) return; //剔除值包含一个元素.
        int all = 1;
        int negativeCount = 0;
        for (int i=start+1; i<end; i++) {
            if(nums[i] < 0) negativeCount++;
            all *= nums[i];
        }    
        if(negativeCount%2 == 0) {
            max = Math.max(max, all);
        } else { //奇数个,2种情况
            int containHead = all;
            for (int i=end-1; i>start; i--) {
                containHead /= nums[i];
                if(nums[i] <0)  {
                    max = Math.max(max, containHead);
                    break;
                }
            }
            int containTail = all;
            for (int i=start+1; i<end; i++) {
            	containTail /= nums[i];
                if (nums[i] <0) {
                    max = Math.max(max, containTail);
                }
            }
        }
    }
}
