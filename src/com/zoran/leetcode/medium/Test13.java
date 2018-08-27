package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������
 * https://leetcode-cn.com/submissions/detail/6119187/
 * 
 * [Solution]
 * https://leetcode-cn.com/problems/generate-parentheses/solution/
 * 
 * �ݹ�����ѡ����ַ������� (���ƶ������ĵݹ����)
 */
public class Test13 {

	/**
	 * ��������� 
	 */
	public List<String> Nice_generateParenthesis(int n) {
		List<String> combinations = new ArrayList<>();
		generateAll(new char[2*n], 0, combinations);
		return combinations;
	}

	private void generateAll(char[] current, int pos, List<String> result) {
		if(pos == current.length) {
			if(valid(current))
				result.add(new String(current));
		} else {
			current[pos] = '(';
			generateAll(current, pos+1, result); //Core. ����������������һ��
			current[pos] = ')'; //Core. ��ǰpos+1��λ��,������2��ѡ��, ���Խ����û�!
			generateAll(current, pos+1, result); 
		}
	}

	private boolean valid(char[] current) {
		int banlance = 0;
		for(char c: current) {
			if (c == '(') banlance++;
			else banlance--;
			if(banlance<0) return false;
		}
		
		return banlance==0;
	}
}
