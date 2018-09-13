package com.zoran.leetcode.medium;

/**
 * 删除排序数组中的重复项 II
 * https://leetcode-cn.com/submissions/detail/7011696/
 * 
 *  纪录下一个需要改写的位置, 直到需要变化时, 才进行赋值. 不用双循环
 */
public class Test44 {

	public static void main(String[] args) {
		Test44 test44 = new Test44();
		int[] nums = {0,0,1,1,1,1,2,3,3};
		int res = test44.removeDuplicates(nums);
		System.out.println(res);
	}

	//O(n2)
	public int removeDuplicates(int[] nums) {
		// 超出的位置,将后续的数,依次往前移
		int res = 0;
		if (nums == null || nums.length == 0) return 0;

		int lastNum = Integer.MIN_VALUE; int innerCount=0; int moveCount =0;
		for(int i=0; i<nums.length-moveCount; i++) { //Core. nums.length-moveCount: 以后之后的有效次数
			if(nums[i] == lastNum) {
				innerCount++;
				if(innerCount > 2) { //移动
					for(int j=i+1; j<nums.length; j++) {
						nums[j-1] = nums[j];
					}
					i--;
					moveCount++;
				} 
			} else {
				innerCount = 1;
				lastNum = nums[i];
			}
		}
		res = nums.length - moveCount;
		return res;
	}
}

//O(n) 纪录下一个需要改写的位置
class LeetCode_Test {
	// 纪录下一个需要改写的位置, 直到需要变化时, 才进行赋值. 不用双循环
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length < 3) return nums.length;
		
		int res = 2;
		int temp1 = nums[0];
		int temp2 = nums[1];
		
		for (int i=2; i<nums.length; i++) {
			if (nums[i] ==temp1 && nums[i]==temp2) {
				continue;
			} else {
				temp1 = nums[i-1];
				temp2 = nums[i];
				nums[res++] = nums[i]; //Nice_Core. 纪录需要改变的位置
			}
		}
		
		return res;
	}

}






















