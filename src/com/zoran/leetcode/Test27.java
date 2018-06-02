package com.zoran.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * �������
 * https://leetcode-cn.com/submissions/detail/2827292/
 *
 */
public class Test27 {
	//	����������У�ÿ�����������Ϸ������Ϸ������ĺ͡�
	//
	//	ʾ��:
	//
	//	����: 5
	//	���:
	//	[
	//	     [1],
	//	    [1,1],
	//	   [1,2,1],
	//	  [1,3,3,1],
	//	 [1,4,6,4,1]
	//	]

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	/**
	 * core : ÿ��������һ�����ݶ�������һ�ŵ�����
	 */
	public static List<List<Integer>> generate(int numRows) {
		if(numRows <= 0) return null;

		List<List<Integer>> list = new ArrayList<>();
		List<Integer> previousList = new ArrayList<>();
		for(int i = 1; i <= numRows; i++) {
			previousList = generateItem(previousList, i);
			list.add(previousList);
		}

		return list;
	}

	private static List<Integer> generateItem(List<Integer> previousList, int numRows) {
		List<Integer> list = new ArrayList<>();
		if(numRows == 1) {
			list.add(1); return list;
		}

		for(int i = 0; i < previousList.size(); i++) {
			if(i == 0) {
				list.add(1);
				continue;
			} 
			list.add(previousList.get(i -1) + previousList.get(i));
		}
		list.add(1); //core���Ԫ��

		return list;
	}
}
