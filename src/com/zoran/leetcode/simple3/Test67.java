package com.zoran.leetcode.simple3;

/**
 * Nim��Ϸ 
 * https://leetcode-cn.com/submissions/detail/3512977/
 */
public class Test67 {

	/**
	 * 2������ʯͷһ��������4��,������4�ı���
	 * ��һ������,������������4�ı���ʱ,������ݶԷ��ö���,���в���4����.
	 * Core:��ʯͷ�Ӻ�����ǰ��.��ǰ�����Ҫ��һ��1-2-3������
	 *      ��˼��˭����4�Ŀ�ʼ,˭�ͻ���! 
	 *      ����: 6, �Լ���2, Ȼ��ʼ4�ı���,�Է���4��ʼ,���ԶԷ���
	 */
	public boolean canWinNim(int n) {
		int remainNum = n - ((n/4) *4);
		if(remainNum == 0) return false;
		return true;
	}
	
}
