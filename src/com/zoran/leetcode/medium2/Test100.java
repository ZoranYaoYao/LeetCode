package com.zoran.leetcode.medium2;

/**
 * ���������
 * https://leetcode-cn.com/submissions/detail/8437651/
 */
public class Test100 {

	public static void main(String[] args) {
		char[][] chars = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
		Test100 test100 = new Test100();
		int res = test100.maximalSquare(chars);
		System.out.println(res);
		
	}

	public int maximalSquare(char[][] matrix) {
		//���, ��¼ÿ��λ�����ϵ���
		//����: ��2��ʼ�������󵽱߽�!
		if (matrix == null || matrix.length ==0) return 0;

		int max = 0;
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if (matrix[i][j] == '0') continue;
				System.out.println("i=" + i + ",j=" + j + " ,  " + iterator(matrix, i, j));
				max = Math.max(max, iterator(matrix, i, j));
			}
		}

		return max*max;
	}

	private int iterator(char[][] matrix,int i, int j) {
		int maxWidth = matrix[0].length - j;
		
		for(int k=2; k<=maxWidth; k++) {
			if(!fill(matrix, i, j, k)) return k-1;
		}
		
		return maxWidth;
	}
	
	private boolean fill(char[][] matrix, int i, int j, int width) {
		
		for(int m =i; m<i+width;m++) {   //Core. λ������ֵ
			for(int n=j; n<j+width; n++) {
				if(m >= matrix.length || n > matrix[0].length || matrix[m][n] == '0') return false; //�߽�����
			}
		}
		
		return true;
	}
	
	//�㷨������: ��Ӧ�ò㼶����
	//		char[][] chars = {{'0','0','1','0'},{'1','1','1','1'},{'1','1','1','1'},{'1','1','1','0'},{'1','1','0','0'},{'1','1','1','1'},{'1','1','1','0'}};
	private int iterator_Old(char[][] matrix,int i, int j) {
		int width = Integer.MAX_VALUE;
		int height =Integer.MAX_VALUE;
		//����˼��
		for(int m=i; m<matrix.length; m++){
			int temp = 1;
			for(int n=j+1; n<matrix[0].length; n++) {
				if(matrix[m][n] != '0') {
					temp++;
				} else break;
			}
			width = Math.min(width, temp);
		}

		//�б���
		for(int m=j; m<width; m++){  //ע���������j, �б���С��width!
			int temp = 1;
			for(int n=i+1; n<matrix.length; n++) {
				if (matrix[n][m] != '0') {
					temp++;
				} else break;
			}
			height = Math.min(height, temp);
		}

		return Math.min(width, height);
	}

}
