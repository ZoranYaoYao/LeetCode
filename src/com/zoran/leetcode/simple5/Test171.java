package com.zoran.leetcode.simple5;

import java.util.Arrays;
import java.util.List;

/**
 * 图像渲染
 * https://leetcode-cn.com/submissions/detail/5360622/
 * 
 * 问题1: else if() 多条件的处理, 逻辑问题
 * 问题2: String length()
 * 		   数组长度  length;  也是对象!
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
     *  问题点:  4个方向是 多选择的, 不是 else if(), 多个条件中,单选!!
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
        if(sc+1<image[0].length && image[sr][sc+1] == origionColor) { //列的长度判断, image[0].length
            image[sr][sc+1] = newColor;
            floodFill(image, sr, sc+1, newColor, origionColor);
        }
        if(sr-1>= 0 && image[sr-1][sc] == origionColor) {
            image[sr-1][sc] = newColor;
            floodFill(image, sr-1, sc, newColor, origionColor);
        }
        if(sr+1<image.length && image[sr+1][sc] == origionColor) {  //行的长度判断 image.length
            image[sr+1][sc] = newColor;  //??
            floodFill(image, sr+1, sc, newColor, origionColor);
        }
    }
}
