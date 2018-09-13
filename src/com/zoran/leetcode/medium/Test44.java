package com.zoran.leetcode.medium;

/**
 * ɾ�����������е��ظ��� II
 * https://leetcode-cn.com/submissions/detail/7011696/
 * 
 *  ��¼��һ����Ҫ��д��λ��, ֱ����Ҫ�仯ʱ, �Ž��и�ֵ. ����˫ѭ��
 */
public class Test44 {

	public static void main(String[] args) {
		Test44 test44 = new Test44();
		int[] nums = {0,0,1,1,1,1,2,3,3};
		int res = test44.removeDuplicates(nums);
		System.out.println(res);
	}

	//O(n2)
	public int removeDuplicates(int[] nums) {
		// ������λ��,����������,������ǰ��
		int res = 0;
		if (nums == null || nums.length == 0) return 0;

		int lastNum = Integer.MIN_VALUE; int innerCount=0; int moveCount =0;
		for(int i=0; i<nums.length-moveCount; i++) { //Core. nums.length-moveCount: �Ժ�֮�����Ч����
			if(nums[i] == lastNum) {
				innerCount++;
				if(innerCount > 2) { //�ƶ�
					for(int j=i+1; j<nums.length; j++) {
						nums[j-1] = nums[j];
					}
					i--;
					moveCount++;
				} 
			} else {
				innerCount = 1;
				lastNum = nums[i];
			}
		}
		res = nums.length - moveCount;
		return res;
	}
}

//O(n) ��¼��һ����Ҫ��д��λ��
class LeetCode_Test {
	// ��¼��һ����Ҫ��д��λ��, ֱ����Ҫ�仯ʱ, �Ž��и�ֵ. ����˫ѭ��
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
		if (nums.length < 3) return nums.length;
		
		int res = 2;
		int temp1 = nums[0];
		int temp2 = nums[1];
		
		for (int i=2; i<nums.length; i++) {
			if (nums[i] ==temp1 && nums[i]==temp2) {
				continue;
			} else {
				temp1 = nums[i-1];
				temp2 = nums[i];
				nums[res++] = nums[i]; //Nice_Core. ��¼��Ҫ�ı��λ��
			}
		}
		
		return res;
	}

}






















