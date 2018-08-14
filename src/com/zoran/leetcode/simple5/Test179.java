package com.zoran.leetcode.simple5;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ĸ��Сдȫ����
 * https://leetcode-cn.com/submissions/detail/5523286/
 * 
 * [Solution]
 * https://blog.csdn.net/w8253497062015/article/details/80003706
 * 
 * ��ϲ��� -> �ݹ�
 * ̫nb
 */
public class Test179 {

	public List<String> letterCasePermutation(String S) {
		List<String> result = new ArrayList<>();
		if(S.length() == 0) {
			result.add(""); return result;
		}
		
		helper(result, S.toCharArray(), 0);
	}

	//�ݹ鴦������
	private void helper(List<String> result, char[] S, int i) {
		if (i >= S.length) {
			result.add(String.valueOf(S));
			return;
		}
		
		if(S[i] >= 'A' && S[i] <= 'Z') {
			S[i] += 32;  //Core. ��ת����ĸ  , ����ת������֮��, �ڼ�������
			helper(result, S, i+1); 
			S[i] -= 32;
		} else if (S[i] >= 'a' && S[i] <= 'z') {
			S[i] -= 32;
			helper(result, S, i+1);
			S[i] += 32;
		}
		helper(result, S, i+1);
	}
}
