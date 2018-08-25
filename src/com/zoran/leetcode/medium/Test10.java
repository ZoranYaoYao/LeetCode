package com.zoran.leetcode.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * �绰�������ĸ���
 * https://leetcode-cn.com/submissions/detail/6044997/
 * 
 * [��ϲ������㷨]
 * ��ǰ�ľɼ�����Ϊ���� + �ݹ�����γ��¼���
 * 
 * ��ϲ��������� �������ϵļ�������µ�ѡ���γ� �µļ���
 */
public class Test10 {

	public static void main(String[] args) {
		Test10 test10 = new Test10();
		List<String> list = test10.letterCombinations("234");
		System.out.println(list);
		System.out.println(list.size());
	}

	String[] strCompent = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	String origin;
	List<StringBuilder> listSB = new ArrayList<>();
	public List<String> letterCombinations(String digits) {
		//������п�����
		List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0) return result;
		origin = digits;
		int cur = 0;
		selectACharacter(listSB, Integer.parseInt(digits.charAt(cur)+""), cur);
		for(StringBuilder item: listSB) result.add(item.toString());
		return result;
	}

	//�����: �ַ���εݹ����
	public void selectACharacter(List<StringBuilder> old,int number,int next) {
		String str = strCompent[number];
		List<StringBuilder> list = new ArrayList<>();
		if(old.size() == 0) {
			for(int i=0; i<str.length(); i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(str.charAt(i));
				list.add(sb); //����: sb���������ַ���ʱ,��ӽ���
			}
		} else {
			for(int i=0; i<str.length(); i++) {
				for(StringBuilder item: old) {
					StringBuilder sb = new StringBuilder(item.toString());
					sb.append(str.charAt(i));
					list.add(sb); //����: sb���������ַ���ʱ,��ӽ���
				}
			}
		}

		next++;
		if(next <= origin.length()-1) {
			selectACharacter(list, Integer.parseInt(origin.charAt(next)+""), next);
		} else {
			listSB = list;
		}

	}
}
