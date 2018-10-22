package com.zoran.leetcode.medium3;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 * https://leetcode-cn.com/submissions/detail/8531148/
 */
public class Test104 {
	
	public static void main(String[] args) {
		Test104 test104 = new Test104();
		int[] nums = {-2147483648,-2147483647,2147483647};
		List<String> reStrings = test104.summaryRanges(nums);
		System.out.println(reStrings);
		
	}
    public List<String> summaryRanges(int[] nums) {
        //纪录上一个元素值, 差值大于2输出
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        
        if(nums.length == 1) {
          res.add("" + nums[0]); 
            return res;
        }
        
        int leftIndex = 0;
        for(int i=0; i<nums.length; i++) {
            if ((i+1<nums.length && Long.valueOf(nums[i+1]+"")-Long.valueOf(nums[i]+"")>1) || (i == nums.length-1)) { // 2147483647 - (-2147483647) 整形溢出
                if (leftIndex == i) {
                    res.add("" + nums[i]);
                } else {
                    String str = nums[leftIndex] + "->" + nums[i];
                    res.add(str);
                }
                leftIndex = i+1;
            }
        }
        
        return res;
    }
}
