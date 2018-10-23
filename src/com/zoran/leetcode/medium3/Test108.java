package com.zoran.leetcode.medium3;

/**
 * ��������������ĳ˻�
 * https://leetcode-cn.com/submissions/detail/8571264/
 * 
 * [Solution]
 * https://www.cnblogs.com/mr-stn/p/8951354.html
 * 
 * [Nice_Solution]
 * https://blog.csdn.net/nomasp/article/details/50810589
 * ��0�ĸ������������: (1)û��0 (2)һ��0 (3)���0
 */
public class Test108 {

	/**
	 * ��ʱ 
	 */
    public int[] productExceptSelf(int[] nums) {
        // ���� / ��ǰ��  ����: ��0�����
        if (nums == null || nums.length == 0) return null;
        
        int[] res = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            for (int j =0; j< nums.length; j++) {
                if (i == j) continue;
                count *= nums[j];
            }
            res[i] = count;
        }
        
        return res;
    }
}

class Nice_Test108 {
	
	public int[] prodectExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] right = new int[nums.length];
		int[] res = new int[nums.length];
		left[0] = nums[0]; right[nums.length-1] = nums[nums.length-1];
		for (int i=1; i<nums.length; i++) {
			left[i] = left[i-1] * nums[i];
			right[nums.length-1-i] = right[nums.length-1-i+1]*nums[nums.length-1-i];
		}
		
		for(int i=0; i<res.length; i++) {
			if(i==0) {
				res[i] = right[i+1];
			} else if (i == nums.length-1) {
				res[i] = left[i-1];
			} else {
				res[i] = left[i-1]*right[i+1];
			}
		}
		
		return res;
	}
}
