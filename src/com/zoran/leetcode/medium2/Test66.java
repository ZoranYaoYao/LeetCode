package com.zoran.leetcode.medium2;

import java.util.List;

/**
 * ��������С·����
 * https://leetcode-cn.com/submissions/detail/7388795/
 * 
 * [Solution]
 * https://blog.csdn.net/koala_tree/article/details/78538314 
 * 
 * ��ǰλ�õ���ֵ = ������һ������λ�� + ��ǰֵ
 * dp[i] = Math.min(dp[i], dp[i+1]) + value(i);
 */
public class Test66 {

}

class Nice_Test66 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] res = new int[triangle.size()+1];
		for (int i=triangle.size()-1; i>=0; i--) {
			for(int j=0; j<triangle.get(i).size(); j++) {
				res[j] = Math.min(res[j], res[j+1]) + triangle.get(i).get(j);
			}
		}
		
		return res[0];
	}

}
