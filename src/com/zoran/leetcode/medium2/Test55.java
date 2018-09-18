package com.zoran.leetcode.medium2;

/**
 * 不同的二叉搜索树
 * https://leetcode-cn.com/submissions/detail/7239998/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_38595487/article/details/79598628
 * base:
 * https://www.cnblogs.com/ariel-dreamland/p/9159715.html 
 * 
 * 动态规划: 分根节点不同情况下的组合情况
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
				//Core. nums[i] 表示 数目i个能组合成多少个数目 比如nums[3] 代表1,2,3能出现的情况
				//eg: nums[3] = nums[0]*nums[2](根节点为1) + nums[1]*nums[1] (根节点为2) + nums[2]*nums[0] (根节点为3)
				nums[i] += nums[j]*nums[i-1-j]; 
			}
		}
		return nums[n];
	}
}