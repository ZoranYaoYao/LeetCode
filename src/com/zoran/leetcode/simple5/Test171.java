package com.zoran.leetcode.simple5;

import java.util.Arrays;
import java.util.List;

/**
 * ͼ����Ⱦ
 * https://leetcode-cn.com/submissions/detail/5360622/
 * 
 * ����1: else if() �������Ĵ���, �߼�����
 * ����2: String length()
 * 		   ���鳤��  length;  Ҳ�Ƕ���!
 */
public class Test171 {
	
	public static void main(String[] args) {
		Test171 test171 = new Test171();
		int[][] nums = {{0,0,0},{0,1,1}};
		nums = test171.floodFill(nums, 1, 1, 1);
		if(nums[0] instanceof Object) {
			System.out.println("nums0");
		}
		for(int[] row: nums) {
			List<int[]> list = Arrays.asList(row);
		}
	}

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return null;
        if(image[sr][sc] == newColor) return image;
        
        int tmp = image[sr][sc];
        image[sr][sc] = newColor;
        floodFill(image, sr, sc, newColor, tmp);
        
        return image;
    }
    
    /**
     *  �����:  4�������� ��ѡ���, ���� else if(), ���������,��ѡ!!
     */
    public void Error_floodFill(int[][] image, int sr, int sc, int newColor, int origionColor) { 
        if(sc-1>=0  && image[sr][sc-1] == origionColor) {
            image[sr][sc-1] = newColor;
            floodFill(image, sr, sc-1, newColor, origionColor);
        } else if(sc+1<image[0].length && image[sr][sc+1] == origionColor) {
            image[sr][sc+1] = newColor;
            floodFill(image, sr, sc+1, newColor, origionColor);
        } else if(sr-1>= 0 && image[sr-1][sc] == origionColor) {
            image[sr-1][sc] = newColor;
            floodFill(image, sr-1, sc, newColor, origionColor);
        } else if(sr+1<image.length && image[sr+1][sc] == origionColor) {
            image[sr+1][sc] = newColor;  //??
            floodFill(image, sr+1, sc, newColor, origionColor);
        }
    }
    
    public void floodFill(int[][] image, int sr, int sc, int newColor, int origionColor) { 
        if(sc-1>=0  && image[sr][sc-1] == origionColor) {
            image[sr][sc-1] = newColor;
            floodFill(image, sr, sc-1, newColor, origionColor);
        } 
        if(sc+1<image[0].length && image[sr][sc+1] == origionColor) { //�еĳ����ж�, image[0].length
            image[sr][sc+1] = newColor;
            floodFill(image, sr, sc+1, newColor, origionColor);
        }
        if(sr-1>= 0 && image[sr-1][sc] == origionColor) {
            image[sr-1][sc] = newColor;
            floodFill(image, sr-1, sc, newColor, origionColor);
        }
        if(sr+1<image.length && image[sr+1][sc] == origionColor) {  //�еĳ����ж� image.length
            image[sr+1][sc] = newColor;  //??
            floodFill(image, sr+1, sc, newColor, origionColor);
        }
    }
}
