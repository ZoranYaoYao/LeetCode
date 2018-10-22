package com.zoran.leetcode.medium3;

/**
 * 矩形面积
 * https://leetcode-cn.com/submissions/detail/8526095/
 * 
 * [Solution]
 * https://blog.csdn.net/happyaaaaaaaaaaa/article/details/51340957
 * 
 * Core. 判断什么情况会有交集, 找规律
 * 无论AB矩形,谁在前,谁在后, 都用Math函数去判断2个矩形的位置
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

	//Elicpse 运行正确, LeetCode 运行错误?
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		//2个矩形面积 - 重叠面积
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
	//分2种情况
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