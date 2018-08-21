package com.zoran.leetcode.simple5;

/**
 * ��ά����ͶӰ���
 * https://leetcode-cn.com/submissions/detail/5842526/
 * 
 * [Solution]
 * https://segmentfault.com/a/1190000015890385?utm_source=tag-newest
 */
public class Test203 {

    public int projectionArea(int[][] grid) {
        int result=0;
        int xy=0;//����ͶӰ�������Ӧ��ά���鲻Ϊ0��Ԫ�ظ���
        int yz=0;//ǰ��ͶӰ�������Ӧ��ά����ÿ��Ԫ�ص����ֵ֮��
        int xz=0;//����ͶӰ�������Ӧ��ά����ÿ��Ԫ�ص����ֵ֮��
        for(int i=0;i<grid.length;i++){//���б�����ά����
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
        for(int i=0;i<grid[0].length;i++){//���б�����ά����
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
