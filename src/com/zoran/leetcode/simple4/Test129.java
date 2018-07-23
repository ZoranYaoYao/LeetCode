package com.zoran.leetcode.simple4;

import java.util.Arrays;
import java.util.LinkedList;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * 最短无序连续子数组
 * https://leetcode-cn.com/submissions/detail/4524285/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80204790
 * https://www.cnblogs.com/jimmycheng/p/7673733.html
 * 
 * 判定准最终答案通用的效果
 */
public class Test129 {
	
	public static void main(String[] args) {
		int[] nums = {2,3,3,2,4};
		Test129 test129 = new Test129();
		System.out.println(test129.findUnsortedSubarray(nums));
	}

	/**
	 *  2,3,3,2,4 不能满足
	 *  单循环不可行
	 */
    public int findUnsortedSubarray(int[] nums) {
    	if(nums == null || nums.length == 0 ) return 0;
        int startIndex = -1; int endIndex = -1;
        int swapNum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < swapNum) {
                if(startIndex == -1) {
                    startIndex = i - 1;
                }
                endIndex = i;
            } else {
                swapNum = nums[i];
            }
        }
        
        int result =  startIndex == endIndex ? 0 : endIndex - startIndex + 1;
        return result;
    }
    
    public int Nice_findUnsortedSubarray(int[] nums) {
    	int[] sortedArr = Arrays.copyOf(nums, nums.length); // Core.
    	Arrays.sort(sortedArr);
    	int i =0; int j = nums.length -1;
    	while (nums[i] == sortedArr[i] && i<j) i++;
    	while (nums[j] == sortedArr[j] && i<j) j--;
    	
    	int result = i ==j ? 0: j -i +1;
    	return result;
    }
    
    public int NNice_findUnsortedSubarray(int[] nums) {
    	int n = nums.length;
    	int beg = -1;
    	int end = -2;
    	int min = nums[n -1];
    	int max = nums[0];
    	
    	for (int i = 0; i < n; i++) {
    		max = Math.max(max, nums[i]);
    		min = Math.min(min, nums[n-1-i]);
    		
    		if(nums[i] < max) { //遍历值 与当前[0-i]最大值进行比较, 如果小于,所以末尾排序点在 i位置
    			end = i;
    		} 
    		
    		if(nums[n -1 -i] > min) { //末尾遍历值 与当前[n-1-i, i]最小值进行比较,如果大于最小值,那么最小值的位置在遍历位置
    			beg = n-1-i;
    		}
    	}
    	
    	return end - beg + 1;
    }
    
    
}
