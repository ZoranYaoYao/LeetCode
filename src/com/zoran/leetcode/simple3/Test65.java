package com.zoran.leetcode.simple3;

/**
 * �ƶ���
 * https://leetcode-cn.com/submissions/detail/3477834/
 */
public class Test65 {
	
	/**
	 * ʱ�临�Ӷ� O{(n2 -n)/2} 
	 */
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) continue;
            
            for(int j=i; j < nums.length;j++) {
                if(nums[i] == 0 && nums[j] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    break;
                }
            }
        }
    }

	/**
	 *  ��¼0Ԫ�ص���ʼλ��, ���Բ���0��Ԫ�ؽ����û�.
	 *  ʱ�临�Ӷ� O(n)
	 */
	public void Nice_movezeroes(int[] nums) {
		int index = 0; //Core : ��һ���α� ��¼0����ʼλ��!
		for(int i = index; i < nums.length; i++) {
			if(nums[i] != 0) {
				int temp = nums[i];
				nums[i] = nums[index];  
				nums[index] = temp;
				index++;
			}
		}
	}
}
