package com.zoran.leetcode.simple2;

import java.util.HashMap;

/**
 * �����ظ�Ԫ�� II
 * https://leetcode-cn.com/submissions/detail/3276809/
 */
public class Test51 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,1};
		System.out.println(containsNearbyDuplicate(nums, 0));
	}

	/**
	 * �������: i �� j �Ĳ�ľ���ֵ���Ϊ k�� means <=k return true;
	 * ʱ�临�Ӷ�: O(nm)
	 */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i +1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    if(j -i <= k) return true;
                    if(j- i > k) break;
                }
            }
        }
        
        return false;
    }
    
    /**
     *  ����map �洢
     *  ʱ�临�Ӷ� : O(n)
     */
    public boolean Nice_containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer n = map.get(nums[i]);
            if (n != null && i - n <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
