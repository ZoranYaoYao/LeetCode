package com.zoran.leetcode.simple3;

/**
 * �ַ����еĵ�����
 * https://leetcode-cn.com/submissions/detail/3694574/
 */
public class Test89 {
	public static void main(String[] args) {
		System.out.println(Nice_countSegments("i am	lusy"));
		System.out.println(Nice_countSegments("i  am	 lusy"));
		System.out.println(Nice_countSegments("i am, , ,,lusy"));
	}

	public static int Nice_countSegments(String s) {
		String[] strings = s.split(" ");  
		int res = 0;
		for (String string : strings) {
			if (!string.equals("")) { //Core. ����ո�ʱ,�ָ����������ڿո��ַ���
				res++;
			}
		}
		return res;
	}
}
