package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode-cn.com/submissions/detail/6002482/
 * 
 * [Solution]
 * https://www.jianshu.com/p/65a5c9ffff7b
 */
public class Test08 {
	public static void main(String[] args) {
		Test08 test08 = new Test08();
		int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		System.out.println(test08.threeSum(nums));
	}

	/**
	 * 超出时间限制 
	 */
    public List<List<Integer>> threeSum(int[] nums) {
        //排序, 左右遍历值
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        
        boolean flag = true;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            for(int j=nums.length-1; j>=i+2; j--) {
                for(int k=j-1; k>=i+1; k--) {
                    int sum = nums[i] + nums[j] + nums[k];
                    System.out.println("nums[i]=" + nums[i] + ",nums[j]=" +nums[j]+ ",nums[k]=" + nums[k]);
                    if(nums[i]==0 && nums[j]==0 && nums[k]==0 && flag) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                        list.add(temp);
                        flag = false;
                    }
                    
                    if(sum == 0) {
                    	boolean hased = false;
                        for(List<Integer> item: list) {
                            if(item.contains(nums[i]) && item.contains(nums[j]) && item.contains(nums[k])) { //问题点: 3个0 想当与包含0
                            	hased = true;
                            	break;
                            }
                        }
                        
                        if(hased) continue;
                        
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);temp.add(nums[j]);temp.add(nums[k]);
                        list.add(temp);
                    }
                }
            }
        }
        
        return list;
    }


    /**
     * 左右双指针处理 
     */
    public List<List<Integer>> Nce_threeSum(int[] nums) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(nums.length < 3) return res;
    	
    	Arrays.sort(nums);
    	for (int i=0; i<nums.length; i++) {
    		if (i>0 && nums[i] == nums[i-1]) continue; //Core. 处理重复开头数字
    		int left = i+1; int right = nums.length-1;
    		while (left < right) {
    			int sum = nums[i] + nums[left] + nums[right];
    			if(sum == 0) {
    				res.add(Arrays.asList(nums[i],nums[left],nums[right]));
        			while (left<right && nums[left] == nums[left+1]) left++; //Core. 去除重复项
        			while (left<right && nums[right] == nums[right-1]) right--; //Core. 去除重复项
        			left++;
        			right--; //Nice.相等的时候,2个指针都往中间缩放
    			} else if (sum <0) {
    				left++;
    			} else {
    				right--;
    			}
    		}
    	}
    	
    	return res;
    }

}
