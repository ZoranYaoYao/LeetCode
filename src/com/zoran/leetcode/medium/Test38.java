package com.zoran.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/6880937/
 * 
 * Nice:
 * LeetCode submit
 */
public class Test38 {
    public void setZeroes(int[][] matrix) {
        //��2��һά����ֱ𱣴���,�еı任
        if(matrix == null || matrix.length == 0) return;
        
        int[] changeRow = new int[matrix.length];
        int[] changeCol = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    changeRow[i] = -1;
                    changeCol[j] = -1;
                }
            }
        }
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(changeRow[i] == -1) {
                    matrix[i][j] = 0;
                }
                if(changeCol[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/**
 * ����Set��������֤,ֻ�г����ռ�
 */
class Nice_Test38 {
	
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		
		int m=matrix.length; int n = matrix[0].length;
		Set<Integer> lineMark = new HashSet<>();
		Set<Integer> portMark = new HashSet<>();
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if(matrix[i][j] == 0) {
					lineMark.add(i);
					portMark.add(j);
				}
			}
		}
		
		for(Integer line: lineMark) { //Nice. ֻ�ı���ĵ���
			for(int j=0; j<n; j++) {
				matrix[line][j] =0;
			}
		}
		
		for(Integer port: portMark) {
			for (int i=0; i<m; i++) {
				matrix[i][port] =0;
			}
		}
	}
}
