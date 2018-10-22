package com.zoran.leetcode.medium3;

/**
 * �������
 * https://leetcode-cn.com/submissions/detail/8526095/
 * 
 * [Solution]
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51340957
 * 
 * Core. �ж�ʲô������н���, �ҹ���
 * ����AB����,˭��ǰ,˭�ں�, ����Math����ȥ�ж�2�����ε�λ��
 */
public class Test102 {

	public static void main(String[] args) {
		Test102 test102 = new Test102();
		int res = test102.computeArea(
				-2
				,-2
				,2
				,2
				,-4
				,-4
				,-3
				,-3);
		System.out.println(res);
	}

	//Elicpse ������ȷ, LeetCode ���д���?
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//2��������� - �ص����
		int are1 = (C-A) * (D-B);
		int are2 = (G-E) * (H-F);
		int muti = 0;
		if (E<C && E>=A && H<=D && H>=B) {
			muti =  (C-E) * (H-B);
		}

		return are1 + are2 - muti;
	}
}

class Nice_Test102 {
	//��2�����
	public int computeArea (int A, int B, int C, int D, int E, int F, int G, int H) {
		int s = (C-A)*(D-B) + (G-E)*(H-F);
		if (C<=E || F>=D || B>=H || A>=G) return s;
		
		int topX = Math.min(C, G);
		int topY = Math.min(D, H);
		int bottomX = Math.max(A, E);
		int bootomY = Math.max(B, F);
		return s - (topX-bottomX)*(topY-bootomY);
	}
}