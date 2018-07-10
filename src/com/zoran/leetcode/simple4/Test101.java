package com.zoran.leetcode.simple4;

/**
 * ������ܳ�
 * https://leetcode-cn.com/submissions/detail/3995547/
 */
public class Test101 {
	
	public static void main(String[] args) {
		int[][] nums = {{0,1,0,0},
		                 {1,1,1,0},
		                 {0,1,0,0},
		                 {1,1,0,0}};
		System.out.println(islandPerimeter(nums));
	}
	
	/**
	 * OT
	 * ���㷨, ��½���ӵ��ܳ����ظ������� 
	 */
    public static int islandPerimeter(int[][] grid) {
        int landCount = 0; int repeat = 0;
        for (int i = 0; i< grid.length; i++) {
            for(int j =0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    landCount++;
                    if (i-1 >= 0 && grid[i -1][j] == 1) repeat++;  
                    if (i+1 < grid.length && grid[i +1][j] ==1)  repeat++;
                    if (j-1 >= 0 && grid[i][j-1] == 1)  repeat++;
                    if (j+1 < grid[i].length && grid[i][j+1] == 1)  repeat++;
                }
            }
        }
        
        return landCount*4 - repeat;
    }
    
//    for(int i = 0; i < arr.length; i++){ //������ά���飬����������ÿһ��Ԫ����һ��һά����
//    	for(int j = 0; j < arr[i].length; j++){ //������Ӧλ���ϵ�һά����
}
