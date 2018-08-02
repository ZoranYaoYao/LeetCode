package com.zoran.leetcode.simple4;

/**
 * 最长连续递增序列
 * https://leetcode-cn.com/submissions/detail/4980303/
 */
public class Test150 {

	/**
	 * 1.遍历数组, 判断后一个数字是否大于前一个,如果大则计数器+1, 
	 * 							如果小于则与最大值判断进行交换,并重置计数器
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
            
            if (i == nums.length -1 && count > max) max = count; //Core. 末尾最后一次做判断
        }
        
        return max;
    }
}
