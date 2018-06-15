package com.zoran.leetcode.simple2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * �����ظ�Ԫ��
 * https://leetcode-cn.com/submissions/detail/3215772/
 */
public class Test50 {

	/**
	 * �����ظ�, ��Map��ֵ�Է��ز�Ϊnull 
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
        for(int i=0;i<nums.length-1;i++){  //nums.legnth -1 , ֻ�жϵ�ĩβ��ǰһ�� �������
            if(nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
