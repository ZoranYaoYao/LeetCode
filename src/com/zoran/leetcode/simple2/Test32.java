package com.zoran.leetcode.simple2;

import java.util.ArrayList;
import java.util.List;

/**
 * ֻ����һ�ε�����
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
        for(int i =1; i < nums.length; i++) {  //ʱ�临�Ӷ� O(n)
            if(list.contains(nums[i])) {
                list.remove(((Object)nums[i]));   //�ռ临�Ӷ�O(2n)
            } else {
                list.add(nums[i]);  
            }
        }
        
        return list.get(0);
    }

    /**
     * �����(^)
     * 1. ��������, �Լ����Լ�������� ���һ������ 0
     * 2. 0 ���κ��������, �����ڸ�����
     */
    public int Nice_singleNumber(int[] nums) {
    	int number = 0;
    	for(int i = 0; i < nums.length; i++) {
    		number ^= nums[i]; //core �ռ临�Ӷ� O(n)
    	}
    	
    	return number;
    }
}
