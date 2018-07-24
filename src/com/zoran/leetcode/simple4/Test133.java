package com.zoran.leetcode.simple4;

/**
 * 范围求和 II
 * https://leetcode-cn.com/submissions/detail/4598202/
 * 
 * [Solution]
 * https://blog.csdn.net/w8253497062015/article/details/80561307
 */
public class Test133 {

	/**
	 * 按题意遍历 : 超时
	 * 	40000
		40000
		[]
	 */
    public int maxCount(int m, int n, int[][] ops) {
        if(m == 0 && n == 0) return 0;
        
        int[][] source = new int[m][n];
        for(int i = 0; i < ops.length; i++) {
            int[] opsRow = ops[i];
            int x = opsRow[0];
            int y = opsRow[1];
            for(int v = 0; v < x; v++) {
                for(int g = 0; g < y; g++) {
                    source[v][g]++;
                }
            }
        }
        
        int maxNumber =  source[0][0]; int count =0;
        for(int i=0; i< source.length;i++) {
            for(int j=0; j<source.length;j++) {
                if(source[i][j] == maxNumber) count++;
            }
        }
        
        return count;
    }
    
    public int Nice_maxCount(int m, int n, int[][] ops) {
    	if(ops.length == 0) {
    		return m*n;
    	}
    	
    	int mina = ops[0][0];
    	int minb = ops[0][1];
    	for(int i =1; i< ops.length; i++) {
    		mina = Math.min(ops[i][0], mina);
    		minb = Math.min(ops[0][i], minb);
    	}
    	return mina*minb;
    }
}
