package com.zoran.leetcode.simple5;

/**
 * �����������
 * https://leetcode-cn.com/submissions/detail/5165837/
 * 
 * [Solution]
 * https://blog.csdn.net/qq_16151925/article/details/80204849
 * 
 * ÿ����ĸ���,�������Աߵĵ�ֵ,�����ݹ�
 */
public class Test157 {

	public int maxAreaOfIsland(int[][] grid) {
		int max =0;
		for (int i=0; i<grid.length; i++) {
			for (int j=0; j<grid[0].length; j++) {
				int nums = deepSearch(grid, i, j);
				max = Math.max(nums, max);
			}
		}
		return max;
	}

	private int deepSearch(int[][] grid, int i, int j) {
		// TODO Auto-generated method stub
		if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1) {
			grid[i][j] =0; //Core. ���һ��,�͸���Ϊ0, ��Ȼ���ҵݹ鵼��.��ѭ��
			int num = 1 + deepSearch(grid, i-1, j)
			+ deepSearch(grid, i+1, j)+deepSearch(grid, i, j-1)+deepSearch(grid, i, j+1);
			return num;
		} else 
		return 0;
	}
}
