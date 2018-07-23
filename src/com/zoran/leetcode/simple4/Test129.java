package com.zoran.leetcode.simple4;

import java.util.Arrays;
import java.util.LinkedList;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 * �����������������
 * https://leetcode-cn.com/submissions/detail/4524285/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80204790
 * https://www.cnblogs.com/jimmycheng/p/7673733.html
 * 
 * �ж�׼���մ�ͨ�õ�Ч��
 */
public class Test129 {
	
	public static void main(String[] args) {
		int[] nums = {2,3,3,2,4};
		Test129 test129 = new Test129();
		System.out.println(test129.findUnsortedSubarray(nums));
	}

	/**
	 *  2,3,3,2,4 ��������
	 *  ��ѭ��������
	 */
    public int findUnsortedSubarray(int[] nums) {
    	if(nums == null || nums.length == 0 ) return 0;
        int startIndex = -1; int endIndex = -1;
        int swapNum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < swapNum) {
                if(startIndex == -1) {
                    startIndex = i - 1;
                }
                endIndex = i;
            } else {
                swapNum = nums[i];
            }
        }
        
        int result =  startIndex == endIndex ? 0 : endIndex - startIndex + 1;
        return result;
    }
    
    public int Nice_findUnsortedSubarray(int[] nums) {
    	int[] sortedArr = Arrays.copyOf(nums, nums.length); // Core.
    	Arrays.sort(sortedArr);
    	int i =0; int j = nums.length -1;
    	while (nums[i] == sortedArr[i] && i<j) i++;
    	while (nums[j] == sortedArr[j] && i<j) j--;
    	
    	int result = i ==j ? 0: j -i +1;
    	return result;
    }
    
    public int NNice_findUnsortedSubarray(int[] nums) {
    	int n = nums.length;
    	int beg = -1;
    	int end = -2;
    	int min = nums[n -1];
    	int max = nums[0];
    	
    	for (int i = 0; i < n; i++) {
    		max = Math.max(max, nums[i]);
    		min = Math.min(min, nums[n-1-i]);
    		
    		if(nums[i] < max) { //����ֵ �뵱ǰ[0-i]���ֵ���бȽ�, ���С��,����ĩβ������� iλ��
    			end = i;
    		} 
    		
    		if(nums[n -1 -i] > min) { //ĩβ����ֵ �뵱ǰ[n-1-i, i]��Сֵ���бȽ�,���������Сֵ,��ô��Сֵ��λ���ڱ���λ��
    			beg = n-1-i;
    		}
    	}
    	
    	return end - beg + 1;
    }
    
    
}
