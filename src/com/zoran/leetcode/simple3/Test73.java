package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������Ľ���
 * https://leetcode-cn.com/submissions/detail/3547245/
 * 
 * int[] �� Integer[] ����ͬһ������
 * https://blog.csdn.net/huanghanqian/article/details/73920439 
 */
public class Test73 {

	/**
	 * baseһ������,  Ȼ������鿴��һ�������Ƿ��и�Ԫ�� 
	 */
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            if(!list.contains(nums1[i])) {
                for(int j =  0; j < nums2.length; j++) {
                    if(nums1[i] == nums2[j]) {
                        list.add(nums1[i]);
                        break;
                    }
                }
            }
        }
        
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}
