package com.zoran.leetcode.medium3;

/**
 * ��֤��������ǰ�����л�
 * https://leetcode-cn.com/submissions/detail/8939008/
 * 
 * [Solution]
 * https://blog.csdn.net/LaputaFallen/article/details/80025590
 * 
 *  ��������, ����,���������ϵ
 * ��֤�Ƿ����Ը���: if (--diff < 0) return false; ���<0 , �򲻻ṹ��һ����!! 
 */
public class Test132 {

}

class Nice_Test132 {
	
	public static void main(String[] args) {
		Nice_Test132 test132 = new Nice_Test132();
		boolean res = test132.isValidSerialization("1"); //1������������
		System.out.println(res);
	}
	public boolean isValidSerialization(String preorder) {
		String[] nodes = preorder.split(",");
		int diff = 1; //Core. diff = ��ǰ�����ڵ���Ⱥ� - ��ǰ�����ڵ���Ⱥ�
		
		for (String node: nodes) {
			if (--diff < 0) return false;
			if (!node.equals("#")) diff += 2;
		}
		
		return diff == 0;
	}
}
