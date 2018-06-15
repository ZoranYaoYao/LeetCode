package com.zoran.leetcode.simple2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素
 * https://leetcode-cn.com/submissions/detail/3215772/
 */
public class Test50 {

	/**
	 * 存在重复, 则Map键值对返回不为null 
	 */
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i],true);
            }else {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean Nice_containDuplicate(int[] nums) {
    	Arrays.sort(nums);
    	for(int i =0; i < nums.length; i++) {
    		if(i == nums.length -1) {
    			return nums[i] == nums[i-1];
    		}
    		
    		if(nums[i] == nums[i+1]) return true;
    	}
    	
    	return false;
    }
    
    public boolean NNice_containDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){  //nums.legnth -1 , 只判断到末尾的前一个 就完成了
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
