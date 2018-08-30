package com.zoran.leetcode.medium;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/submissions/detail/6261614/
 */ 
public class Test18 {
	
	public static void main(String[] args) {
		Test18 test18 = new Test18();
		int[] nums = {5,7,7,8,8,10};
		int[] source = test18.searchRange(nums, 8);
		for(int item: source) {
			System.out.println(item);
		}
	}

    public int[] searchRange(int[] nums, int target) {
        //二分查找, 分而治之法
        if (nums == null || nums.length ==0) {
            int[] result = {-1,-1};
            return result;
        }
        
        int[] arr = {Integer.MAX_VALUE,-1};
        binarySearch(arr, nums, 0, nums.length-1, target);
        
        if(arr[0] == Integer.MAX_VALUE) arr[0] =-1;
        return arr;
    }
    
    public void binarySearch(int[] arr,int[] nums, int start, int end, int target) {
        int left = start; int right =end;
        while(left<=right) {
            int mid = (left + right)/2;
            if(nums[mid] == target) {
                arr[0] = Math.min(arr[0], mid);
                arr[1] = Math.max(arr[1], mid);
                binarySearch(arr, nums, left, mid-1, target);
                binarySearch(arr, nums, mid+1, right, target);
                break; //Core. 本次索引值找到完成之后, 要退出
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
    }
}
