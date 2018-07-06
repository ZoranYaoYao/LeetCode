package com.zoran.leetcode.simple3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * �ҵ�������������ʧ������
 * https://leetcode-cn.com/submissions/detail/3853086/
 */
public class Test95 {
	public static void main(String[] args) {
		int[] nums = {1,1};
		 List<Integer> list = findDisappearedNumbers(nums);
		 for (Integer integer : list) {
			System.out.println(integer + " ");
		}
	}
	
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        
        int index = 1; //Core. ��¼�Ա�����λ��
        for(int i =0; i < nums.length; i++) {
        	while (index <= nums[i]) {
                if(index < nums[i]) {
            		list.add(index);
                }
                index++;
        	}
        }
        
        for(;index <= nums.length;index++) {  //Core. ��������Ԫ��
        	list.add(index);
        }
        
        return list;
    }
}
