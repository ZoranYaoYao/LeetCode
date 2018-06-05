package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.List;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/submissions/detail/2909553/ 
 */
public class Test32 {

	public static void main(String[] args) {
		int[] arr = new int[] {4,1,2,1,2};
		System.out.println(singleNumber(arr));
	}

    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i =1; i < nums.length; i++) {  //时间复杂度 O(n)
            if(list.contains(nums[i])) {
                list.remove(((Object)nums[i]));   //空间复杂度O(2n)
            } else {
                list.add(nums[i]);  
            }
        }
        
        return list.get(0);
    }

    /**
     * 异或处理(^)
     * 1. 二进制数, 自己对自己进行异或 结果一定等于 0
     * 2. 0 跟任何数字异或, 都等于该数字
     */
    public int Nice_singleNumber(int[] nums) {
    	int number = 0;
    	for(int i = 0; i < nums.length; i++) {
    		number ^= nums[i]; //core 空间复杂度 O(n)
    	}
    	
    	return number;
    }
}
