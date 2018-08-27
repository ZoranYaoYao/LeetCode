package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 四数之和
 * https://leetcode-cn.com/submissions/detail/6115853/
 */
public class Test11 {
	
	public static void main(String[] args) {
		Test11 test11 = new Test11();
		int[] nums = {0,0,0,0};
		System.out.println(test11.fourSum(nums, 0));
	}

	/**
	 * 注意去除的重复
	 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //2个双指针进行遍历
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length < 4) return list;
        
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            while(i-1>=0 && i<nums.length && nums[i] == nums[i-1]) i++;
            List<Integer> record = new ArrayList<>();
            for(int j=i+1; j<nums.length; j++) {
                if(record.contains(nums[j])) continue; //Core. 去除第二个数 重复的情况!
                record.add(nums[j]);
                int left = j+1; int right = nums.length -1;
                while(left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        List<Integer> temp = new ArrayList(Arrays.asList(nums[i],nums[j],nums[left], nums[right]));
                        list.add(temp);
                        while(left+1<nums.length-1 && nums[left] == nums[left+1]) left++; //Core.
                        left++;
                        while(right-1>j && nums[right] == nums[right-1]) right--; //Core.
                        right--;
                    } else if(sum > target) {
                        while(right-1>j && nums[right] == nums[right-1]) right--;//Core.
                        right--;
                    } else {
                        while(left+1<nums.length-1 && nums[left] == nums[left+1]) left++; //Core.
                        left++;
                    }
                }
            }
        }
        
        return list;
    }
}
