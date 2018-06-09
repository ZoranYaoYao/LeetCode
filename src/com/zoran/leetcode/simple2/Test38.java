package com.zoran.leetcode.simple2;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode-cn.com/problems/majority-element/description/
 * 
 * [Solution]
 * https://www.cnblogs.com/zhonghuasong/p/6536665.html 
 * https://blog.csdn.net/jmspan/article/details/51487170
 */
public class Test38 {

	
	/**
	 * 43 / 44 个通过测试用例
	 * 1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,
	 * 2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1
	 * 2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,
	 * 2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2
	 * ,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,
	 * 1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1
	 * ,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2
	 * ,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,
	 * 1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1
	 * ,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2
	 * 超时!
	 */
    public int majorityElement(int[] nums) {
        //双向同时遍历
        if (nums == null || nums.length == 0) return -1;
        
        int left = 0; int right = nums.length-1;
        for(int i = 0; i < nums.length; i++) {
            int tmp = nums[i]; int count = 0;
            while (left <= right) {
                if(tmp == nums[left]) {
                    count++;
                }
                
                if (tmp == nums[right]) {
                    count++;
                }
                
                if(count > nums.length/2) {
                    return tmp;
                }
                
                left++;
                right--;
            }
            
            left = 0; //重置
            right = nums.length-1;
        }

        return -1;
    }

    /**
     * 利用hashMap 进行存储 + 动态判断 n/2
     * 时间复杂度: O(n) 
     * 空间复杂度: O(HashMap)
     */
    public int Nice_majorityElement(int[] nums) {
    	Map<Integer, Integer> counts = new HashMap<>();
    	for (int num: nums) {
    		Integer count = counts.get(num);
    		if (count == null) count =1; else count++;
    		
    		if (count > nums.length/2) return num;
    		counts.put(num, count);
    	}
    	return nums[0];
    } 

    /**
     * 摩尔投票算法
     * 时间复杂度: O(n)
     * 空间复杂度: O(1) 
     */
    public int NiceNice_majorityElement(int[] nums) {
    	int m =0; int count = 0;
    	for (int i =0; i < nums.length; i++) {
    		if (count == 0) {
				m = nums[i];
				count++;
			} else if (nums[i] == m) {
				count++;
			} else {
				count--;
			}
    	}
    	
    	return m;
    }
}
