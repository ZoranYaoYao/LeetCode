package com.zoran.leetcode.medium4;

import java.util.ArrayList;
import java.util.List;

/**
 * 太平洋大西洋水流问题
 * https://leetcode-cn.com/submissions/detail/10539053/
 *
 * [Solution]
 * https://blog.csdn.net/viscu/article/details/82317111
 */
public class Test170 {

    /**
     * 大数组 超时！
     */
    public List<int[]> pacificAtlantic(int[][] matrix) {
        //判断每个点是否能到达边界
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if(canArrival(matrix, i, j, 0, new int[matrix.length][matrix[0].length])
                        && canArrival(matrix, i, j, 1, new int[matrix.length][matrix[0].length])) {
                    int[] temp = {i,j};
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public boolean canArrival(int[][] matrix, int i, int j, int orientation, int[][] mark) {
        boolean res = false;

        if(orientation == 0) {
            if(i == 0 || j == 0) return true;
        } else {
            if(i == matrix.length-1 || j == matrix[0].length-1) return true;
        }
        //up
        if (i-1>=0 && mark[i-1][j] == 0 && matrix[i][j] >= matrix[i-1][j]){
            mark[i-1][j] = 1;
            res = canArrival(matrix, i-1, j, orientation, mark);
        }
        if(res) return true;
        //under
        if (i+1<matrix.length && mark[i+1][j] == 0 && matrix[i][j] >= matrix[i+1][j]) {
            mark[i+1][j] = 1;
            res = canArrival(matrix, i+1, j, orientation, mark);
        }
        if(res) return true;
        //left
        if (j-1>=0 && mark[i][j-1] == 0 && matrix[i][j] >= matrix[i][j-1]) {
            mark[i][j-1] = 1;
            res = canArrival(matrix, i, j-1, orientation, mark);
        }
        if(res) return true;
        //right
        if (j+1<matrix[0].length && mark[i][j+1] == 0 && matrix[i][j] >= matrix[i][j+1]) {
            mark[i][j+1] = 1;
            res = canArrival(matrix, i, j+1, orientation , mark);
        }

        return res;
    }
}

class Nice_Test170 {
    public boolean[][] vis;
    public boolean[][] vis1;
    public int n,m;
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix.length==0||matrix[0].length==0){
            return new ArrayList<int[]>();
        }
        n=matrix.length;
        m=matrix[0].length;
        boolean[][] path=new boolean[n][m];
        boolean[][] path1=new boolean[n][m];
        vis=new boolean[n][m];
        vis1=new boolean[n][m];
        List<int[]> ans=new ArrayList<int[]>();
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(dfs(i,j,path,matrix,matrix[i][j])&&dfs1(i,j,path1,matrix,matrix[i][j])){
                    ans.add(new int[]{i,j});
                }
            }
        }
        return ans;
    }
    public boolean dfs(int x,int y,boolean[][] path,int[][] matrix,int pre){
        if(x>=n||y>=m){
            return false;
        }
        if(x<0||y<0){
            return true;
        }
        if(matrix[x][y]>pre){
            return false;
        }
        if(vis[x][y]){
            return path[x][y];
        }
        vis[x][y]=true;
        path[x][y]=dfs(x-1,y,path,matrix,matrix[x][y])||dfs(x,y-1,path,matrix,matrix[x][y])
                ||dfs(x+1,y,path,matrix,matrix[x][y])||dfs(x,y+1,path,matrix,matrix[x][y]); //Nice: 一次遍历四个方向的结果
        vis[x][y]=false;
        return path[x][y];
    }

    public boolean dfs1(int x,int y,boolean[][] path,int[][] matrix,int pre){
        if(x<0||y<0){
            return false;
        }
        if(x>=n||y>=m){
            return true;
        }
        if(matrix[x][y]>pre){
            return false;
        }
        if(vis1[x][y]){
            return path[x][y];  //Nice_core. 通过path数组，缓存当前位置的结果值
        }
        vis1[x][y]=true;
        path[x][y]=dfs1(x-1,y,path,matrix,matrix[x][y])||dfs1(x,y-1,path,matrix,matrix[x][y])
                ||dfs1(x+1,y,path,matrix,matrix[x][y])||dfs1(x,y+1,path,matrix,matrix[x][y]);
        vis1[x][y]=false; //Nice. 遍历递归
        return path[x][y];
    }
}
