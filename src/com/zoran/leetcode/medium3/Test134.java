package com.zoran.leetcode.medium3;

/**
 * 递增的三元子序列
 * https://leetcode-cn.com/submissions/detail/9069226/
 */
public class Test134 {

    public boolean increasingTriplet(int[] nums) {
        //直接遍历, 索引跳跃
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
			if (num <= first) first = num; //Core. 每次跟新first, second值, 如果first, second值满足, 那么数组里一定有满足3个的元素 
			else if (num <= second) second = num; 
			else return true;
		}
		
		return false;
	}
}