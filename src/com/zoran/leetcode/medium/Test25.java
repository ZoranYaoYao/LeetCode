package com.zoran.leetcode.medium;

/**
 * ��תͼ��
 * https://leetcode-cn.com/submissions/detail/6369473/
 * 
 * [Solution]
 * https://www.cnblogs.com/Xieyang-blog/p/9015493.html
 * 
 * ��������ת���� �����ҹ��� �仯ֵ
 */
public class Test25 {

	public static void main(String[] args) {
		Test25 test25 = new Test25();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		test25.rotate(matrix);

		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(""+ matrix[i][j]+",");
				if(j==matrix[0].length-1) System.out.println();
			}
		}
	}

	/**
	 * ���÷�����ȥ�ı��βε����õ�ַ �ǲ���ı�ʵ�ε����õ�ַ�� 
	 */
	public void rotate(int[][] matrix) {
		int[][] rotateMatrix = new int[matrix.length][matrix[0].length];
		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				rotateMatrix[j][matrix[0].length-1 - i] = matrix[i][j];
			}
		}

		matrix =  rotateMatrix;
	}
}

class Nice_Test25 {
	public void rotate(int[][] matrix) {
		int n= matrix.length;
		if (n<=1) return;
		
		int x = (n-1)/2;
		for (int i=0; i<=x; i++) {  //Core.������
			int[] temp = matrix[i];
			matrix[i] =  matrix[n-1-i];
			matrix[n-1-i] = temp;
		}
		
		for (int i=0; i< n; i++) { //���ŶԽ��߶��۽���
			for(int j=i+1; j<n; j++) { //Core. j=i+1, ��ʾÿ�еĶԽ���֮������ݽ��з�ת
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
}