package com.zoran.leetcode.simple5;

/**
 * 三维形体投影面积
 * https://leetcode-cn.com/submissions/detail/5842526/
 * 
 * [Solution]
 * https://segmentfault.com/a/1190000015890385?utm_source=tag-newest
 */
public class Test203 {

    public int projectionArea(int[][] grid) {
        int result=0;
        int xy=0;//顶部投影面积，对应二维数组不为0的元素个数
        int yz=0;//前面投影面积，对应二维数组每行元素的最大值之和
        int xz=0;//侧面投影面积，对应二维数组每列元素的最大值之和
        for(int i=0;i<grid.length;i++){//按行遍历二维数组
            int maxLineValue=0;
            for (int j=0;j<grid[i].length;j++){
                if (grid[i][j]!=0){
                    ++xy;
                }
                if(maxLineValue<grid[i][j]){
                    maxLineValue=grid[i][j];
                }
            }
            yz+=maxLineValue;
        }
        for(int i=0;i<grid[0].length;i++){//按列遍历二维数组
            int maxRowValue=0;
            for(int j=0;j<grid.length;j++){
                if(maxRowValue<grid[j][i]){
                    maxRowValue=grid[j][i];
                }
            }
            xz+=maxRowValue;
        }
        result=xy+yz+xz;
        return result;
    }
}
