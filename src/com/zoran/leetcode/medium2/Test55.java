package com.zoran.leetcode.medium2;

/**
 * ��ͬ�Ķ���������
 * https://leetcode-cn.com/submissions/detail/7239998/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_38595487/article/details/79598628
 * base:
 * https://www.cnblogs.com/ariel-dreamland/p/9159715.html 
 * 
 * ��̬�滮: �ָ��ڵ㲻ͬ����µ�������
 */
public class Test55 {

}

class Nice_Test55 {
	public int numTrees(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		int[] nums = new int[n+1];
		nums[0] = 1; nums[1] =1;
		
		for (int i=2; i<=n; i++) {
			for (int j=0; j<i; j++) {
				//Core. nums[i] ��ʾ ��Ŀi������ϳɶ��ٸ���Ŀ ����nums[3] ����1,2,3�ܳ��ֵ����
				//eg: nums[3] = nums[0]*nums[2](���ڵ�Ϊ1) + nums[1]*nums[1] (���ڵ�Ϊ2) + nums[2]*nums[0] (���ڵ�Ϊ3)
				nums[i] += nums[j]*nums[i-1-j]; 
			}
		}
		return nums[n];
	}
}