package com.zoran.leetcode.simple3;

/**
 * 移动零
 * https://leetcode-cn.com/submissions/detail/3477834/
 */
public class Test65 {
	
	/**
	 * 时间复杂度 O{(n2 -n)/2} 
	 */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) continue;
            
            for(int j=i; j < nums.length;j++) {
                if(nums[i] == 0 && nums[j] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
    }

	/**
	 *  记录0元素的起始位置, 并对不是0的元素进行置换.
	 *  时间复杂度 O(n)
	 */
	public void Nice_movezeroes(int[] nums) {
		int index = 0; //Core : 多一个游标 记录0的起始位置!
		for(int i = index; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[index];  
				nums[index] = temp;
				index++;
			}
		}
	}
}
