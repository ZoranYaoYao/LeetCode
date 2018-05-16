package com.zoran.leetcode;

/**
 * 搜索插入位置
 * https://leetcode-cn.com/submissions/detail/2334946/
 */
public class Test09 {

	public static void main(String[] args) {
		int[] nums = new int[]{1,3,5,6};
		int target = 5;
		System.out.println(searchInsert(nums, target));
	}
	
	/**
	 * 与SparseArray的put() 中的二分查找一样
	 * [记忆case]
	 * 	1,3,4  target : 2
	 */
    public static int searchInsert(int[] nums, int target) {
        int lo = 0; //有序的
        int hi = nums.length - 1;
        while(lo <= hi) {
        	int middle = (lo + hi) >>> 1; //高效,折半
        	if(nums[middle] < target) {
        		lo = middle + 1;
        	}else if(nums[middle] > target) {
        		hi = middle - 1;
        	}else {
        		return middle;
			}
        }
    	return lo;
    }
}
