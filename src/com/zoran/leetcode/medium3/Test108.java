package com.zoran.leetcode.medium3;

/**
 * 除自身以外数组的乘积
 * https://leetcode-cn.com/submissions/detail/8571264/
 * 
 * [Solution]
 * https://www.cnblogs.com/mr-stn/p/8951354.html
 * 
 * [Nice_Solution]
 * https://blog.csdn.net/nomasp/article/details/50810589
 * 对0的个数分情况处理: (1)没有0 (2)一个0 (3)多个0
 */
public class Test108 {

	/**
	 * 超时 
	 */
    public int[] productExceptSelf(int[] nums) {
        // 总数 / 当前数  错误: 有0的情况
        if (nums == null || nums.length == 0) return null;
        
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j =0; j< nums.length; j++) {
                if (i == j) continue;
                count *= nums[j];
            }
            res[i] = count;
        }
        
        return res;
    }
}

class Nice_Test108 {
	
	public int[] prodectExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] res = new int[nums.length];
		left[0] = nums[0]; right[nums.length-1] = nums[nums.length-1];
		for (int i=1; i<nums.length; i++) {
			left[i] = left[i-1] * nums[i];
			right[nums.length-1-i] = right[nums.length-1-i+1]*nums[nums.length-1-i];
		}
		
		for(int i=0; i<res.length; i++) {
			if(i==0) {
				res[i] = right[i+1];
			} else if (i == nums.length-1) {
				res[i] = left[i-1];
			} else {
				res[i] = left[i-1]*right[i+1];
			}
		}
		
		return res;
	}
}
