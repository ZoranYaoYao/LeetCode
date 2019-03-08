package com.zoran.leetcode.simple6;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * ���õ�����
 * https://leetcode-cn.com/submissions/detail/14173547/
 *
 * [Nice_Solution]
 * ��������Queue����Ҫ������¼�������ȡ����ӵĴ���
 */
public class Test240 {

    public static void main(String[] args) {
        Test240 test240 = new Test240();
        int[][] grid = {{1},{1},{1},{1}};
        int res = test240.orangesRotting(grid);
        System.out.println(res);
    }

    /**
     * ����ʱ������
     */
    int refresh = 0;
    public int orangesRotting(int[][] grid) {
        //��¼���ʸ��������εݼ�

        for (int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    if ((row == 0 || (row-1>=0 && grid[row-1][col] == 0))
                            && (row == grid.length-1  || (row+1<grid.length && grid[row+1][col] == 0))
                            && (col == 0 || (col-1>=0 && grid[row][col-1] == 0))
                            && (col == grid[0].length-1  || (col+1<grid[0].length && grid[row][col+1] == 0))) {
                        return -1;
                    } else {
                        refresh++;
                    }
                }
            }
        }

        int res = 0;
        int temp = refresh;
        boolean first = true;
        while(refresh > 0) {
            for (int row=0; row<grid.length; row++) {
                for(int col=0; col<grid[0].length; col++) {
                    if(grid[row][col] == 2) {
                        mark(grid,row,col);
                    }
                }
            }

            for (int row=0; row<grid.length; row++) {
                for(int col=0; col<grid[0].length; col++) {
                    if(grid[row][col] == -1) {
                        grid[row][col] = 2;
                        refresh--;
                        first = false;
                    }
                }
            }
            if (refresh == temp) return first ? -1 : res;
            res++;
        }

        return res;
    }

    public void mark(int[][] grid, int x, int y) {
        if (x+1<grid.length && grid[x+1][y] == 1) {
            grid[x+1][y] = -1;
        }
        if (x-1>=0 && grid[x-1][y] == 1) {
            grid[x-1][y] = -1;
        }
        if (y-1>=0 && grid[x][y-1] == 1) {
            grid[x][y-1] = -1;
        }
        if (y+1<grid[0].length && grid[x][y+1] == 1) {
            grid[x][y+1] = -1;
        }
    }
}

class LeetCode_Test240 {

    int[] dr = new int[]{-1,1,0,0}; //Core �������ҷ���
    int[] dc = new int[]{0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;

        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap<>();
        for (int r=0; r<R; r++) {
            for (int c=0; c<C; c++) {
                if (grid[r][c] == 2) {
                    //Nice_core ͬʱ����r��c����λ�ã���
                    int code = r*C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c=code % C;
            //Nice_core ��4��������2�������ʾ���ϲ�����һ�𣡣�
            for (int k=0; k<4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                //ȡֵ��Χ�������ȷ��ʾ��ʽ
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row : grid) {
            for (int v : row)
                if (v == 1)
                    return -1;
        }

        return ans;
    }
}

