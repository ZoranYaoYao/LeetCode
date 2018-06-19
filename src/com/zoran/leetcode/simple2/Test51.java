package com.zoran.leetcode.simple2;

import java.util.HashMap;

/**
 * 存在重复元素 II
 * https://leetcode-cn.com/submissions/detail/3276809/
 */
public class Test51 {
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,1};
		System.out.println(containsNearbyDuplicate(nums, 0));
	}

	/**
	 * 理解题意: i 和 j 的差的绝对值最大为 k。 means <=k return true;
	 * 时间复杂度: O(nm)
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
     *  利用map 存储
     *  时间复杂度 : O(n)
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
