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
	 * 43 / 44 ��ͨ����������
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
	 * ��ʱ!
	 */
    public int majorityElement(int[] nums) {
        //˫��ͬʱ����
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
            
            left = 0; //����
            right = nums.length-1;
        }

        return -1;
    }

    /**
     * ����hashMap ���д洢 + ��̬�ж� n/2
     * ʱ�临�Ӷ�: O(n) 
     * �ռ临�Ӷ�: O(HashMap)
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
     * Ħ��ͶƱ�㷨
     * ʱ�临�Ӷ�: O(n)
     * �ռ临�Ӷ�: O(1) 
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
