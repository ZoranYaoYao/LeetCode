package com.zoran.leetcode;

/**
 *  删除排序数组中的重复项
 *  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 *  https://www.jianshu.com/p/31ff94309094
 * @author Zoran
 */
public class Test06 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,2,2,3};
		System.out.println(removeDuplicates(nums));
	}

	public static int removeDuplicates(int[] nums) {
		if(nums == null || nums.length ==0) {
			return 0;
		} else if(nums.length == 1) {
			return 1;
		}

		int index = 0;
		for(int i = 1; i < nums.length; i++) {
			//对比前后2个数字
			if(nums[i-1] != nums[i]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}
	

	//    public static int removeDuplicates(int[] nums) {
	//    	if(nums == null || nums.length ==0) {
	//    		return 0;
	//    	} else if(nums.length == 1) {
	//    		return 1;
	//    	}
	//    	
	//    	int currentIndex = 0;
	//    	int currentNumber = nums[currentIndex]; int dutimes = 0 ;
	//    	
	//    	for(int i = 1; i< nums.length; i++) {
	//    		if (currentNumber == nums[i]) {
	//				if(dutimes == 0) {
	//					currentIndex++;
	//				}
	//				dutimes++;
	//			} else {
	//				if(dutimes == 0) {
	//					currentIndex ++;
	//				}
	//				nums[currentIndex] = nums[i];
	//				currentNumber = nums[currentIndex];
	//				dutimes = 0;
	//			}
	//    	}
	//    	
	//    	//处理重复1,1   1,2
	//    	if(nums[currentIndex] == nums[nums.length -1] && currentIndex == nums.length -1) {
	//    		currentIndex--;
	//    	}
	//    	
	//        return currentIndex + 1;
	//    }



}
